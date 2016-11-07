package Desafio_4;

import java.util.Date;
import java.util.Iterator;

public class Consumidor extends Thread {
	private Buffer buffer;
	private int id;

	public Consumidor(Buffer buffer, int id) {
		this.buffer = buffer;
		this.id = id;

	}

	@Override
	public void run() {
		boolean processamento = true;

		while (processamento) {

			Pedido pedido;
			try {
				pedido = buffer.get((long) id);
				pedido.getLog().setIdConsumidor((long) id);
				try {

					Thread.sleep(3000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pedido.getLog().setHoraFinal(new Date());
				buffer.imprimePedido(pedido);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}
	}

}

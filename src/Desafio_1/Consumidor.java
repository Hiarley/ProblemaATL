package Desafio_1;

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

			Pedido pedido = buffer.removePedido((long) id);
			 
			pedido.getLog().setIdConsumidor((long) id);
			try {

				Thread.sleep(30);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pedido.getLog().setHoraFinal(new Date());
			buffer.imprimePedido(pedido);

		}
	}

}

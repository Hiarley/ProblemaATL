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
		Pedido pedido;
		try {
			
			pedido = buffer.get((long) id);
			pedido.getLog().setIdConsumidor((long) id);
			while (processamento) {

				Thread.sleep(3000);
				pedido.getLog().setHoraFinal(new Date());
				buffer.imprimePedido(pedido);
				pedido = buffer.get((long)id);
				pedido.getLog().setIdConsumidor((long) id);


			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

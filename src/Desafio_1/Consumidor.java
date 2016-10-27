package Desafio_1;
import java.util.Date;
import java.util.Iterator;

public class Consumidor extends Thread {
	private Buffer buffer;	
	private int id;

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
		this.id = 1;
		
	}

	@Override
	public void run() {
		boolean processamento = true;

		while (processamento) {
			Pedido pedido = buffer.getPedido();
			if(!buffer.getPedidos().isEmpty() && pedido.getConsumido() == 0){			
				pedido.setConsumido(1);
				try {	
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				buffer.removePedido(pedido,buffer.getLog().get(0));
			}
		}
	}

}

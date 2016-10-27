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
			Pedido pedido;
			try {
				pedido = buffer.getPedido();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				pedido = null;
			}
			if(!buffer.getPedidos().isEmpty() && pedido.getConsumido() == 1){			
				try {	
					buffer.getLog().get(0).setIdConsumidor((long) id);
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

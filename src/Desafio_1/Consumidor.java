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
			if(!buffer.getPedidos().isEmpty()){			
				try {
					
					Pedido pedido = buffer.getPedidos().get(0);
					buffer.getPedidos().remove(0);
					Log log = buffer.getLog().get(0);
					buffer.getLog().remove(0);
					log.setIdConsumidor((long) id);
					Thread.sleep(3000);
					buffer.removePedido(pedido, log);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}
	}

}

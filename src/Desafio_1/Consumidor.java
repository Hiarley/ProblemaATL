package Desafio_1;
import java.util.Date;

public class Consumidor extends Thread {
	private Buffer buffer;	

	public Consumidor(Buffer buffer) {
		this.buffer = buffer;
		
	}

	@Override
	public void run() {
		boolean processamento = true;

		while (processamento) {
			if(!buffer.getPedidos().isEmpty()){			
				
				try {	
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				buffer.removePedido(buffer.getPedidos().get(0),buffer.getLog().get(0));
			}
		}
	}

}

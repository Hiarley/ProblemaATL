package Desafio_1;
import java.util.Date;

public class Consumidor implements Runnable {
	private Buffer buffer;
	private Log log;

	public Consumidor(Buffer buffer, Log log) {
		this.buffer = buffer;
		this.log = log;
	}

	@Override
	public void run() {
		boolean processamento = true;
		while (processamento) {
			log.setHoraIncial(new Date());
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffer.removePedido(log);
		}
	}

}

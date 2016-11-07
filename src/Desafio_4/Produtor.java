package Desafio_4;

public class Produtor extends Thread{
	private Long identificador;
	private Buffer buffer;

	public Produtor(Buffer buffer, Long identificador) {
		this.buffer = buffer;
		this.identificador = identificador;
	}
	
	@Override
	public void run(){
		while(true){
			try {
				buffer.inserePedido(new Pedido("Pedido Enchendo Buffer." ));
				Thread.sleep(3000);
			}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

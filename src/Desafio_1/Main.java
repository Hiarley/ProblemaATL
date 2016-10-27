package Desafio_1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		ArrayList<Pedido> pedidos = new ArrayList<>(5000);
		int i=0;
		while(i!=5000){
			buffer.inserePedido(new Pedido((long) i, "Testando a funcionalidade."), new Log());
			
			i++;
		}

		Consumidor consumidor = new Consumidor(buffer);
		Consumidor consumidor2 = new Consumidor(buffer);
		
		consumidor.start();
		consumidor2.start();
	}

}

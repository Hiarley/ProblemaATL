package Desafio_1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		int i=0;
		while(i!=5000){
			buffer.inserePedido(new Pedido((long) i, "Testando a funcionalidade."), new Log());
			
			i++;
		}

		Consumidor consumidor = new Consumidor(buffer, 1);
		Consumidor consumidor2 = new Consumidor(buffer, 2);
		
		consumidor.start();
		consumidor2.start();
	}

}

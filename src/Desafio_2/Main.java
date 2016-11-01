package Desafio_2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();


		int num_produtores = 3;
		Produtor produtores[] = new Produtor[num_produtores];

		for (int j = 0; j < num_produtores; j++) {
			produtores[j] = new Produtor( buffer, (long) j);
		}

		for (int j = 0; j < num_produtores; j++) {
			produtores[j].start();
		}	
		
		
		int num_consumidores = 10;
		Consumidor consumidores[] = new Consumidor[num_consumidores];

		for (int j = 0; j < num_consumidores; j++) {
			consumidores[j] = new Consumidor( buffer, j);
		}

		for (int j = 0; j < num_consumidores; j++) {
			consumidores[j].start();
		}
	}

}

package Desafio_1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		int i = 1;
		while (i != 5000) {
			buffer.inserePedido(new Pedido((long) i, "Testando a funcionalidade."));

			i++;
		}
		int num_consumidores = 2;
		Consumidor consumidores[] = new Consumidor[num_consumidores];

		for (int j = 0; j < num_consumidores; j++) {
			consumidores[j] = new Consumidor( buffer, j);
		}

		for (int j = 0; j < num_consumidores; j++) {
			consumidores[j].start();
		}
	}

}

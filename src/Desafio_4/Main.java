package Desafio_4;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		int num_Con = 3;
		int num_Prod = 2;
        ExecutorService threadPool = Executors.newFixedThreadPool(num_Con+num_Prod);
        for(int i=0; i< num_Con ; i++){
        	threadPool.execute(new Consumidor(buffer, i));
        }
        
        for(int i = 0 ; i < num_Prod ; i++){
            threadPool.execute(new Produtor(buffer, (long) i));
        }

	}

}

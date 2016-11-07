package Desafio_4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private ArrayBlockingQueue<Pedido> pedidos;
	private int numPedido = 0;	

	public Buffer() {
		pedidos = new ArrayBlockingQueue<Pedido>(5000);

	}

	public synchronized void inserePedido(Pedido pedido) throws InterruptedException {
		while (pedidos.size() > 5000) {
			try {
				System.out.println("Pedido#" + pedido.getIdentificador() + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pedido.getLog().setHoraIncial(new Date());
		pedidos.put(pedido);
		
		System.out.println("inseriu o pedido " + pedido.getIdentificador() + " - Tempo de processamento "
				+ (System.currentTimeMillis()) + " ms\n");
		notifyAll();
	}

	public synchronized Pedido get(Long id) throws InterruptedException {

		while (pedidos.isEmpty()) {
			try {
				System.out.println("consumidor#" + id + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Pedido pedido = pedidos.poll(1, TimeUnit.SECONDS);
		notifyAll();
		return pedido;
		
	}
	
	public void imprimePedido(Pedido pedido){
		
		
	System.out.println("consumidor#" + pedido.getLog().getIdConsumidor() + " removeu o pedido " + pedido.getIdentificador()
			+ " - Hora Inicial: "+pedido.getLog().getHoraIncial()+" Hora Final: "+ pedido.getLog().getHoraFinal() );
	}

	public ArrayBlockingQueue<Pedido> getPedidos() {
		return pedidos;
	}

	public int getPedidosProcessados() {
		return numPedido;
	}



	/**
	 * @param pedidos
	 *            the pedidos to set
	 */
	public void setPedidos(ArrayBlockingQueue<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	/**
	 * @param pedidosProcessados
	 *            the pedidosProcessados to set
	 */
	public void setPedidosProcessados(int numPedido) {
		this.numPedido = numPedido;
	}

	public void incrementeNumPedidos() {
		numPedido++;
	}
	

}

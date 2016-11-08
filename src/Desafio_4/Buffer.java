package Desafio_4;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Buffer {
	private Queue<Pedido> pedidos;
	private int numPedido = 0;

	public Buffer() {
		pedidos = new LinkedList<Pedido>();

	}

	public synchronized void inserePedido() throws InterruptedException {
		while (pedidos.size() > 5000) {
			try {
				System.out.println("Pedido#" + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Pedido pedido = new Pedido("Pedido Enchendo Buffer." );
		pedido.getLog().setHoraIncial(new Date());
		pedidos.add(pedido);

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
		Pedido pedido = pedidos.poll();
		System.out.println("Consumindo pedido"+pedido.getIdentificador());
		notifyAll();
		return pedido;

	}

	public void imprimePedido(Pedido pedido) {

		System.out.println("consumidor#" + pedido.getLog().getIdConsumidor() + " removeu o pedido "
				+ pedido.getIdentificador() + " - Hora Inicial: " + pedido.getLog().getHoraIncial() + " Hora Final: "
				+ pedido.getLog().getHoraFinal());
	}

	public Queue<Pedido> getPedidos() {
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

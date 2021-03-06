package Desafio_3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Buffer {

	private List<Pedido> pedidos;
	private int pedidosProcessados = 0;
	private final Semaphore semaforo;

	public Buffer(Semaphore semaforo) {
		pedidos = new ArrayList<>(5000);
		this.semaforo = semaforo;
	}

	public synchronized void inserePedido(Pedido pedido) throws InterruptedException {
		while (pedidos.size() > 5000) {
			try {
				System.out.println("Pedido#" + pedido.getIdentificador() + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		if(pedidosProcessados != 5000){
		pedido.getLog().setHoraIncial(new Date());
		pedidosProcessados++;
		pedidos.add(pedido);

		System.out.println("inseriu o pedido " + pedido.getIdentificador() + " - Tempo de processamento "
				+ (System.currentTimeMillis()) + " ms\n");
		notifyAll();
		}else{
			wait();
		}
	}

	public Pedido removePedido(Long id) throws InterruptedException {
		Pedido pedido = null;
		semaforo.acquire();
		if (pedidos.isEmpty()) {
			System.out.println("consumidor#" + id + " aguardando...");
		} else {
			Random r = new Random();
			int numero = r.nextInt(pedidos.size());

			pedido = pedidos.get(numero);
			pedidos.remove(numero);
		}
		semaforo.release();
		return pedido;
	}

	public void imprimePedido(Pedido pedido) {

		System.out.println("consumidor#" + pedido.getLog().getIdConsumidor() + " removeu o pedido "
				+ pedido.getIdentificador() + " - Hora Inicial: " + pedido.getLog().getHoraIncial() + " Hora Final: "
				+ pedido.getLog().getHoraFinal());
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public int getPedidosProcessados() {
		return pedidosProcessados;
	}

	/**
	 * @param pedidos
	 *            the pedidos to set
	 */
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	/**
	 * @param pedidosProcessados
	 *            the pedidosProcessados to set
	 */
	public void setPedidosProcessados(int pedidosProcessados) {
		this.pedidosProcessados = pedidosProcessados;
	}
}

package Desafio_4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private List<Pedido> pedidos;
	private int pedidosProcessados = 0;	

	public Buffer() {
		pedidos = new ArrayList<Pedido>(5000);

	}

	public synchronized void inserePedido(Pedido pedido) {
		while (pedidos.size() > 5000) {
			try {
				System.out.println("Pedido#" + pedido.getIdentificador() + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pedido.getLog().setHoraIncial(new Date());
		pedidos.add(pedido);
		
		System.out.println("inseriu o pedido " + pedido.getIdentificador() + " - Tempo de processamento "
				+ (System.currentTimeMillis()) + " ms\n");
		notifyAll();
	}

	public synchronized Pedido removePedido(Long id) {

		while (pedidos.isEmpty()) {
			try {
				System.out.println("consumidor#" + id + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Pedido pedido = pedidos.get(0);
		pedidos.remove(0);
		notifyAll();
		return pedido;
		
	}
	
	public void imprimePedido(Pedido pedido){
		
		
	System.out.println("consumidor#" + pedido.getLog().getIdConsumidor() + " removeu o pedido " + pedido.getIdentificador()
			+ " - Hora Inicial: "+pedido.getLog().getHoraIncial()+" Hora Final: "+ pedido.getLog().getHoraFinal() );
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

package Desafio_1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private List<Pedido> pedidos;
	private int pedidosProcessados = 0;	

	public Buffer() {
		pedidos = new ArrayList<Pedido>(5000);

	}

	public void inserePedido(Pedido pedido) {

		pedido.getLog().setHoraIncial(new Date());
		pedidos.add(pedido);
		
		System.out.println("inseriu o pedido " + pedido.getIdentificador() + " - Tempo de processamento "
				+ (System.currentTimeMillis()) + " ms\n");
	}

	public Pedido removePedido(Long id) {
		Random r = new Random();
		int n = r.nextInt(pedidos.size());
		Pedido pedido = pedidos.get(n);
		pedidos.remove(n);
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

package Desafio_1;
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
	private ArrayList<Log> logs;
	

	public Buffer() {
		pedidos = new ArrayList<Pedido>(5000);
		this.logs = new ArrayList<Log>(5000);

	}

	public synchronized void inserePedido(Pedido pedido, Log log) {
		while (pedidos.size() > 5000) {
			try {
				System.out.println("Pedido#" + pedido.getIdentificador() + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pedidos.add(pedido);
		log.setHoraIncial(new Date());
		log.setIdPedido(pedido.getIdentificador());
		logs.add(log);
		
		System.out.println("inseriu o pedido " + pedido.getIdentificador() + " - Tempo de processamento "
				+ (System.currentTimeMillis()) + " ms\n");
	}

	public synchronized void removePedido(Pedido pedido, Log log) {
		while (pedidos.isEmpty()) {
			try {
				System.out.println("consumidor#" + log.getIdConsumidor() + " aguardando...");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		log.setHoraFinal(new Date());
		System.out.println("consumidor#" + log.getIdConsumidor() + " removeu o pedido " + log.getIdPedido()
				+ " - Hora Inicial: "+log.getHoraIncial()+" Hora Final: "+ log.getHoraFinal() );
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public int getPedidosProcessados() {
		return pedidosProcessados;
	}

	/**
	 * @return the log
	 */
	public ArrayList<Log> getLog() {
		return logs;
	}

	/**
	 * @param log
	 *            the log to set
	 */
	public void setLog(ArrayList<Log> log) {
		this.logs = log;
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

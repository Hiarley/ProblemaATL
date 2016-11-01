package Desafio_2;

import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
	private static final AtomicInteger count = new AtomicInteger(0);
	private Long identificador;
	private String pacoteDados;
	private Log log;

	public Pedido(String pacoteDados) {
		this.identificador = (long) count.incrementAndGet();
		this.pacoteDados = pacoteDados;
		this.log = new Log();
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Log getLog() {
		return log;
	}

	/**
	 * @return the identificador
	 */
	public Long getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador
	 *            the identificador to set
	 */
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the pacoteDados
	 */
	public String getPacoteDados() {
		return pacoteDados;
	}

	/**
	 * @param pacoteDados
	 *            the pacoteDados to set
	 */
	public void setPacoteDados(String pacoteDados) {
		this.pacoteDados = pacoteDados;
	}

}

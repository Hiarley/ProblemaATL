package Desafio_1;

public class Pedido {
	private Long identificador;
	private String pacoteDados;
	private Log log;

	public Pedido(Long identificador, String pacoteDados) {
		this.identificador = identificador;
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

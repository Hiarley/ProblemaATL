package Desafio_1;

public class Pedido {
	private Long identificador;
	private String pacoteDados;
	private int consumido;

	public Pedido(Long identificador, String pacoteDados) {
		this.identificador = identificador;
		this.pacoteDados = pacoteDados;
		consumido = 0;
	}
	
	public void setConsumido(int consumido) {
		this.consumido = consumido;
	}
	
	public int getConsumido() {
		return consumido;
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

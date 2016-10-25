
public class Log {
	private Long identifacao;
	private String horaIncial;
	private String horaFinal;
	private String tempoProcessamento;

	public Log(Long identificacao) {
		this.identifacao = identificacao;
	}

	public void setIdentifacao(Long identifacao) {
		this.identifacao = identifacao;
	}

	public Long getIdentifacao() {
		return identifacao;
	}

	/**
	 * @return the horaIncial
	 */
	public String getHoraIncial() {
		return horaIncial;
	}

	/**
	 * @param horaIncial
	 *            the horaIncial to set
	 */
	public void setHoraIncial(String horaIncial) {
		this.horaIncial = horaIncial;
	}

	/**
	 * @return the horaFinal
	 */
	public String getHoraFinal() {
		return horaFinal;
	}

	/**
	 * @param horaFinal
	 *            the horaFinal to set
	 */
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	/**
	 * @return the tempoProcessamento
	 */
	public String getTempoProcessamento() {
		return tempoProcessamento;
	}

	/**
	 * @param tempoProcessamento
	 *            the tempoProcessamento to set
	 */
	public void setTempoProcessamento(String tempoProcessamento) {
		this.tempoProcessamento = tempoProcessamento;
	}

}

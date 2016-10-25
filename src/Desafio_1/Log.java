package Desafio_1;
import java.util.Date;

public class Log {
	private Long idConsumidor;
	private Long idPedido;

	private Date horaIncial;
	private Date horaFinal;

	public Log(Long idPedido) {
		this.idPedido = idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public void setIdConsumidor(Long idConsumidor) {
		this.idConsumidor = idConsumidor;
	}

	public Long getIdConsumidor() {
		return idConsumidor;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	/**
	 * @return the horaIncial
	 */
	public Date getHoraIncial() {
		return horaIncial;
	}

	/**
	 * @param horaIncial
	 *            the horaIncial to set
	 */
	public void setHoraIncial(Date horaIncial) {
		this.horaIncial = horaIncial;
	}

	/**
	 * @return the horaFinal
	 */
	public Date getHoraFinal() {
		return horaFinal;
	}

	/**
	 * @param horaFinal
	 *            the horaFinal to set
	 */
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

}

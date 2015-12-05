package br.univel.cadastro;

import java.math.BigDecimal;
import java.util.Date;

public class Venda {
	

	private int idCliente;
	private int nroCompra;
	private String nomeCliente;
	private BigDecimal totalCompra;
	private Date dataCompra;
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	/**
	 * @return the nroCompra
	 */
	public int getNroCompra() {
		return nroCompra;
	}
	/**
	 * @param nroCompra the nroCompra to set
	 */
	public void setNroCompra(int nroCompra) {
		this.nroCompra = nroCompra;
	}
	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}
	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	/**
	 * @return the totalCompra
	 */
	public BigDecimal getTotalCompra() {
		return totalCompra;
	}
	/**
	 * @param totalCompra the totalCompra to set
	 */
	public void setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
	}
	/**
	 * @return the dataCompra
	 */
	public Date getDataCompra() {
		return dataCompra;
	}
	/**
	 * @param dataCompra the dataCompra to set
	 */
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
}

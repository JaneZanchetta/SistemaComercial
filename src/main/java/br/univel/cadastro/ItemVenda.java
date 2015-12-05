package br.univel.cadastro;

import java.math.BigDecimal;

public class ItemVenda {
	private int nroCompra;
	public int getNroCompra() {
		return nroCompra;
	}
	public void setNroCompra(int nroCompra) {
		this.nroCompra = nroCompra;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}
	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}
	public BigDecimal getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}
	private int idProduto;
	private String nomeProduto;
	private String categoria;
	private int qtde;
	private BigDecimal custo;
	private BigDecimal vlrUnitario;
	private BigDecimal margemLucro;

}

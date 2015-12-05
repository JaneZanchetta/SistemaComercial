package br.univel.cadastro;

import java.math.BigDecimal;

/**
 * @author Jane Z. 
 * 19 de nov de 2015 23:59:03
 * Classe p/ controle dos itens do pedido em andamento
 *
 */

public class Item {
	private int idProduto;
	private String nomeProduto;
	private int qtde;
	private BigDecimal vlrUnitario;
	private BigDecimal vlrTotal;
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getCusto() {
		return custo;
	}
	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	public BigDecimal getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(BigDecimal margemLucro) {
		this.margemLucro = margemLucro;
	}
	private String categoria;
	private BigDecimal custo;
	private BigDecimal margemLucro;
	
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
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getVlrUnitario() {
		return vlrUnitario;
	}
	public void setVlrUnitario(BigDecimal vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}
	public BigDecimal getVlrTotal() {
		return vlrTotal;
	}
	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

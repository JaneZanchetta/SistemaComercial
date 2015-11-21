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

package br.univel.cadastro;

import java.math.BigDecimal;

public class Produto {
	private int id;
	private String descricao;
	private int codBar;
	private Categoria categoria;
	private Unidade unidade;
	private BigDecimal custo;
	private BigDecimal margemLucro;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodBar() {
		return codBar;
	}
	public void setCodBar(int codBar) {
		this.codBar = codBar;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
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
	
	/**
	 * @Author Jane Z.
	 * 02/11/2015  12:49:26
	 */
	public Produto(int id, String descricao, int codBar, Categoria categoria,
			Unidade unidade, BigDecimal custo, BigDecimal margemLucro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codBar = codBar;
		this.categoria = categoria;
		this.unidade = unidade;
		this.custo = custo;
		this.margemLucro = margemLucro;
	}

}


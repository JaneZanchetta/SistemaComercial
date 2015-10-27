package br.univel.cadastro;

public enum Genero {
	F("Feminino"),
	M("Masculino");

	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	private Genero(String descricao) {
		this.descricao = descricao;
	}

}

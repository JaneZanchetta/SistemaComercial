package br.univel.cadastro;

public enum UF {
	PR("Paran�"), SC("Santa Catarina"), RS("Rio Grande do Sul"), SP("S�o Paulo"), ES(
			"Esp�rito Santo"), RJ("Rio de Janeiro");

	private String nome;

	public String getNome() {
		return nome;
	}

	private UF(String nome) {
		this.nome = nome;
	}
}
	

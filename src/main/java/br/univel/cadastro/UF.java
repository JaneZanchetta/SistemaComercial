package br.univel.cadastro;

public enum UF {
	PR("Paraná"), SC("Santa Catarina"), RS("Rio Grande do Sul"), SP("São Paulo"), ES(
			"Espírito Santo"), RJ("Rio de Janeiro");

	private String nome;

	public String getNome() {
		return nome;
	}

	private UF(String nome) {
		this.nome = nome;
	}
}
	

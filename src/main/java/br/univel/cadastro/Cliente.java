package br.univel.cadastro;

/**
 * 
 * @author jamzanchetta
 *
 */

public class Cliente {
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	private String nome;
	private String telefone;
	private String endereco;
	private String cidade;
	private UF uf;
	private String email;
	private Genero genero;
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public UF getUf() {
		return uf;
	}
	public void setUf(UF uf) {
		this.uf = uf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getId() {
		return id;
	}
	/**
	 * @Author Jane Z
	 * 02/11/2015 12:08:13
	 */

	/**
	 * @Author Jane Z.
	 * 02/11/2015  12:09:28
	 */
	public Cliente(int id, String nome, String telefone, String endereco,
			String cidade, UF uf, String email, Genero genero) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.email = email;
		this.genero = genero;
	}
	
}

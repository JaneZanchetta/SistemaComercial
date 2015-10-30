package br.univel.cadastro;

public interface UsuarioDao {
	public void create (Usuario o);

	public Usuario read (int id);

	public void update (Usuario o);

	public void delete (Usuario o);

	public Usuario search (Usuario o);


}

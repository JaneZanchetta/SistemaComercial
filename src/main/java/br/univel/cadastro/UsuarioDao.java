package br.univel.cadastro;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDao {
	public void create (Usuario o) throws SQLException;

	public Usuario read (int id);

	public void update (Usuario o);

	public void delete (int id) throws SQLException;

	public Usuario search (Usuario o);

	public List<Usuario> liste();

}

package br.univel.cadastro;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Jane Z
 * 30/10/2015 00:05:39
 * Interface para fazer o CRUD da classe Cliente
 */

public interface ClienteDao {

	public void create (Cliente c) throws SQLException;

	public Cliente read (int id);

	public void update (Cliente c);

	public void delete (int id) throws SQLException;

	public Cliente search (Cliente c);

	public List<Cliente> liste(String str);
}

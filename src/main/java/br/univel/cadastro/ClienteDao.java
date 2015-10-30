package br.univel.cadastro;

import java.util.List;

/**
 * @Author Jane Z
 * 30/10/2015 00:05:39
 */

public interface ClienteDao {

	public void create (Cliente c);

	public Cliente read (int id);

	public void update (Cliente c);

	public void delete (Cliente c);

	public Cliente search (Cliente c);

	public List<Cliente> liste();
}

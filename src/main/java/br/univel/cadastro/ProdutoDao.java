/**
 * @Author
 * 02/11/2015  11:07:24
 */
package br.univel.cadastro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jane
 * 02/11/2015 11:07:13
 * Implementação da Interface para fazer o CRUD da classe Produto
 * no Banco de Dados
 */


public interface ProdutoDao {
	
	
	public void create (Produto p) throws SQLException;

	public Produto read (int id);

	public void update (Produto p);

	public void delete (Produto p) throws SQLException;

	public Produto search (Produto p);

	public List<Produto> liste();
	

}

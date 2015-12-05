package br.univel.cadastro;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Jane Z.
 * 28 de nov de 2015 19:57:43
 * Interface para persistencia dos dados de Venda
 */

public interface VendaDAO {
	public int create (Venda v) throws SQLException;

	public Venda read (int nroCompra);

	public void update (Venda v);

	public List<Venda> liste(int op, Object arg);

}

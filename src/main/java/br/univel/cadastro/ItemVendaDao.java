package br.univel.cadastro;

import java.sql.SQLException;
import java.util.List;

public interface ItemVendaDao {
	
	public void create (ItemVenda v) throws SQLException;

	public Venda read (int nroCompra);

	public void update (ItemVenda v);

	public List<Venda> liste(int nrocompra);

}

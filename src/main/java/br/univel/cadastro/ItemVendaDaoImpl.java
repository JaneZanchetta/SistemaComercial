package br.univel.cadastro;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jane Z.  5 de dez de 2015 14:24:28
 * implementa CRUD dos itens vendidos
 */

public class ItemVendaDaoImpl implements ItemVendaDao {
	private ItemVenda v = null;
	private ArrayList<Venda> lista;
	private Connection con = Conexao.abrirConexao();

	@Override
	public void create(ItemVenda v) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("INSERT INTO ItemVenda " + 
		"(NROCOMPRA, IDPRODUTO, NOMEPRODUTO, CATEGORIA, QTDE,CUSTO, VLRUNITARIO,MARGEMLUCRO) "
				+ "VALUES (?,?,?,?,?,?,?,?");
	
		ps.setInt(1, v.getNroCompra());
		ps.setInt(2, v.getIdProduto());
		ps.setString(3, v.getNomeProduto());
		ps.setString(4, v.getCategoria());
		ps.setInt(5, v.getQtde());
		ps.setBigDecimal(5, v.getCusto());
		ps.setBigDecimal(6, v.getVlrUnitario());
		ps.setBigDecimal(7, v.getMargemLucro());
		int res = ps.executeUpdate();

		ps.close();
	}		
	

	@Override
	public Venda read(int nroCompra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ItemVenda v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Venda> liste(int nrocompra) {
		// TODO Auto-generated method stub
		return null;
	}

}

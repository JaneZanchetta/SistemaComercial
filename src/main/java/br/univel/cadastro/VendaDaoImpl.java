package br.univel.cadastro;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Jane Z. 
 * 28 de nov de 2015 20:01:57
 * Implementação da Interface para persistencia dos dados de Venda
 */

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;

public class VendaDaoImpl implements VendaDAO {

	private Venda v = null;
	private ArrayList<Venda> lista;
	private Connection con = Conexao.abrirConexao();

	/**
	 * @author Jane Z. 5 de dez de 2015 00:05:58 Implementação métodos do CRUD
	 * 
	 */
	@Override
	public void create(Venda v) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("INSERT INTO venda " + "(NROCOMPRA, IDCLIENTE, NOMECLIENTE, TOTALCOMPRA, DATACOMPRA) "
				+ "VALUES (default,?,?,?,?)");
		ps.setInt(1, v.getIdCliente());
		ps.setString(2, v.getNomeCliente());
		ps.setBigDecimal(3, v.getTotalCompra());
		ps.setDate(4, (java.sql.Date) new java.util.Date());
		int res = ps.executeUpdate();

		ps.close();
	}

	@Override
	public Venda read(int nroCompra) {
		Statement st = null;
		ResultSet result = null;
		Venda v = new Venda();
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM venda WHERE nrocompra = ?");
				v.setNroCompra(result.getInt("nrocompra"));
				v.setIdCliente(result.getInt("idcliente"));
				v.setNomeCliente(result.getString("nomecliente"));
				v.setTotalCompra(result.getBigDecimal("totalcompra"));
				v.setDataCompra(result.getDate("datacompra"));
				return v;

			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
				return v;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void update(Venda v) {
		String sql = "UPDATE venda SET IDCLIENTE = ?, NOMECLIENTE = ?, TOTALCOMPRA = ?, DATACOMPRA = ?, "
				+ " WHERE NROCOMPRA = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, v.getIdCliente());
			ps.setString(2, v.getNomeCliente());
			ps.setBigDecimal(3, v.getTotalCompra());
			ps.setDate(4, (java.sql.Date) v.getDataCompra());
			ps.setInt(5, v.getNroCompra());

			int res = ps.executeUpdate();
			if (res > 0) {
				JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Operação não realizada!");

			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Venda> liste(int op, Object arg) {
		lista = new ArrayList<Venda>();
		Statement st = null;
		ResultSet result = null;
		int opcao = op;

		try {
			try {
				st = con.createStatement();
				if (opcao == 1) {
					int id = (int) arg;
					result = st.executeQuery("SELECT nrocompra, idcliente, nomecliente, datacompra, totalcompra, "
							+ "  FROM VENDA where nrocompra = id");
				} else {
					Date data = (Date) arg;
					result = st.executeQuery("SELECT nrocompra, idcliente, nomecliente, datacompra, totalcompra, "
							+ "  FROM VENDA where datacompra = data");
				}
				while (result.next()) {
					Venda v = new Venda();
					v.setNroCompra(result.getInt("nrocompra"));
					v.setIdCliente(result.getInt("idcliente"));
					v.setNomeCliente(result.getString("nomecliente"));
					v.setTotalCompra(result.getBigDecimal("totalcompra"));
					v.setDataCompra(result.getDate("datacompra"));
					lista.add(v);

				}
			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
				return lista;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}


package br.univel.cadastro;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @author Jane
 * 02/11/2015 13:48:30
 */
public class ProdutoDaoImpl  implements ProdutoDao {
	private Produto p = null;
	private ArrayList<Produto> lista;
	private Connection con = Conexao.getInstance().abrirConexao();

	/* (non-Javadoc)
	 * @see br.univel.cadastro.ProdutoDao#create(br.univel.cadastro.Produto)
	 */
	@Override
	public void create(Produto p) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("INSERT INTO PRODUTO "
				+ "(ID, DESCRICAO, CODBAR, CATEGORIA, UNIDADE, CUSTO, MARGEMLUCRO) "
				+ "VALUES (default,?,?,?,?,?,?)");
		
		ps.setString(1, p.getDescricao());
		ps.setInt(2, p.getCodBar());
		ps.setString(3, p.getCategoria().toString());
		ps.setString(4, p.getUnidade().toString());
		ps.setBigDecimal(5, p.getCusto());
		ps.setBigDecimal(6, p.getMargemLucro());
		int res = ps.executeUpdate();
		ps.close();
		
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.ProdutoDao#read(int)
	 */
	@Override
	public Produto read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.ProdutoDao#update(br.univel.cadastro.Produto)
	 */
	@Override
	/**
	 * @author Jane
	 * 05/11/2015 00:41:37
	 */
	public void update(Produto p) {
		String sql = "UPDATE produto SET  DESCRICAO = ?, CODBAR = ?, CATEGORIA = ?, "
				+ "UNIDADE = ?, CUSTO = ?, MARGEMLUCRO = ?" + " WHERE ID = ?";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, p.getDescricao());
			ps.setInt(2, p.getCodBar());
			ps.setString(3, p.getCategoria().toString());
			ps.setString(4, p.getUnidade().toString());
			ps.setBigDecimal(5, p.getCusto());
			ps.setBigDecimal(6, p.getMargemLucro());
			ps.setInt(7, p.getId());
			int res = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.ProdutoDao#delete(br.univel.cadastro.Produto)
	 */
	@Override
	/**
	 * @author Jane
	 * 05/11/2015 00:48:11
	 */

	public void delete(Produto p) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("DELETE FROM produto WHERE ID = ?");
		ps.setInt(1, p.getId());
		int res = ps.executeUpdate();
		if (res != 0) {
			JOptionPane.showMessageDialog(null,
					"Opera��o realizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro e o produto n�o foi exclu�do!");
		}
		ps.close();
		
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.ProdutoDao#search(br.univel.cadastro.Produto)
	 */
	@Override
	public Produto search(Produto p) {
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT descricao, codBar, categoria, "
						+ "unidade, custo, margemLucro"
						+ "  FROM produto WHERE ID = ?");
				p.setDescricao(result.getString("Descricao"));
				p.setCodBar(result.getInt("CodBar"));
				p.setCategoria(Categoria.getEnumValue(result.getString("Categoria")));
				p.setUnidade(Unidade.getEnumValue(result.getString("Unidade")));
				p.setCusto(result.getBigDecimal("Custo"));
				p.setMargemLucro(result.getBigDecimal("MargemLucro"));
				p.setId(result.getInt("ID"));

			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.ProdutoDao#liste()
	 */
	@Override
	public List<Produto> liste(String str) {
		lista = new ArrayList<Produto>();
		Statement st = null;
		ResultSet result = null;		
		
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT id, descricao, codBar, categoria, "
						+ "unidade, custo, margemLucro FROM produto where DESCRICAO LIKE '%" + str + "%'");
				while (result.next()) {
					Produto p = new Produto();
					p.setDescricao(result.getString("Descricao"));
					p.setCodBar(result.getInt("CodBar"));
					p.setCategoria(Categoria.getEnumValue(result.getString("Categoria")));
					p.setUnidade(Unidade.getEnumValue(result.getString("Unidade")));
					p.setCusto(result.getBigDecimal("Custo"));
					p.setMargemLucro(result.getBigDecimal("MargemLucro"));
					p.setId(result.getInt("ID"));
					lista.add(p);

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

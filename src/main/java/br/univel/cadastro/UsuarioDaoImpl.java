/**
 * @Author
 * 05/11/2015  22:47:10
 */
package br.univel.cadastro;

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
 * 05/11/2015 22:47:10
 * Classe que implementa a interface criada para o CRUD da classe Usuario. 
 * Utiliza comandos da classe Java.Sql para comunicação com Banco de Dados.
 */

public class UsuarioDaoImpl implements UsuarioDao {

	private Usuario o = null;
	private ArrayList<Usuario> lista;
	private Connection con = Conexao.abrirConexao();

	
	
	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#create(br.univel.cadastro.Usuario)
	 */
	@Override
	public void create(Usuario o) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("INSERT INTO usuario "
				+ "(ID, IDCLIENTE, SENHA) "
				+ "VALUES (default,?,?)");
		ps.setInt(1, o.getIdCliente());
		ps.setString(2, o.getSenha());
		int res = ps.executeUpdate();
		ps.close();
		
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#read(int)
	 */
	@Override
	public Usuario read(int id) {
		Statement st = null;
		ResultSet result = null;
		Usuario o = new Usuario();
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM USUARIO WHERE ID = ?");
				o.setId(result.getInt("Id"));
				o.setIdCliente(result.getInt("IdCliente"));
				o.setSenha(result.getString("Senha"));

			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#update(br.univel.cadastro.Usuario)
	 */
	@Override
	public void update(Usuario o) {
		String sql = "UPDATE usuario SET ID = ?, IDCLIENTE = ?, SENHA = ?  WHERE ID = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, o.getId());
			ps.setInt(2, o.getIdCliente());
			ps.setString(3, o.getSenha());
			ps.setInt(4, o.getId());
			int res = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		
	

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#delete(br.univel.cadastro.Usuario)
	 */
	@Override
	public void delete(int id) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("DELETE FROM usuario WHERE ID = ?");
		ps.setInt(1, id);
		int res = ps.executeUpdate();
		if (res != 0) {
			JOptionPane.showMessageDialog(null,
					"Operação realizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro e o usuario não foi excluído!");
		}
		ps.close();
	}		
	

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#search(br.univel.cadastro.Usuario)
	 */
	@Override
	public Usuario search(Usuario o) {
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT nome, telefone, endereco, "
						+ "cidade, Uf, email, genero"
						+ "  FROM CLIENTE WHERE ID = ?");
				o.setId(result.getInt(1));
				o.setIdCliente(result.getInt("IdCliente"));
				o.setSenha(result.getString("Senha"));

			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
				return o;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#liste()
	 */
	@Override
	public List<Usuario> liste() {
		lista = new ArrayList<Usuario>();
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT id, idcliente, senha FROM USUARIO ");
				while (result.next()) {
					Usuario o = new Usuario();
					o.setId(result.getInt(1));
					o.setIdCliente(result.getInt("IdCliente"));
					o.setSenha(result.getString("Senha"));

					lista.add(o);

				}
			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
				System.out.println(" ERRO ");
				return lista;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

}

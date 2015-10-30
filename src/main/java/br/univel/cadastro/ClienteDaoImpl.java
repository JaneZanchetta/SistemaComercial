package br.univel.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.RA140649.Contato;

/**
 * 
 * @author Jane
 * Classe que implementa a interface criada para o CRUD da classe Cliente. 
 * Utiliza comandos da classe Java.Sql para comunicação
 * com Banco de Dados.
 */
public class ClienteDaoImpl implements ClienteDao {

	
	public void create(Cliente c) {
//		Contato c = (Contato) o;
		Connection con = abrirConexao();
		PreparedStatement ps;
		ps = con.prepareStatement("INSERT INTO CONTATO (ID, NOME, FONE, ENDERECO) VALUES (?,?,?,?)");
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getFone());
		ps.setString(4, c.getEndereco());
		int res = ps.executeUpdate();
		ps.close();
		con.close();		
	}

	public Cliente read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Cliente c) {
		Connection con = abrirConexao();
		Contato c = (Contato) o;
		String sql = "UPDATE CONTATO SET ID = ?, NOME = ?, FONE = ?, ENDERECO = ? WHERE ID = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getFone());
			ps.setString(4, c.getEndereco());
			ps.setInt(5, c.getId());
			int res = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public void delete(Cliente c) {
		Connection con = abrirConexao();
		PreparedStatement ps;
		ps = con.prepareStatement("DELETE FROM CONTATO WHERE ID = ?");
		ps.setInt(1, id);
		int res = ps.executeUpdate();
		if (res != 0) {
			JOptionPane.showMessageDialog(null,
					"Operação realizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro e o contato não foi excluído!");
		}
		ps.close();
		con.close();	
	}

	public Cliente search(Cliente c) {
		Connection con = abrirConexao();
		Statement st = null;
		ResultSet result = null;
		Contato c = new Contato();
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM CONTATO WHERE ID = ?");
				c.setId(result.getInt(1));
				c.setNome(result.getString("Nome"));
				c.setFone(result.getString("Fone"));
				c.setEndereco(result.getString("Endereco"));

			} finally {
				if (st != null)
					st.close();
				if (result != null)
					result.close();
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	return null;
	}

	public List<Cliente> liste() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static Connection con;
	
	private Connection getConnection() {
		
	}
	
	private Connection abrirConexao() {
		synchronized (con) {
			if (con == null) {
				try {
					String url = "jdbc:h2:.\\lib\\trab140649";
					String user = "sa";
					String pass = "sa";

					return DriverManager.getConnection(url, user, pass);

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			return con;
		}
	}
	

}

package br.univel.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



/**
 * 
 * @author Jane
 * Classe que implementa a interface criada para o CRUD da classe Cliente. 
 * Utiliza comandos da classe Java.Sql para comunicação
 * com Banco de Dados.
 */
public class ClienteDaoImpl implements ClienteDao {

	
	private Cliente c = null;
	private ArrayList<Cliente> lista;
	private Connection con = Conexao.abrirConexao();

	public void create(Cliente c) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("INSERT INTO cliente "
				+ "(ID,NOME, TELEFONE, ENDERECO, CIDADE, UF, EMAIL, GENERO) "
				+ "VALUES (default,?,?,?,?,?,?,?)");
		ps.setString(1, c.getNome());
		ps.setString(2, c.getTelefone());
		ps.setString(3, c.getEndereco());
		ps.setString(4, c.getCidade());
		ps.setString(5, c.getUf().toString());
		ps.setString(6, c.getEmail());
		ps.setString(7, c.getGenero().toString());
		int res = ps.executeUpdate();
		
		ps.close();
	}

	public Cliente read(int id) {

		Statement st = null;
		ResultSet result = null;
		Cliente c = new Cliente();
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT * FROM CLIENTE WHERE ID = ?");
				c.setId(result.getInt("Id"));
				c.setNome(result.getString("Nome"));
				c.setTelefone(result.getString("Telefone"));
				c.setEndereco(result.getString("Endereco"));
				c.setCidade(result.getString("Cidade"));
				UF.valueOf(UF.class, result.getString("UF"));
				c.setEmail(result.getString("Email"));
				Genero.valueOf(Genero.class, result.getString("Genero"));
				return c;

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

	public void update(Cliente c) {
		String sql = "UPDATE cliente SET NOME = ?, TELEFONE = ?, ENDERECO = ?, "
				+ "CIDADE = ?, UF = ?, EMAIL = ?, GENERO = ?"
				+ " WHERE ID = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getUf().toString());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().toString());
			ps.setInt(8, c.getId());

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

	public void delete(int id) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement("DELETE FROM cliente WHERE ID = ?");
		ps.setInt(1, id);
		int res = ps.executeUpdate();
		if (res != 0) {
			JOptionPane.showMessageDialog(null,
					"Operação realizada com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null,
					"Ocorreu um erro e o cliente não foi excluído!");
		}
		ps.close();
	}

	/**
	 * @Author Jane Z. 02/11/2015 11:04:51
	 */
	public Cliente search(Cliente c) {
		Statement st = null;
		ResultSet result = null;
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT nome, telefone, endereco, "
						+ "cidade, Uf, email, genero"
						+ "  FROM CLIENTE");
				c.setId(result.getInt(1));
				c.setNome(result.getString("Nome"));
				c.setTelefone(result.getString("Telefone"));
				c.setEndereco(result.getString("Endereco"));
				c.setCidade(result.getString("Cidade"));
				UF.valueOf(UF.class, result.getString("UF"));
				c.setEmail(result.getString("Email"));
				Genero.valueOf(Genero.class, result.getString("Genero"));

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
/**
 * @Author Jane Z. 02/11/2015 11:15:09
 */
	public List<Cliente> liste(String str) {
		lista = new ArrayList<Cliente>();
		Statement st = null;
		ResultSet result = null;
		
		
		try {
			try {
				st = con.createStatement();
				result = st.executeQuery("SELECT id, nome, telefone, endereco, "
						+ "cidade, Uf, email, genero"
						+ "  FROM CLIENTE where NOME LIKE '%" + str + "%'");
				while (result.next()) {
					Cliente c = new Cliente();
					c.setId(result.getInt(1));
					c.setNome(result.getString("Nome"));
					c.setTelefone(result.getString("Telefone"));
					c.setEndereco(result.getString("Endereco"));
					c.setCidade(result.getString("Cidade"));
					c.setEmail(result.getString("Email"));
					for (Genero g : Genero.values()) {
						if (g.toString().equals(result.getString("Genero")))
							c.setGenero(g);
					}
					for (UF uf : UF.values()) {
						if (uf.toString().equals(result.getString("UF")))
							c.setUf(uf); 
					}
					 
					lista.add(c);

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

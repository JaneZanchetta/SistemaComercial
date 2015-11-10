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
				+ "(ID, NOME, TELEFONE, ENDERECO, CIDADE, UF, EMAIL, GENERO) "
				+ "VALUES (?,?,?,?,?,?,?,?)");
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getTelefone());
		ps.setString(4, c.getEndereco());
		ps.setString(5, c.getCidade());
		ps.setString(6, c.getUf().toString());
		ps.setString(7, c.getEmail());
		ps.setString(8, c.getGenero().getDescricao());
		int res = ps.executeUpdate();
		ps.close();
		con.close();		
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
		String sql = "UPDATE cliente SET ID = ?, NOME = ?, TELEFONE = ?, ENDERECO = ?, "
				+ "CIDADE = ?, UF = ?, EMAIL = ?, GENERO = ?"
				+ " WHERE ID = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);

			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getTelefone());
			ps.setString(4, c.getEndereco());
			ps.setString(5, c.getCidade());
			ps.setString(6, c.getUf().toString());
			ps.setString(7, c.getEmail());
			ps.setString(8, c.getGenero().getDescricao());
			ps.setInt(9, c.getId());
			int res = ps.executeUpdate();
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
		con.close();	
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
						+ "  FROM CLIENTE WHERE ID = ?");
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
	public List<Cliente> liste() {
		lista = new ArrayList<Cliente>();
		Statement st = null;
		ResultSet result = null;
		try {
			try {
			st = con.createStatement();
			result = st.executeQuery("SELECT nome, telefone, endereco, "
					+ "cidade, Uf, email, genero"
					+ "  FROM CLIENTE ");
			result.next();
			if (result.getString("ID") != null) {
				lista.add(c = new Cliente
						(result.getInt("Id"), 
				         result.getString("Nome"),
				         result.getString("Telefone"),
				result.getString("Endereco"),
				result.getString("Cidade"),
				UF.valueOf(UF.class, result.getString("UF")),
				result.getString("Email"),
				Genero.valueOf(Genero.class, result.getString("Genero")))); 
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

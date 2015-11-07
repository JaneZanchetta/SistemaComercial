/**
 * @Author
 * 02/11/2015  14:01:51
 */
package br.univel.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jane
 * 02/11/2015 14:01:51
 * Classe para administrar a Conex�o com o Banco de Dados
 */
public class Conexao {

	private static Connection conexao;
	private static Conexao self;
	
	public final synchronized static Conexao getInstance() {
		if (self == null) {
			self = new Conexao();
		}
		return self;
		
	}
	
	public Connection abrirConexao() {
//		synchronized (conexao) {
			if (conexao == null) {
				String driverName = "org.postgresql.Driver";
				String url = "jdbc:postgresql:\\localhost\\Siscom";
				String user = "postgres";
				String pass = "postgres";
				try {
					try {
						Class.forName(driverName);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return DriverManager.getConnection(url, user, pass);

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			return conexao;
		}

//}
	/**
	 * @author Jane
	 * 02/11/2015 14:24:01
	 * fecha Conex�o
	 */

	private void fecharConexao () {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


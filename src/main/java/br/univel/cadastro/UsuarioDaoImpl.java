/**
 * @Author
 * 05/11/2015  22:47:10
 */
package br.univel.cadastro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Jane
 * 05/11/2015 22:47:10
 */
public class UsuarioDaoImpl implements UsuarioDao {

	private Usuario o = null;
	private ArrayList<Usuario> lista;
	private Connection con = Conexao.getInstance().abrirConexao();

	
	
	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#create(br.univel.cadastro.Usuario)
	 */
	@Override
	public void create(Usuario o) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#read(int)
	 */
	@Override
	public Usuario read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#update(br.univel.cadastro.Usuario)
	 */
	@Override
	public void update(Usuario o) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#delete(br.univel.cadastro.Usuario)
	 */
	@Override
	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.univel.cadastro.UsuarioDao#search(br.univel.cadastro.Usuario)
	 */
	@Override
	public Usuario search(Usuario o) {
		// TODO Auto-generated method stub
		return null;
	}

}

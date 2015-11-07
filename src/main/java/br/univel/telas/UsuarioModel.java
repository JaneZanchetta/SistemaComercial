/**
 * @Author
 * 07/11/2015  00:41:43
 */
package br.univel.telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.Usuario;

/**
 * @author Jane
 * 07/11/2015 00:41:43
 */
public class UsuarioModel extends AbstractTableModel {

	public UsuarioModel(ArrayList<Usuario> l) {
		this.lista = l;

	}

	private List<Usuario> lista = new ArrayList<>();

	public List<Usuario> getLista() {
		return lista;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		Usuario u = lista.get(row);
        Cliente c = new Cliente();
		switch (col) {
		case 0:
			return u.getId();
		case 1:
			return u.getIdCliente();
		case 2:
// getNome de que cliente ????
			return c.getNome();

		default:
			return "erro";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.AbstractTableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "ID";
		case 1:
			return "ID CLIENTE";
		case 2:
			return "NOME";

		default:
			return super.getColumnName(col);
		}
	}
}

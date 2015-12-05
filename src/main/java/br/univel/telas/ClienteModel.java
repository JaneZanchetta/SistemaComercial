/**
 * @Author
 * 06/11/2015  00:34:11
 */
package br.univel.telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cadastro.Cliente;

/**
 * @author Jane 06/11/2015 00:34:11
 */
public class ClienteModel extends AbstractTableModel {

	/**
	 * @param list 
	 * @Author Jane Z.
	 * 06/11/2015  23:45:49
	 */
	public ClienteModel(List<Cliente> l) {
		lista = l;

	}	
	
	public  ClienteModel() {
		lista.clear();

	}	



	private List<Cliente> lista = new ArrayList<>();

	public List<Cliente> getLista() {
		return lista;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Cliente c = lista.get(row);

		switch (col) {
		case 0:
			return c.getId();
		case 1:
			return c.getNome();
		case 2:
			return c.getTelefone();
		case 3:
			return c.getEndereco();
		case 4:
			return c.getCidade();
		case 5:
			return c.getUf();
		case 6:
			return c.getEmail();
		case 7:
			return c.getGenero();
			
			

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
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Telefone";
		case 3:
			return "Endereco";
		case 4:
			return "Cidade";
		case 5:
			return "UF";
		case 6:
			return "Email";
		case 7:
			return "Genero";

		default:
			return super.getColumnName(col);
		}

	}
	

}

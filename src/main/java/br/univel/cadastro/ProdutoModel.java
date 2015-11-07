/**
 * @Author
 * 07/11/2015  00:00:39
 */
package br.univel.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * @author Jane 07/11/2015 00:00:39
 */
public class ProdutoModel extends AbstractTableModel {

	private List<Produto> lista = new ArrayList<>();

	public List<Produto> getLista() {
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
		return 7;
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
		Produto p = lista.get(row);

		switch (col) {
		case 0:
			return p.getId();
		case 1:
			return p.getDescricao();
		case 2:
			return p.getCodBar();
		case 3:
			return "CAtegria";
		case 4:
			return p.getCusto();
		case 5:
			return p.getMargemLucro();
		case 6:
			return "UNIADE";

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
			return "DESCRIÇÃO";
		case 2:
			return "CÓDIGO DE BARRAS";
		case 3:
			return "CATEGORIA";
		case 4:
			return "CUSTO";
		case 5:
			return "MARGEM DE LUCRO";
		case 6:
			return "UNIADE";

		default:
			return super.getColumnName(col);
		}
	}

}

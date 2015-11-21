package br.univel.telas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.Item;

public class VendaModel extends AbstractTableModel{

	public VendaModel(List<Item> l) {
		lista = l;

	}	

	
	private List<Item> lista = new ArrayList<>();
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Item i = lista.get(row);

		switch (col) {
	
		case 0:
			return i.getIdProduto();
		case 1:
			return i.getNomeProduto();
		case 2:
			return i.getQtde();
		case 3:
			return i.getVlrUnitario();
		case 4:
			return i.getVlrTotal();
			
		default:
			return "erro";
			
			
		}
	}

	@Override
	public String getColumnName(int col) {
		switch (col) {
		
		case 0:
			return "Id Produto";
		case 1:
			return "Descrição Produto";
		case 2:
			return "Quantidade";
		case 3:
			return "Valor Unitário";
		case 4:
			return "Valor Total";
			
		default:
			
			return super.getColumnName(col);
	}
	
	}	

}

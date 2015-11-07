/**
 * @Author
 * 07/11/2015  02:27:16
 */
package br.univel.telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

/**
 * @author Jane Z.
 * 07/11/2015 02:27:16
 */
public class MioloVenda extends JPanel {
	private JTextField txtIdCliente;
	private JTextField txtNomeCliente;
	private JTextField txtNroVenda;
	private JLabel lblData;
	private JTextField txtDataCompra;
	private JTextField textField;
	private JTextField txtDescricao;
	private JTextField txtQtde;
	private JTextField txtValorUnitario;
	private JLabel lblIdproduto;
	private JLabel lblDescrio;
	private JLabel lblQtde;
	private JLabel lblValorUnitário;
	private JLabel lblValortotal;
	private JTextField txtValorTotal;

	/**
	 * Create the panel.
	 */
	public MioloVenda() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 92, 0, 182, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblData = new JLabel("Data");
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.anchor = GridBagConstraints.EAST;
		gbc_lblData.insets = new Insets(0, 0, 5, 5);
		gbc_lblData.gridx = 0;
		gbc_lblData.gridy = 0;
		add(lblData, gbc_lblData);
		
		txtDataCompra = new JTextField();
		txtDataCompra.setEditable(false);
		GridBagConstraints gbc_txtDataCompra = new GridBagConstraints();
		gbc_txtDataCompra.insets = new Insets(0, 0, 5, 5);
		gbc_txtDataCompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDataCompra.gridx = 1;
		gbc_txtDataCompra.gridy = 0;
		add(txtDataCompra, gbc_txtDataCompra);
		txtDataCompra.setColumns(10);
		
		JLabel lblVenda = new JLabel("Venda");
		GridBagConstraints gbc_lblVenda = new GridBagConstraints();
		gbc_lblVenda.insets = new Insets(0, 0, 5, 5);
		gbc_lblVenda.anchor = GridBagConstraints.EAST;
		gbc_lblVenda.gridx = 4;
		gbc_lblVenda.gridy = 0;
		add(lblVenda, gbc_lblVenda);
		
		txtNroVenda = new JTextField();
		txtNroVenda.setEditable(false);
		GridBagConstraints gbc_txtNroVenda = new GridBagConstraints();
		gbc_txtNroVenda.insets = new Insets(0, 0, 5, 0);
		gbc_txtNroVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroVenda.gridx = 5;
		gbc_txtNroVenda.gridy = 0;
		add(txtNroVenda, gbc_txtNroVenda);
		txtNroVenda.setColumns(10);
		
		JLabel lblIdCliente = new JLabel("Id Cliente");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.anchor = GridBagConstraints.WEST;
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 1;
		add(lblIdCliente, gbc_lblIdCliente);
		
		txtIdCliente = new JTextField();
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.gridx = 1;
		gbc_txtIdCliente.gridy = 1;
		add(txtIdCliente, gbc_txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtNomeCliente = new JTextField();
		GridBagConstraints gbc_txtNomeCliente = new GridBagConstraints();
		gbc_txtNomeCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeCliente.gridx = 3;
		gbc_txtNomeCliente.gridy = 1;
		add(txtNomeCliente, gbc_txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		lblIdproduto = new JLabel("IdProduto");
		GridBagConstraints gbc_lblIdproduto = new GridBagConstraints();
		gbc_lblIdproduto.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdproduto.gridx = 0;
		gbc_lblIdproduto.gridy = 2;
		add(lblIdproduto, gbc_lblIdproduto);
		
		lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 1;
		gbc_lblDescrio.gridy = 2;
		add(lblDescrio, gbc_lblDescrio);
		
		lblQtde = new JLabel("Qtde");
		GridBagConstraints gbc_lblQtde = new GridBagConstraints();
		gbc_lblQtde.insets = new Insets(0, 0, 5, 5);
		gbc_lblQtde.gridx = 2;
		gbc_lblQtde.gridy = 2;
		add(lblQtde, gbc_lblQtde);
		
		lblValorUnitário = new JLabel("Valor Unir\u00E1rio");
		GridBagConstraints gbc_lblValorUnitário = new GridBagConstraints();
		gbc_lblValorUnitário.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorUnitário.gridx = 3;
		gbc_lblValorUnitário.gridy = 2;
		add(lblValorUnitário, gbc_lblValorUnitário);
		
		lblValortotal = new JLabel("ValorTotal");
		GridBagConstraints gbc_lblValortotal = new GridBagConstraints();
		gbc_lblValortotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValortotal.gridx = 4;
		gbc_lblValortotal.gridy = 2;
		add(lblValortotal, gbc_lblValortotal);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setEditable(false);
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.insets = new Insets(0, 0, 0, 5);
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 3;
		add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);
		
		txtQtde = new JTextField();
		GridBagConstraints gbc_txtQtde = new GridBagConstraints();
		gbc_txtQtde.insets = new Insets(0, 0, 0, 5);
		gbc_txtQtde.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQtde.gridx = 2;
		gbc_txtQtde.gridy = 3;
		add(txtQtde, gbc_txtQtde);
		txtQtde.setColumns(10);
		
		txtValorUnitario = new JTextField();
		GridBagConstraints gbc_txtValorUnitario = new GridBagConstraints();
		gbc_txtValorUnitario.insets = new Insets(0, 0, 0, 5);
		gbc_txtValorUnitario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValorUnitario.gridx = 3;
		gbc_txtValorUnitario.gridy = 3;
		add(txtValorUnitario, gbc_txtValorUnitario);
		txtValorUnitario.setColumns(10);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		GridBagConstraints gbc_txtValorTotal = new GridBagConstraints();
		gbc_txtValorTotal.insets = new Insets(0, 0, 0, 5);
		gbc_txtValorTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValorTotal.gridx = 4;
		gbc_txtValorTotal.gridy = 3;
		add(txtValorTotal, gbc_txtValorTotal);
		txtValorTotal.setColumns(10);
		
	}

}

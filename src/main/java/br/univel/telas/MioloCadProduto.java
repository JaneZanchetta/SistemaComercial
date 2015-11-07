/**
 * @Author
 * 05/11/2015  00:17:31
 */
package br.univel.telas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Jane
 * 05/11/2015 00:17:31
 */
public class MioloCadProduto extends JPanel {
	private JTextField txtId;
	private JTextField txtDescricao;
	private JTextField txtCodBar;
	private JTextField txtCusto;
	private JTextField txtMargemLucro;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public MioloCadProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{113, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.BOTH;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 3;
		gbc_lblDescrio.gridy = 0;
		add(lblDescrio, gbc_lblDescrio);
		
		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.anchor = GridBagConstraints.NORTH;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridx = 4;
		gbc_txtDescricao.gridy = 0;
		add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblCdigoDeBarra = new JLabel("C\u00F3digo de Barra");
		GridBagConstraints gbc_lblCdigoDeBarra = new GridBagConstraints();
		gbc_lblCdigoDeBarra.anchor = GridBagConstraints.WEST;
		gbc_lblCdigoDeBarra.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarra.gridx = 0;
		gbc_lblCdigoDeBarra.gridy = 1;
		add(lblCdigoDeBarra, gbc_lblCdigoDeBarra);
		
		txtCodBar = new JTextField();
		GridBagConstraints gbc_txtCodBar = new GridBagConstraints();
		gbc_txtCodBar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodBar.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodBar.gridx = 1;
		gbc_txtCodBar.gridy = 1;
		add(txtCodBar, gbc_txtCodBar);
		txtCodBar.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.WEST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 2;
		add(lblCategoria, gbc_lblCategoria);
		
		JComboBox cbCategoria = new JComboBox();
		GridBagConstraints gbc_cbCategoria = new GridBagConstraints();
		gbc_cbCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_cbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategoria.gridx = 1;
		gbc_cbCategoria.gridy = 2;
		add(cbCategoria, gbc_cbCategoria);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida");
		GridBagConstraints gbc_lblUnidadeDeMedida = new GridBagConstraints();
		gbc_lblUnidadeDeMedida.anchor = GridBagConstraints.EAST;
		gbc_lblUnidadeDeMedida.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidadeDeMedida.gridx = 3;
		gbc_lblUnidadeDeMedida.gridy = 2;
		add(lblUnidadeDeMedida, gbc_lblUnidadeDeMedida);
		
		JComboBox cbUnidade = new JComboBox();
		GridBagConstraints gbc_cbUnidade = new GridBagConstraints();
		gbc_cbUnidade.insets = new Insets(0, 0, 5, 0);
		gbc_cbUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUnidade.gridx = 4;
		gbc_cbUnidade.gridy = 2;
		add(cbUnidade, gbc_cbUnidade);
		
		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.WEST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 3;
		add(lblCusto, gbc_lblCusto);
		
		txtCusto = new JTextField();
		GridBagConstraints gbc_txtCusto = new GridBagConstraints();
		gbc_txtCusto.anchor = GridBagConstraints.NORTH;
		gbc_txtCusto.insets = new Insets(0, 0, 5, 5);
		gbc_txtCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCusto.gridx = 1;
		gbc_txtCusto.gridy = 3;
		add(txtCusto, gbc_txtCusto);
		txtCusto.setColumns(10);
		
		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucro = new GridBagConstraints();
		gbc_lblMargemDeLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMargemDeLucro.insets = new Insets(0, 0, 5, 5);
		gbc_lblMargemDeLucro.gridx = 3;
		gbc_lblMargemDeLucro.gridy = 3;
		add(lblMargemDeLucro, gbc_lblMargemDeLucro);
		
		txtMargemLucro = new JTextField();
		GridBagConstraints gbc_txtMargemLucro = new GridBagConstraints();
		gbc_txtMargemLucro.insets = new Insets(0, 0, 5, 0);
		gbc_txtMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargemLucro.gridx = 4;
		gbc_txtMargemLucro.gridy = 3;
		add(txtMargemLucro, gbc_txtMargemLucro);
		txtMargemLucro.setColumns(10);
		
		JButton btnNovo = new JButton("Novo");
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovo.gridx = 1;
		gbc_btnNovo.gridy = 5;
		add(btnNovo, gbc_btnNovo);
		
		JButton btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 5;
		add(btnExcluir, gbc_btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 3;
		gbc_btnSalvar.gridy = 5;
		add(btnSalvar, gbc_btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setRowHeaderView(table);
		
	}

}

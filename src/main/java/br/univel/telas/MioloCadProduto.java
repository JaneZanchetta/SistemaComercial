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

	/**
	 * Create the panel.
	 */
	public MioloCadProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.WEST;
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		GridBagConstraints gbc_lblDescrio = new GridBagConstraints();
		gbc_lblDescrio.anchor = GridBagConstraints.EAST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 0;
		gbc_lblDescrio.gridy = 1;
		add(lblDescrio, gbc_lblDescrio);
		
		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 1;
		add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblCdigoDeBarra = new JLabel("C\u00F3digo de Barra");
		GridBagConstraints gbc_lblCdigoDeBarra = new GridBagConstraints();
		gbc_lblCdigoDeBarra.anchor = GridBagConstraints.EAST;
		gbc_lblCdigoDeBarra.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarra.gridx = 0;
		gbc_lblCdigoDeBarra.gridy = 2;
		add(lblCdigoDeBarra, gbc_lblCdigoDeBarra);
		
		txtCodBar = new JTextField();
		GridBagConstraints gbc_txtCodBar = new GridBagConstraints();
		gbc_txtCodBar.anchor = GridBagConstraints.WEST;
		gbc_txtCodBar.insets = new Insets(0, 0, 5, 0);
		gbc_txtCodBar.gridx = 1;
		gbc_txtCodBar.gridy = 2;
		add(txtCodBar, gbc_txtCodBar);
		txtCodBar.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		GridBagConstraints gbc_lblCategoria = new GridBagConstraints();
		gbc_lblCategoria.anchor = GridBagConstraints.EAST;
		gbc_lblCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategoria.gridx = 0;
		gbc_lblCategoria.gridy = 3;
		add(lblCategoria, gbc_lblCategoria);
		
		JComboBox cbCategoria = new JComboBox();
		GridBagConstraints gbc_cbCategoria = new GridBagConstraints();
		gbc_cbCategoria.insets = new Insets(0, 0, 5, 0);
		gbc_cbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCategoria.gridx = 1;
		gbc_cbCategoria.gridy = 3;
		add(cbCategoria, gbc_cbCategoria);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida");
		GridBagConstraints gbc_lblUnidadeDeMedida = new GridBagConstraints();
		gbc_lblUnidadeDeMedida.anchor = GridBagConstraints.EAST;
		gbc_lblUnidadeDeMedida.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidadeDeMedida.gridx = 0;
		gbc_lblUnidadeDeMedida.gridy = 4;
		add(lblUnidadeDeMedida, gbc_lblUnidadeDeMedida);
		
		JComboBox cbUnidade = new JComboBox();
		GridBagConstraints gbc_cbUnidade = new GridBagConstraints();
		gbc_cbUnidade.insets = new Insets(0, 0, 5, 0);
		gbc_cbUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUnidade.gridx = 1;
		gbc_cbUnidade.gridy = 4;
		add(cbUnidade, gbc_cbUnidade);
		
		JLabel lblCusto = new JLabel("Custo");
		GridBagConstraints gbc_lblCusto = new GridBagConstraints();
		gbc_lblCusto.anchor = GridBagConstraints.EAST;
		gbc_lblCusto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCusto.gridx = 0;
		gbc_lblCusto.gridy = 5;
		add(lblCusto, gbc_lblCusto);
		
		txtCusto = new JTextField();
		GridBagConstraints gbc_txtCusto = new GridBagConstraints();
		gbc_txtCusto.anchor = GridBagConstraints.NORTH;
		gbc_txtCusto.insets = new Insets(0, 0, 5, 0);
		gbc_txtCusto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCusto.gridx = 1;
		gbc_txtCusto.gridy = 5;
		add(txtCusto, gbc_txtCusto);
		txtCusto.setColumns(10);
		
		JLabel lblMargemDeLucro = new JLabel("Margem de Lucro");
		GridBagConstraints gbc_lblMargemDeLucro = new GridBagConstraints();
		gbc_lblMargemDeLucro.anchor = GridBagConstraints.EAST;
		gbc_lblMargemDeLucro.insets = new Insets(0, 0, 0, 5);
		gbc_lblMargemDeLucro.gridx = 0;
		gbc_lblMargemDeLucro.gridy = 6;
		add(lblMargemDeLucro, gbc_lblMargemDeLucro);
		
		txtMargemLucro = new JTextField();
		GridBagConstraints gbc_txtMargemLucro = new GridBagConstraints();
		gbc_txtMargemLucro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMargemLucro.gridx = 1;
		gbc_txtMargemLucro.gridy = 6;
		add(txtMargemLucro, gbc_txtMargemLucro);
		txtMargemLucro.setColumns(10);
		
	}

}

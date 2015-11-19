/**
 * @Author
 * 07/11/2015  12:03:07
 */
package br.univel.telas;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.ClienteDaoImpl;
import br.univel.cadastro.Produto;
import br.univel.cadastro.ProdutoDaoImpl;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 * @author Jane
 *
 */
public class MioloVenda extends JPanel {
	private JTextField txtNroCompra;
	private JTextField txtData;
	private JTextField txtVlrTotal;
	private JTextField txtIdProduto;
	private JTable tbFitaCompra;
	private JTextField txtIdCliente;
	private JTextField txtVlrPago;
	private JTextField txtTroco;
	private JTextField txtQtde;
	private JTextField txtUnitProduto;
	private JTextField txtTotalProduto;
	private JComboBox <Cliente>cbCliente;
	private JComboBox <Produto>cbProduto;
	private ClienteDaoImpl cd;
	private ProdutoDaoImpl pd;



	/**
	 * Create the panel.
	 */
	public MioloVenda() {
		
		JPanel painelCliente = new JPanel();
		
		JPanel painelGeral = new JPanel();
		
		JPanel painelProduto = new JPanel();
		painelProduto.setBackground(SystemColor.window);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(painelCliente, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(painelGeral, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(78)
									.addComponent(btnSair)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(painelProduto, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(painelCliente, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(painelGeral, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnSair))
						.addComponent(painelProduto, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
					.addContainerGap())
		);
		GridBagLayout gbl_painelCliente = new GridBagLayout();
		gbl_painelCliente.columnWidths = new int[]{0, 0, 0, 0};
		gbl_painelCliente.rowHeights = new int[]{0, 0};
		gbl_painelCliente.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_painelCliente.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		painelCliente.setLayout(gbl_painelCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 0, 5);
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		painelCliente.add(lblCliente, gbc_lblCliente);
		
		txtIdCliente = new JTextField();
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.insets = new Insets(0, 0, 0, 5);
		gbc_txtIdCliente.anchor = GridBagConstraints.NORTH;
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.gridx = 1;
		gbc_txtIdCliente.gridy = 0;
		painelCliente.add(txtIdCliente, gbc_txtIdCliente);
		txtIdCliente.setColumns(10);
		
		cbCliente = new JComboBox(new DefaultComboBoxModel());
		GridBagConstraints gbc_cbCliente = new GridBagConstraints();
		gbc_cbCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCliente.gridx = 2;
		gbc_cbCliente.gridy = 0;
		painelCliente.add(cbCliente, gbc_cbCliente);
		GridBagLayout gbl_painelProduto = new GridBagLayout();
		gbl_painelProduto.columnWidths = new int[]{0, 0, 0};
		gbl_painelProduto.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_painelProduto.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_painelProduto.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		painelProduto.setLayout(gbl_painelProduto);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblProdutos = new GridBagConstraints();
		gbc_lblProdutos.insets = new Insets(0, 0, 5, 5);
		gbc_lblProdutos.gridx = 0;
		gbc_lblProdutos.gridy = 0;
		painelProduto.add(lblProdutos, gbc_lblProdutos);
		
		txtIdProduto = new JTextField();
		GridBagConstraints gbc_txtIdProduto = new GridBagConstraints();
		gbc_txtIdProduto.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdProduto.anchor = GridBagConstraints.NORTH;
		gbc_txtIdProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdProduto.gridx = 0;
		gbc_txtIdProduto.gridy = 1;
		painelProduto.add(txtIdProduto, gbc_txtIdProduto);
		txtIdProduto.setColumns(10);
		
		cbProduto =new JComboBox(new DefaultComboBoxModel());
		GridBagConstraints gbc_cbProduto = new GridBagConstraints();
		gbc_cbProduto.insets = new Insets(0, 0, 5, 0);
		gbc_cbProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbProduto.gridx = 1;
		gbc_cbProduto.gridy = 1;
		painelProduto.add(cbProduto, gbc_cbProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 0;
		gbc_lblQuantidade.gridy = 2;
		painelProduto.add(lblQuantidade, gbc_lblQuantidade);
		
		txtQtde = new JTextField();
		GridBagConstraints gbc_txtQtde = new GridBagConstraints();
		gbc_txtQtde.insets = new Insets(0, 0, 5, 0);
		gbc_txtQtde.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQtde.gridx = 1;
		gbc_txtQtde.gridy = 2;
		painelProduto.add(txtQtde, gbc_txtQtde);
		txtQtde.setColumns(10);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unit\u00E1rio");
		GridBagConstraints gbc_lblValorUnitrio = new GridBagConstraints();
		gbc_lblValorUnitrio.anchor = GridBagConstraints.EAST;
		gbc_lblValorUnitrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorUnitrio.gridx = 0;
		gbc_lblValorUnitrio.gridy = 3;
		painelProduto.add(lblValorUnitrio, gbc_lblValorUnitrio);
		
		txtUnitProduto = new JTextField();
		GridBagConstraints gbc_txtUnitProduto = new GridBagConstraints();
		gbc_txtUnitProduto.insets = new Insets(0, 0, 5, 0);
		gbc_txtUnitProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUnitProduto.gridx = 1;
		gbc_txtUnitProduto.gridy = 3;
		painelProduto.add(txtUnitProduto, gbc_txtUnitProduto);
		txtUnitProduto.setColumns(10);
		
		JButton btnRemovertem = new JButton("Remover \u00CDtem");
		btnRemovertem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblTotal = new JLabel("Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotal.gridx = 0;
		gbc_lblTotal.gridy = 4;
		painelProduto.add(lblTotal, gbc_lblTotal);
		
		txtTotalProduto = new JTextField();
		GridBagConstraints gbc_txtTotalProduto = new GridBagConstraints();
		gbc_txtTotalProduto.insets = new Insets(0, 0, 5, 0);
		gbc_txtTotalProduto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotalProduto.gridx = 1;
		gbc_txtTotalProduto.gridy = 4;
		painelProduto.add(txtTotalProduto, gbc_txtTotalProduto);
		txtTotalProduto.setColumns(10);
		GridBagConstraints gbc_btnRemovertem = new GridBagConstraints();
		gbc_btnRemovertem.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemovertem.gridx = 0;
		gbc_btnRemovertem.gridy = 5;
		painelProduto.add(btnRemovertem, gbc_btnRemovertem);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(30, 0, 0, 0);
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		painelProduto.add(scrollPane, gbc_scrollPane);
		
		tbFitaCompra = new JTable();
		tbFitaCompra.setBackground(Color.WHITE);
		scrollPane.setColumnHeaderView(tbFitaCompra);
		GridBagLayout gbl_painelGeral = new GridBagLayout();
		gbl_painelGeral.columnWidths = new int[]{0, 0, 0};
		gbl_painelGeral.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_painelGeral.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_painelGeral.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		painelGeral.setLayout(gbl_painelGeral);
		
		JLabel lblNroCompra = new JLabel("Nro Compra");
		lblNroCompra.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNroCompra = new GridBagConstraints();
		gbc_lblNroCompra.insets = new Insets(0, 0, 5, 5);
		gbc_lblNroCompra.gridx = 0;
		gbc_lblNroCompra.gridy = 0;
		painelGeral.add(lblNroCompra, gbc_lblNroCompra);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblData = new GridBagConstraints();
		gbc_lblData.insets = new Insets(0, 0, 5, 0);
		gbc_lblData.gridx = 1;
		gbc_lblData.gridy = 0;
		painelGeral.add(lblData, gbc_lblData);
		
		txtNroCompra = new JTextField();
		GridBagConstraints gbc_txtNroCompra = new GridBagConstraints();
		gbc_txtNroCompra.insets = new Insets(0, 0, 5, 5);
		gbc_txtNroCompra.anchor = GridBagConstraints.NORTH;
		gbc_txtNroCompra.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNroCompra.gridx = 0;
		gbc_txtNroCompra.gridy = 1;
		painelGeral.add(txtNroCompra, gbc_txtNroCompra);
		txtNroCompra.setColumns(10);
		
		txtData = new JTextField();
		GridBagConstraints gbc_txtData = new GridBagConstraints();
		gbc_txtData.insets = new Insets(0, 0, 5, 0);
		gbc_txtData.anchor = GridBagConstraints.NORTH;
		gbc_txtData.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtData.gridx = 1;
		gbc_txtData.gridy = 1;
		painelGeral.add(txtData, gbc_txtData);
		txtData.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorTotal.gridx = 0;
		gbc_lblValorTotal.gridy = 2;
		painelGeral.add(lblValorTotal, gbc_lblValorTotal);
		
		JButton btnFinalizaCompra = new JButton("Finaliza Compra");
		btnFinalizaCompra.setFont(new Font("Arial Black", Font.PLAIN, 12));
		GridBagConstraints gbc_btnFinalizaCompra = new GridBagConstraints();
		gbc_btnFinalizaCompra.insets = new Insets(0, 0, 5, 0);
		gbc_btnFinalizaCompra.gridx = 1;
		gbc_btnFinalizaCompra.gridy = 2;
		painelGeral.add(btnFinalizaCompra, gbc_btnFinalizaCompra);
		
		txtVlrTotal = new JTextField();
		txtVlrTotal.setEditable(false);
		txtVlrTotal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GridBagConstraints gbc_txtVlrTotal = new GridBagConstraints();
		gbc_txtVlrTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtVlrTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrTotal.gridx = 0;
		gbc_txtVlrTotal.gridy = 3;
		painelGeral.add(txtVlrTotal, gbc_txtVlrTotal);
		txtVlrTotal.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblPagamento = new GridBagConstraints();
		gbc_lblPagamento.anchor = GridBagConstraints.EAST;
		gbc_lblPagamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagamento.gridx = 0;
		gbc_lblPagamento.gridy = 4;
		painelGeral.add(lblPagamento, gbc_lblPagamento);
		
		txtVlrPago = new JTextField();
		GridBagConstraints gbc_txtVlrPago = new GridBagConstraints();
		gbc_txtVlrPago.insets = new Insets(0, 0, 5, 0);
		gbc_txtVlrPago.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVlrPago.gridx = 1;
		gbc_txtVlrPago.gridy = 4;
		painelGeral.add(txtVlrPago, gbc_txtVlrPago);
		txtVlrPago.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblTroco = new GridBagConstraints();
		gbc_lblTroco.anchor = GridBagConstraints.EAST;
		gbc_lblTroco.insets = new Insets(0, 0, 5, 5);
		gbc_lblTroco.gridx = 0;
		gbc_lblTroco.gridy = 5;
		painelGeral.add(lblTroco, gbc_lblTroco);
		
		txtTroco = new JTextField();
		GridBagConstraints gbc_txtTroco = new GridBagConstraints();
		gbc_txtTroco.insets = new Insets(0, 0, 5, 0);
		gbc_txtTroco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTroco.gridx = 1;
		gbc_txtTroco.gridy = 5;
		painelGeral.add(txtTroco, gbc_txtTroco);
		txtTroco.setColumns(10);
		setLayout(groupLayout);

		preencheComboCliente();
		preencheComboProduto();

		
	}

/**
 * @author Jane Z.
 * 18 de nov de 2015 23:00:54
 * Método para buscar os produtos cadastrados e colocá-los no Combo
 */
	private void preencheComboProduto() {
		List<Produto> lista =  pd.liste();
		for (Produto p: lista) {
			cbProduto.addItem(p);
		}
		
	}

	/**
	 * @author Jane Z.
	 * 18 de nov de 2015 23:03:29
	 * Método para buscar os clientes cadastrados e colocá-los no Combo
	 */
	
	private void preencheComboCliente() {
		List <Cliente> lista =  cd.liste();
		for (Cliente c: lista) {
			cbCliente.addItem(c);
		}
		
	}
}

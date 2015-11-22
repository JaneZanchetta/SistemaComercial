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
import br.univel.cadastro.Item;
import br.univel.cadastro.Produto;
import br.univel.cadastro.ProdutoDaoImpl;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.util.Formatter.BigDecimalLayoutForm;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * @author Jane
 *
 */
public class MioloVenda extends JPanel {
	private JTextField txtNroCompra;
	private JTextField txtData;
	private JTextField txtVlrTotal;
	private JTable tbFitaCompra;
	private JTextField txtVlrPago;
	private JTextField txtTroco;
	private JTextField txtQtde;
	private JTextField txtUnitProduto;
	private JTextField txtTotalProduto;
	private JComboBox <Cliente>cbCliente;
	private JComboBox <Produto>cbProduto;
	private ClienteDaoImpl cd;
	private ProdutoDaoImpl pd;
	BigDecimal totalGeral = new BigDecimal(0);

	private VendaModel model;
	private List<Item> lista = new ArrayList<>();
	private JTable table;


	/**
	 * Create the panel.
	 */
	public MioloVenda() {
		
		JPanel painelCliente = new JPanel();		
		JPanel painelGeral = new JPanel();
		
		JPanel painelProduto = new JPanel();
		painelProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
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
		
		cbProduto =new JComboBox(new DefaultComboBoxModel());
		cbProduto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				setaValor();
			}
		});
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
		txtUnitProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( " linha 194 ");
				acaoAdicionar();
				limpaItem();
				setModel();
//				txtQtde.requestFocus();
				
			}
		});
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
				removeItem();
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
		
		JButton btnAdicionaItem = new JButton("Adiciona Item");
		btnAdicionaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoAdicionar();
			}
		});
		GridBagConstraints gbc_btnAdicionaItem = new GridBagConstraints();
		gbc_btnAdicionaItem.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionaItem.gridx = 1;
		gbc_btnAdicionaItem.gridy = 5;
		painelProduto.add(btnAdicionaItem, gbc_btnAdicionaItem);
		
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
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
		cd = new ClienteDaoImpl();
		pd = new ProdutoDaoImpl();
		preencheComboCliente();
		preencheComboProduto();
		acaoNovo();

		
	}

	protected void setaValor() {
	/*
		Produto p = new Produto();
		BigDecimal unitario = new BigDecimal(0);
		unitario = p.getCusto(cbProduto.getSelectedItem());
		txtUnitProduto.setText(p.getCusto().cbProduto.getSelectedItem().);
*/		
	}

	/**
	 * @author Jane Z. 
	 * 20 de nov de 2015 00:26:28
	 * Prepara tabela dos itens digitados 
	 */
	protected void setModel() {
		/*
		cd = new ClienteDaoImpl();
		List<Cliente> lista;
		lista = cd.liste();
		model = new VendaModel(lista);
		
		table.setModel(model);
		*/
		
	}

	protected void removeItem() {
		System.out.println("remover");
		
	}

	protected void limpaItem() {
		txtQtde.setText("");
		txtUnitProduto.setText("");
		txtTotalProduto.setText("");
		
	}

	/**
	 * @author Jane Z. 
	 * 19 de nov de 2015 19:52:06
	 * Prepara formulário e variáveis para nova venda
	 */
	
	private void acaoNovo() {
		limpaCampos();
	txtData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
	
			    
	 
		//pegar data;
		

	}

	/**
	 * @author Jane Z. 
	 * 19 de nov de 2015 19:53:23
	 * Limpa os campos do formulário
	 * 
	 */
	private void limpaCampos() {
	cbCliente.setSelectedIndex(0);
	cbProduto.setSelectedIndex(0);
	}

	/**
	 * @author Jane Z.
	 * 19 de nov de 2015 19:32:36
	 * Calcula valor total do item e alimenta a lista geral de venda
	 */

	protected void acaoAdicionar() {
		BigDecimal unitario = new BigDecimal(txtUnitProduto.getText());
		BigDecimal vlrTotal = new BigDecimal(0);
		int qtde;
		if (txtQtde.getText().trim().equals("")) {
			qtde = 0;
		} else {
			qtde = Integer.parseInt(txtQtde.getText());
		}

		if (qtde <= 0) {
			JOptionPane.showMessageDialog(null, "Quantidade inválida!");
		} else {

			vlrTotal = new BigDecimal(txtQtde.getText()).multiply(unitario);
			txtTotalProduto.setText(vlrTotal.toString());
			totalGeral = totalGeral.add(totalGeral.add(vlrTotal));
			txtVlrTotal.setText(totalGeral.toString());
			System.out.println("ADICIONAR NO MODEL");
		}
		Item item = new Item();
		int id = cbProduto.getSelectedIndex();
		
		
//		item.setIdProduto(idProduto);
	//	item.setNomeProduto(nomeProduto);
		item.setQtde(qtde);
		item.setVlrUnitario(unitario);
		item.setVlrTotal(vlrTotal);
		lista.add(item);
		model = new VendaModel(lista);
		table.setModel(model);

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

package br.univel.telas;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.ClienteDaoImpl;
import br.univel.cadastro.Conexao;
import br.univel.cadastro.Item;
import br.univel.cadastro.Produto;
import br.univel.cadastro.ProdutoDaoImpl;

import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

public class MioloMovVenda extends JPanel {
	private JTextField txtNomeCliente;
	private JTextField txtIdCliente;
	private JTable tablePesquisa;
	private JTextField txtNomeProduto;
	private JTextField txtIdProduto;
	private JTextField txtQtde;
	private JTextField txtUnitario;
	private JTextField txtTotal;
	private JTable tableFita;
	private JTextField txtData;
	private JTextField txtTotalGeral;
	private JTextField txtValorPago;
	private JTextField txtTroco;
	private ClienteDaoImpl cd;
	private ProdutoDaoImpl pd;
	private int flag;
	private Connection con;
	private ClienteModel model;
	private ProdutoModel modelP;
	private VendaModel modelV;
	private BigDecimal totalGeral;
	private List<Item> lista = new ArrayList<>();


	/**
	 * Create the panel.
	 */
	public MioloMovVenda() {
		
		JPanel painelCliente = new JPanel();
		painelCliente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel painelPesquisa = new JPanel();
		painelPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getSelecao();
			}
		});
		painelPesquisa.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel painelProduto = new JPanel();
		painelProduto.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel painelFita = new JPanel();
		painelFita.setBackground(SystemColor.scrollbar);
		painelFita.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel painelFechamento = new JPanel();
		painelFechamento.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(painelPesquisa, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE)
								.addComponent(painelCliente, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(painelFita, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE)
										.addComponent(painelProduto, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 132, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(169)
							.addComponent(painelFechamento, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(painelCliente, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(painelPesquisa, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(painelProduto, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(painelFita, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(painelFechamento, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		
		JLabel lblTotalDaCompra = new JLabel("Total da Compra");
		lblTotalDaCompra.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTotalGeral = new JTextField();
		txtTotalGeral.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		
		JLabel lblTroco = new JLabel("Troco");
		lblTroco.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTroco = new JTextField();
		txtTroco.setColumns(10);
		GroupLayout gl_painelFechamento = new GroupLayout(painelFechamento);
		gl_painelFechamento.setHorizontalGroup(
			gl_painelFechamento.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelFechamento.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelFechamento.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelFechamento.createSequentialGroup()
							.addComponent(lblTotalDaCompra, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTotalGeral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painelFechamento.createSequentialGroup()
							.addComponent(lblPagamento, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painelFechamento.createSequentialGroup()
							.addComponent(lblTroco, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTroco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(464, Short.MAX_VALUE))
		);
		gl_painelFechamento.setVerticalGroup(
			gl_painelFechamento.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelFechamento.createSequentialGroup()
					.addGroup(gl_painelFechamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalDaCompra)
						.addComponent(txtTotalGeral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelFechamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPagamento, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtValorPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_painelFechamento.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTroco, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTroco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		painelFechamento.setLayout(gl_painelFechamento);
		
		JLabel lblCompraNro = new JLabel("Data");
		lblCompraNro.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtData = new JTextField();
		txtData.setFont(new Font("Calibri", Font.BOLD, 18));
		txtData.setColumns(10);
		
		JButton btnFinalizaCompra = new JButton("Fechamento");
		btnFinalizaCompra.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnAbandona = new JButton("Abandona");
		btnAbandona.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblCompraNro, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAbandona, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnFinalizaCompra, 0, 0, Short.MAX_VALUE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblCompraNro)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnFinalizaCompra)
					.addGap(18)
					.addComponent(btnAbandona)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		tableFita = new JTable();
		painelFita.add(tableFita);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		painelFita.add(scrollPane_1);
		
		JLabel lblProduto = new JLabel("Produto");
		
		txtNomeProduto = new JTextField();
		txtNomeProduto.setColumns(10);
		
		txtIdProduto = new JTextField();
		txtIdProduto.setColumns(10);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoPesquisarProduto();
			}
		});
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		
		JLabel lblValor = new JLabel("Valor");
		
		JLabel lblTotal = new JLabel("Total");
		
		txtQtde = new JTextField();
		txtQtde.setColumns(10);
		
		txtUnitario = new JTextField();
		txtUnitario.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		
		JButton btnAdicionaItem = new JButton("Adiciona Item");
		btnAdicionaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoAdicionar();
				limpaFormulario();

			}
		});
		
		JButton btnRemoveItem = new JButton("Remove Item");
		GroupLayout gl_painelProduto = new GroupLayout(painelProduto);
		gl_painelProduto.setHorizontalGroup(
			gl_painelProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelProduto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelProduto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_painelProduto.createSequentialGroup()
							.addGroup(gl_painelProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuantidade)
								.addComponent(txtQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(gl_painelProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValor)
								.addComponent(txtUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_painelProduto.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_painelProduto.createSequentialGroup()
									.addGap(17)
									.addComponent(lblTotal))
								.addGroup(gl_painelProduto.createSequentialGroup()
									.addGap(18)
									.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdicionaItem)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRemoveItem, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_painelProduto.createSequentialGroup()
							.addComponent(lblProduto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeProduto, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtIdProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisarProduto, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_painelProduto.setVerticalGroup(
			gl_painelProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelProduto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelProduto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProduto)
						.addComponent(txtNomeProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIdProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisarProduto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_painelProduto.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_painelProduto.createSequentialGroup()
							.addGroup(gl_painelProduto.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantidade)
								.addComponent(lblValor)
								.addComponent(lblTotal))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_painelProduto.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUnitario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_painelProduto.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAdicionaItem)
							.addComponent(btnRemoveItem))))
		);
		painelProduto.setLayout(gl_painelProduto);
		
		tablePesquisa = new JTable();
		tablePesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getSelecao();
			}
		});
		painelPesquisa.add(tablePesquisa);
		
		JScrollPane scrollPane = new JScrollPane();
		painelPesquisa.add(scrollPane);
		
		JLabel lblCliente = new JLabel("Cliente");
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setColumns(10);
		
		JButton btnPesquisarCliente = new JButton("Pesquisar");
		btnPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoPesquisarCliente();
			}
		});
		GroupLayout gl_painelCliente = new GroupLayout(painelCliente);
		gl_painelCliente.setHorizontalGroup(
			gl_painelCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCliente.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCliente)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtNomeCliente, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPesquisarCliente)
					.addContainerGap(157, Short.MAX_VALUE))
		);
		gl_painelCliente.setVerticalGroup(
			gl_painelCliente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_painelCliente.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_painelCliente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCliente)
						.addComponent(txtNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtIdCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisarCliente))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		painelCliente.setLayout(gl_painelCliente);
		setLayout(groupLayout);
		start();

	}

	/**
	 * @author Jane Z.
	 * 25 de nov de 2015 01:31:03
	 * Adiciona o produto à compra: cria item e adiciona ao Array;
	 * calcula e exibe valor total, atualiza a "fita" (tableModel) da compra
	 */
	
	protected void acaoAdicionar() {
		BigDecimal unitario = new BigDecimal(txtUnitario.getText());
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
			txtTotal.setText(vlrTotal.toString());
			totalGeral = totalGeral.add(totalGeral.add(vlrTotal));
			txtTotalGeral.setText(totalGeral.toString());
		}
		Item item = new Item();
		item.setIdProduto(Integer.parseInt(txtIdProduto.getText().trim()));
		item.setNomeProduto(txtNomeProduto.getText());
		item.setQtde(qtde);
		item.setVlrUnitario(unitario);
		item.setVlrTotal(vlrTotal);
		lista.add(item);
		modelV = new VendaModel(lista);
		tableFita.setModel(modelV);

	}
	
	/**
	 * @author Jane Z. 26 de nov de 2015 20:41:26
	 * Remove o item selecionado do Array de ítens
	 * e atualiza a "fita" (tableModel);
	 * deduz o valor do total geral da compra.
	 */

	protected void acaoRemover() {
//  falta fazer o botao chamar a selecao e exibir; e chamar a acao remover 
		BigDecimal vlrTotal = new BigDecimal(0);
		vlrTotal = new BigDecimal(txtTotal.getText());
		totalGeral = totalGeral.subtract(totalGeral.subtract(vlrTotal));
		txtTotalGeral.setText(totalGeral.toString());

		lista.remove(tableFita.getSelectedRow());
		modelV = new VendaModel(lista);
		tableFita.setModel(modelV);

	}


	/**
	 * @author Jane Z. 
	 * 25 de nov de 2015 01:16:31
	 * Transfere para o textField o cliente ou produto selecionado,
	 * conforme flag marcado
	 */
	protected void getSelecao() {
		int id = tablePesquisa.getSelectedRow();
		if (id > 0) {
			if (flag == 1) {
				txtIdCliente.setText(Integer.toString(model.getLista().get(id).getId()));
				txtNomeCliente.setText((model.getLista().get(id).getNome()));
			} else {
				txtIdProduto.setText(Integer.toString(modelP.getLista().get(id).getId()));
				txtNomeProduto.setText((modelP.getLista().get(id).getDescricao()));
				
				BigDecimal custo = new BigDecimal(0);
				custo = (modelP.getLista().get(id).getCusto());
				BigDecimal margem = new BigDecimal(0);
				margem = (modelP.getLista().get(id).getMargemLucro());
				margem = margem.divide(new BigDecimal(100));
				margem = custo.multiply(margem);
				BigDecimal unitario = new BigDecimal(0);
				unitario = custo.add(margem);
				txtUnitario.setText(unitario.toString());
				
				
//				txtUnitario = calcular custo + margem de lucro
			}

		}
	}


	/**
	 * @author Jane Z. 
	 * 25 de nov de 2015 00:43:56
	 * 
	 * Método inicial. 
	 * Verifica/conecta banco de dados
	 * Chama os construtores principais
	 * Limpa formulário
	 */
	
	private void start() {
		con = Conexao.abrirConexao();
		Produto p = new Produto();
		Cliente c = new Cliente();
		limpaFormulario();

		
	}

	/**
	 * @author Jane Z. 
	 * 25 de nov de 2015 00:56:12
	 * 
	 * Limpa  os campos do formulário
	 */
	
	private void limpaFormulario() {
		txtData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
		txtIdCliente.setText("");
		txtIdProduto.setText("");
		txtNomeCliente.setText("");
		txtNomeProduto.setText("");
		txtQtde.setText("");
		txtTotal.setText("");
		txtTotalGeral.setText("");
		txtUnitario.setText("");
		txtValorPago.setText("");
		txtTroco.setText("");
		
		
	}


	/**
	 * @author Jane Z. 
	 * 25 de nov de 2015 00:39:56
	 * Busca no Banco de Dados os clientes cadastrados e exibe para seleção
	 */
	 
protected void acaoPesquisarCliente() {
		flag = 1;
		String str=txtNomeCliente.getText();
		cd = new ClienteDaoImpl();
		List<Cliente> lista;
		lista = cd.liste(str);
		model = new ClienteModel(lista);
		tablePesquisa.setModel(model);
	}

/**
 * @author Jane Z.
 * 25 de nov de 2015 01:11:32
 * Busca no Banco de Dados os produtos cadastrados e exibe para seleção
 */
	protected void acaoPesquisarProduto() {
		flag = 2;
		String str=txtNomeProduto.getText();
		pd = new ProdutoDaoImpl();
		List<Produto> lista =  pd.liste(str);
		modelP = new ProdutoModel(lista);
		tablePesquisa.setModel(modelP);
		
	}
}

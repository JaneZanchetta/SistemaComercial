/**
 * @Author
 * 05/11/2015  00:17:31
 */
package br.univel.telas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import br.univel.cadastro.Categoria;
import br.univel.cadastro.Cliente;
import br.univel.cadastro.ClienteDaoImpl;
import br.univel.cadastro.Genero;
import br.univel.cadastro.Produto;
import br.univel.cadastro.ProdutoDaoImpl;
import br.univel.cadastro.UF;
import br.univel.cadastro.Unidade;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;

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
	JButton btnNovo;
	JButton btnExcluir;
	JButton btnSalvar;
	
	private ProdutoModel model;
	private ProdutoDaoImpl pd;
	private boolean novo = true;
	JComboBox comboUnidade;
	JComboBox comboCategoria;

	/**
	 * Create the panel.
	 */
	public MioloCadProduto() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{116, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_lblDescrio.anchor = GridBagConstraints.WEST;
		gbc_lblDescrio.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescrio.gridx = 2;
		gbc_lblDescrio.gridy = 0;
		add(lblDescrio, gbc_lblDescrio);
		
		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.gridwidth = 2;
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.anchor = GridBagConstraints.NORTH;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 0);
		gbc_txtDescricao.gridx = 3;
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
		
		comboCategoria = new JComboBox();
		comboCategoria.setModel(new DefaultComboBoxModel(Categoria.values()));
		GridBagConstraints gbc_comboCategoria = new GridBagConstraints();
		gbc_comboCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_comboCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCategoria.gridx = 1;
		gbc_comboCategoria.gridy = 2;
		add(comboCategoria, gbc_comboCategoria);
		
		JLabel lblUnidadeDeMedida = new JLabel("Unidade de Medida");
		GridBagConstraints gbc_lblUnidadeDeMedida = new GridBagConstraints();
		gbc_lblUnidadeDeMedida.anchor = GridBagConstraints.EAST;
		gbc_lblUnidadeDeMedida.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnidadeDeMedida.gridx = 2;
		gbc_lblUnidadeDeMedida.gridy = 2;
		add(lblUnidadeDeMedida, gbc_lblUnidadeDeMedida);
		
		comboUnidade = new JComboBox();
		comboUnidade.setModel(new DefaultComboBoxModel(Unidade.values()));
		GridBagConstraints gbc_comboUnidade = new GridBagConstraints();
		gbc_comboUnidade.insets = new Insets(0, 0, 5, 5);
		gbc_comboUnidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboUnidade.gridx = 3;
		gbc_comboUnidade.gridy = 2;
		add(comboUnidade, gbc_comboUnidade);
		
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
		gbc_lblMargemDeLucro.gridx = 2;
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
		
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acaoNovo();
			}
		});
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.insets = new Insets(0, 0, 5, 5);
		gbc_btnNovo.gridx = 1;
		gbc_btnNovo.gridy = 5;
		add(btnNovo, gbc_btnNovo);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acaoExcluir();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 5;
		add(btnExcluir, gbc_btnExcluir);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acaoSalvar();
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 3;
		gbc_btnSalvar.gridy = 5;
		add(btnSalvar, gbc_btnSalvar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				acaoSelecionar();
			}
		});
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		setModel();
		acaoNovo();
		
	}
	
	/**
	 * @author Jane Z.
	 * 18 de nov de 2015 22:03:53
	 * Carrega os dados da linha selecionada na tabela, para edição ou exclusao
	 */
	protected void acaoSelecionar() {
		int id = table.getSelectedRow();
		if (id > 0) {
			txtId.setText(Integer.toString(model.getLista().get(id).getId()));
			txtCodBar.setText(Integer.toString(model.getLista().get(id).getCodBar()));
			txtDescricao.setText((model.getLista().get(id).getDescricao()));
			BigDecimal.valueOf(Double.parseDouble(txtCusto.getText()));
			BigDecimal.valueOf(Double.parseDouble(txtMargemLucro.getText()));
			novo = false;
			btnExcluir.setEnabled(true);
		}

		
	}

	/**
	 * @author Jane Z.
	 * 18 de nov de 2015 22:00:54
	 * Carrega tabela com os produtos cadastrados no BD
	 */
	private void setModel() {
		pd = new ProdutoDaoImpl();
		List<Produto> lista;
		lista = pd.liste();
		System.out.println("voltou, vai pro model");
		model = new ProdutoModel(lista);
		table.setModel(model);
		
	}

	/**
	 * @author Jane Z.
	 * 12 de nov de 2015 20:09:50
	 * Método a ser executado quando usuário clicar no botão "Salvar".
	 * Solicita ao usuário confirmação;se confirmado insere os dados no BD
	 * através do método da classe DAO. Depois chama os métodos para limpar
	 * formulário e atualizar a tabela de produtos exibida.
	 */
	
	protected void acaoSalvar() {
		btnNovo.setEnabled(true);
		int id = 0;
		Produto p = new Produto();
		if (!novo) {
			id = Integer.parseInt(txtId.getText().trim());
		}

		int resposta = JOptionPane.showConfirmDialog(null, "Confirma informações?");
		if (resposta == JOptionPane.YES_OPTION) {
			p.setCategoria((Categoria) comboCategoria.getSelectedItem());
			p.setCodBar(Integer.parseInt(txtCodBar.getText().trim()));

			BigDecimal.valueOf(Double.parseDouble(txtCusto.getText().trim()));
			BigDecimal.valueOf(Double.parseDouble(txtMargemLucro.getText().trim()));
			p.setUnidade((Unidade) comboUnidade.getSelectedItem());
			p.setDescricao(txtDescricao.getText());
			if (novo) {
				try {
					pd.create(p);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				id = ((model.getLista().get(table.getSelectedRow()).getId()));
				pd.update(p);
			}
			JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		}
		limparCampos();
		table.setModel(model);
	}		
	

	/**
	 * @author Jane Z.
     * 12 de nov de 2015 20:01:24
     * Método a ser executado qdo usuário clica no botão "Excluir":
     * 
	 */
protected void acaoExcluir() {
	int id = table.getSelectedRow();
	Produto p = model.getLista().get(table.getSelectedRow());

	if (id < 0) {
		JOptionPane.showMessageDialog(this, "Nenhum dado selecionado!!!");
	} else {
		id = model.getLista().get(id).getId();
		int resposta = JOptionPane.showConfirmDialog(null, "Confirma exclusão ?");
		if (resposta == JOptionPane.YES_OPTION) {
			try {
				pd.delete(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		limparCampos();
		setModel();
	}
	}
/**
 * @author Jane Z.
 * 12 de nov de 2015 19:56:25
 * Método a ser executado qdo usuário clica no botão "Novo" e também ao carregar a tela
 * a primeira vez. Vai limpar os campos, setar variável que indica que se trata de produto novo,
 * desabilitar o botão de exclusão e setar o foco na descrição.
 */
	
	protected void acaoNovo() {
		limparCampos();
		novo = true;
		btnExcluir.setEnabled(false);
		btnNovo.setEnabled(false);
		txtDescricao.grabFocus();
//		txtDescricao.requestFocusInWindow();
		
	}

	private void limparCampos() {
		
		
	}

}

package br.univel.telas;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.UIManager;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.ClienteDaoImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * 
 * @author Jane Z.
 * 01/11/2015 00:39:16 
 */

public class MioloCadCliente extends JPanel {
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JTable table;

	private ClienteModel model;
	private ClienteDaoImpl cd;
	private boolean novo = true;

	/**
	 * Create the panel.
	 */
	public MioloCadCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 84, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
								
										JLabel lblId = new JLabel("ID");
										GridBagConstraints gbc_lblId = new GridBagConstraints();
										gbc_lblId.anchor = GridBagConstraints.EAST;
										gbc_lblId.insets = new Insets(0, 0, 5, 5);
										gbc_lblId.gridx = 0;
										gbc_lblId.gridy = 1;
										add(lblId, gbc_lblId);
								
										txtId = new JTextField();
										GridBagConstraints gbc_txtId = new GridBagConstraints();
										gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
										gbc_txtId.insets = new Insets(0, 0, 5, 5);
										gbc_txtId.gridx = 1;
										gbc_txtId.gridy = 1;
										add(txtId, gbc_txtId);
										txtId.setColumns(10);
								
										JLabel lblNome = new JLabel("Nome");
										GridBagConstraints gbc_lblNome = new GridBagConstraints();
										gbc_lblNome.anchor = GridBagConstraints.EAST;
										gbc_lblNome.insets = new Insets(0, 0, 5, 5);
										gbc_lblNome.gridx = 2;
										gbc_lblNome.gridy = 1;
										add(lblNome, gbc_lblNome);
						
								txtNome = new JTextField();
								GridBagConstraints gbc_txtNome = new GridBagConstraints();
								gbc_txtNome.gridwidth = 9;
								gbc_txtNome.anchor = GridBagConstraints.NORTH;
								gbc_txtNome.insets = new Insets(0, 0, 5, 0);
								gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtNome.gridx = 3;
								gbc_txtNome.gridy = 1;
								add(txtNome, gbc_txtNome);
								txtNome.setColumns(10);
						
								JLabel lblTelefone = new JLabel("Telefone");
								GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
								gbc_lblTelefone.anchor = GridBagConstraints.EAST;
								gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
								gbc_lblTelefone.gridx = 0;
								gbc_lblTelefone.gridy = 2;
								add(lblTelefone, gbc_lblTelefone);
				
						txtTelefone = new JTextField();
						GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
						gbc_txtTelefone.insets = new Insets(0, 0, 5, 5);
						gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
						gbc_txtTelefone.gridx = 1;
						gbc_txtTelefone.gridy = 2;
						add(txtTelefone, gbc_txtTelefone);
						txtTelefone.setColumns(10);
				
						JLabel lblEndereo = new JLabel("Endere\u00E7o");
						GridBagConstraints gbc_lblEndereo = new GridBagConstraints();
						gbc_lblEndereo.anchor = GridBagConstraints.EAST;
						gbc_lblEndereo.insets = new Insets(0, 0, 5, 5);
						gbc_lblEndereo.gridx = 0;
						gbc_lblEndereo.gridy = 3;
						add(lblEndereo, gbc_lblEndereo);
		
				txtEndereco = new JTextField();
				GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
				gbc_txtEndereco.insets = new Insets(0, 0, 5, 5);
				gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtEndereco.gridx = 1;
				gbc_txtEndereco.gridy = 3;
				add(txtEndereco, gbc_txtEndereco);
				txtEndereco.setColumns(10);
				
						JLabel lblUf = new JLabel("UF");
						GridBagConstraints gbc_lblUf = new GridBagConstraints();
						gbc_lblUf.anchor = GridBagConstraints.EAST;
						gbc_lblUf.insets = new Insets(0, 0, 5, 5);
						gbc_lblUf.gridx = 5;
						gbc_lblUf.gridy = 3;
						add(lblUf, gbc_lblUf);
				
						JComboBox comboUF = new JComboBox();
						GridBagConstraints gbc_comboUF = new GridBagConstraints();
						gbc_comboUF.gridwidth = 4;
						gbc_comboUF.insets = new Insets(0, 0, 5, 5);
						gbc_comboUF.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboUF.gridx = 7;
						gbc_comboUF.gridy = 3;
						add(comboUF, gbc_comboUF);
		
				JLabel lblCidade = new JLabel("Cidade");
				GridBagConstraints gbc_lblCidade = new GridBagConstraints();
				gbc_lblCidade.anchor = GridBagConstraints.EAST;
				gbc_lblCidade.insets = new Insets(0, 0, 5, 5);
				gbc_lblCidade.gridx = 0;
				gbc_lblCidade.gridy = 4;
				add(lblCidade, gbc_lblCidade);
		
				txtCidade = new JTextField();
				GridBagConstraints gbc_txtCidade = new GridBagConstraints();
				gbc_txtCidade.gridwidth = 2;
				gbc_txtCidade.fill = GridBagConstraints.BOTH;
				gbc_txtCidade.insets = new Insets(0, 0, 5, 5);
				gbc_txtCidade.gridx = 1;
				gbc_txtCidade.gridy = 4;
				add(txtCidade, gbc_txtCidade);
				txtCidade.setColumns(10);
								
										JLabel lblEmail = new JLabel("Email");
										GridBagConstraints gbc_lblEmail = new GridBagConstraints();
										gbc_lblEmail.anchor = GridBagConstraints.EAST;
										gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
										gbc_lblEmail.gridx = 0;
										gbc_lblEmail.gridy = 5;
										add(lblEmail, gbc_lblEmail);
						
								txtEmail = new JTextField();
								GridBagConstraints gbc_txtEmail = new GridBagConstraints();
								gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
								gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtEmail.gridx = 1;
								gbc_txtEmail.gridy = 5;
								add(txtEmail, gbc_txtEmail);
								txtEmail.setColumns(10);
				
						JLabel lblGenero = new JLabel("G\u00EAnero");
						GridBagConstraints gbc_lblGenero = new GridBagConstraints();
						gbc_lblGenero.anchor = GridBagConstraints.EAST;
						gbc_lblGenero.insets = new Insets(0, 0, 5, 5);
						gbc_lblGenero.gridx = 6;
						gbc_lblGenero.gridy = 5;
						add(lblGenero, gbc_lblGenero);
				
						JComboBox comboGenero = new JComboBox();
						GridBagConstraints gbc_comboGenero = new GridBagConstraints();
						gbc_comboGenero.gridwidth = 4;
						gbc_comboGenero.insets = new Insets(0, 0, 5, 5);
						gbc_comboGenero.fill = GridBagConstraints.HORIZONTAL;
						gbc_comboGenero.gridx = 7;
						gbc_comboGenero.gridy = 5;
						add(comboGenero, gbc_comboGenero);
						
						JButton btnNovo = new JButton("Novo");
						btnNovo.setBackground(UIManager.getColor("Button.light"));
						GridBagConstraints gbc_btnNovo = new GridBagConstraints();
						gbc_btnNovo.insets = new Insets(0, 0, 5, 5);
						gbc_btnNovo.gridx = 1;
						gbc_btnNovo.gridy = 6;
						add(btnNovo, gbc_btnNovo);
						
						JButton btnExcluir = new JButton("Excluir");
						btnExcluir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									excluir();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
						btnExcluir.setBackground(UIManager.getColor("Button.light"));
						GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
						gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
						gbc_btnExcluir.gridx = 2;
						gbc_btnExcluir.gridy = 6;
						add(btnExcluir, gbc_btnExcluir);
						
						JButton btnSalvar = new JButton("Salvar");
						btnSalvar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								try {
									salvar();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
						btnSalvar.setBackground(UIManager.getColor("Button.light"));
						GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
						gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
						gbc_btnSalvar.gridx = 3;
						gbc_btnSalvar.gridy = 6;
						add(btnSalvar, gbc_btnSalvar);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								seleciona();
							}
						});
						GridBagConstraints gbc_scrollPane = new GridBagConstraints();
						gbc_scrollPane.gridwidth = 12;
						gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
						gbc_scrollPane.fill = GridBagConstraints.BOTH;
						gbc_scrollPane.gridx = 0;
						gbc_scrollPane.gridy = 7;
						add(scrollPane, gbc_scrollPane);
						
						table = new JTable();
						scrollPane.setRowHeaderView(table);
						cd = new ClienteDaoImpl();
						model = new ClienteModel((ArrayList<Cliente>) cd.liste());
						table.setModel(model);
						
						

	}

	/**
	 * @throws SQLException 
	 * @Author Jane Z.
	 * 06/11/2015 01:08:49
	 */
	protected void excluir() throws SQLException {
		int id = table.getSelectedRow();
		if (id < 0) {
			JOptionPane
					.showMessageDialog(this, "Nenhum dado selecionado!!!");
		} else {
			id = model.getLista().get(id).getId();
			int resposta = JOptionPane.showConfirmDialog(null,
					"Confirma exclusão ?");
			if (resposta == JOptionPane.YES_OPTION) {
				cd.delete(id);
			}
			limparCampos();
			model = new ClienteModel((ArrayList<Cliente>) cd.liste());
			table.setModel(model);

		}
	}

	

	/**
	 * @throws SQLException 
	 * @Author Jane Z.
	 * 06/11/2015 00:54:41 
	 */
	protected void salvar() throws SQLException {
		int id = 0;
		if (novo) {
			if (txtId.getText().equals("")) {
				id = -1;
			} else {
				id = Integer.parseInt(txtId.getText().trim());
			}
		} else {
			id = ((model.getLista().get(table.getSelectedRow()).getId()));
		}
		if (id < 0) {
			JOptionPane.showMessageDialog(this, "ID inválido");
		} else {
			Cliente c = new Cliente();
			String nome = txtNome.getText().trim();
			String fone = txtTelefone.getText().trim();
			String endereco = txtEndereco.getText().trim();
			int resposta = JOptionPane.showConfirmDialog(null,
					"Confirma informações?");
			if (resposta == JOptionPane.YES_OPTION) {
				c.setId(id);
				c.setEndereco(endereco);
				c.setTelefone(fone);
				c.setNome(nome);
				if (novo) {
					id = Integer.parseInt(txtId.getText().trim());
					cd.create(c);
				} else {
					id = ((model.getLista().get(table.getSelectedRow()).getId()));
					cd.update(c);
				}
				JOptionPane.showMessageDialog(this,
						"Operação realizada com sucesso!");
			}
			limparCampos();
			model = new ClienteModel((ArrayList<Cliente>) cd.liste());
			table.setModel(model);
		}
		
	}

	/**
	 * @Author Jane Z.
	 * 06/11/2015 01:03:23
	 */
	private void limparCampos() {
			txtId.setText("");
			txtNome.setText("");
			txtTelefone.setText("");
			txtEndereco.setText("");
		
	}

	/**
	 * @Author Jane Z.
	 * 06/11/2015 00:52:16 
	 */
	protected void seleciona() {
		int id = table.getSelectedRow();
		txtId.setText(Integer.toString(model.getLista().get(id).getId()));
		txtNome.setText((model.getLista().get(id).getNome()));
		txtEndereco.setText((model.getLista().get(id).getEndereco()));
		txtTelefone.setText((model.getLista().get(id).getTelefone()));
		txtCidade.setText(model.getLista().get(id).getCidade());
		txtEmail.setText(model.getLista().get(id).getEmail());
//		txtUF.setText(model.getLista().get(id).getUF());
		novo = false;
		
	}

}

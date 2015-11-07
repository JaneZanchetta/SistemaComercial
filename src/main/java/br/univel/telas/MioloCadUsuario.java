/**
 * @Author
 * 05/11/2015  22:53:50
 */
package br.univel.telas;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.ClienteDaoImpl;
import br.univel.cadastro.Usuario;
import br.univel.cadastro.UsuarioDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * @author Jane 05/11/2015 22:53:50
 */
public class MioloCadUsuario extends JPanel {
	private JTextField txtId;
	private JTextField txtIdCliente;
	private JPasswordField passUsuario;
	private JTextField txtNomeCliente;
	private JTable table;
	private UsuarioModel model;
	private UsuarioDaoImpl ud;
	private ClienteDaoImpl cd;
	private boolean novo = true;

	/**
	 * Create the panel.
	 */
	public MioloCadUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 119, 0, 0, 188, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		add(txtId, gbc_txtId);
		txtId.setColumns(10);

		JLabel lblIdCliente = new JLabel("Id Cliente");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 2;
		add(lblIdCliente, gbc_lblIdCliente);

		txtIdCliente = new JTextField();
		txtIdCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validaCliente();
			}
		});
		GridBagConstraints gbc_txtIdCliente = new GridBagConstraints();
		gbc_txtIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdCliente.gridx = 1;
		gbc_txtIdCliente.gridy = 2;
		add(txtIdCliente, gbc_txtIdCliente);
		txtIdCliente.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 3;
		gbc_lblNome.gridy = 2;
		add(lblNome, gbc_lblNome);

		txtNomeCliente = new JTextField();
		GridBagConstraints gbc_txtNomeCliente = new GridBagConstraints();
		gbc_txtNomeCliente.anchor = GridBagConstraints.NORTH;
		gbc_txtNomeCliente.insets = new Insets(0, 0, 5, 0);
		gbc_txtNomeCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNomeCliente.gridx = 4;
		gbc_txtNomeCliente.gridy = 2;
		add(txtNomeCliente, gbc_txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 0;
		gbc_lblSenha.gridy = 3;
		add(lblSenha, gbc_lblSenha);

		passUsuario = new JPasswordField();
		GridBagConstraints gbc_passUsuario = new GridBagConstraints();
		gbc_passUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_passUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_passUsuario.gridx = 1;
		gbc_passUsuario.gridy = 3;
		add(passUsuario, gbc_passUsuario);

		JButton btnNovo = new JButton("Novo");
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

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoExcluir();
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 5;
		add(btnExcluir, gbc_btnExcluir);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoSalvar();
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 0);
		gbc_btnSalvar.anchor = GridBagConstraints.WEST;
		gbc_btnSalvar.gridx = 4;
		gbc_btnSalvar.gridy = 5;
		add(btnSalvar, gbc_btnSalvar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setRowHeaderView(table);

	}

	/**
	 * @Author Jane Z. 
	 * 07/11/2015 01:47:04
	 */
	protected void validaCliente() {
		int id = 0;
		if (txtId.getText().equals("")) {
			id = -1;
		} else {
			id = Integer.parseInt(txtId.getText().trim());
		}
		Cliente c = new Cliente();
// buscar o nome do cliente para exibir na tela 
//		txtNomeCliente.setText(c.getNome(cd.read(id)));
		if (txtNomeCliente == null) {
			JOptionPane.showMessageDialog(this, "Cliente Inválido!!!");
			txtId.setFocusable(true);
		};
	}

	/**
	 * @Author Jane Z. 07/11/2015 01:01:32
	 */
	protected void acaoExcluir() {
		int id = table.getSelectedRow();
		if (id < 0) {
			JOptionPane.showMessageDialog(this, "Nenhum dado selecionado!!!");
		} else {
			id = model.getLista().get(id).getId();
			int resposta = JOptionPane.showConfirmDialog(null,
					"Confirma exclusão ?");
			if (resposta == JOptionPane.YES_OPTION) {
				try {
					ud.delete(id);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			limparCampos();
			model = new UsuarioModel((ArrayList<Usuario>) ud.liste());
			table.setModel(model);

		}

	}

	/**
	 * @Author Jane Z. 
	 * 07/11/2015 01:02:41
	 */
	private void limparCampos() {
		txtId.setText("");
		txtIdCliente.setText("");
		txtNomeCliente.setText("");

	}

	/**
	 * @Author Jane Z. 
	 * 07/11/2015 01:04:11
	 */
	protected void acaoSalvar() {
		
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
			Usuario u = new Usuario();
			int idCliente = Integer.parseInt(txtIdCliente.getText().trim());
			int resposta = JOptionPane.showConfirmDialog(null,
					"Confirma informações?");
			if (resposta == JOptionPane.YES_OPTION) {
				u.setId(id);
				u.setIdCliente(idCliente);
				if (novo) {
					id = Integer.parseInt(txtId.getText().trim());
					try {
						ud.create(u);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					id = ((model.getLista().get(table.getSelectedRow()).getId()));
					ud.update(u);
				}
				JOptionPane.showMessageDialog(this,
						"Operação realizada com sucesso!");
			}
			limparCampos();
			model = new UsuarioModel((ArrayList<Usuario>) ud.liste());
			table.setModel(model);
		}

	}



	/**
	 * @Author Jane Z. 
	 * 07/11/2015 01:40:53
	 */
	protected void acaoNovo() {
		txtId.requestFocus();
		limparCampos();
		novo = true;
		
	}

}

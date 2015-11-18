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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.univel.cadastro.Cliente;
import br.univel.cadastro.ClienteDaoImpl;
import br.univel.cadastro.UF;
import br.univel.cadastro.Usuario;
import br.univel.cadastro.UsuarioDaoImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

/**
 * @author Jane 05/11/2015 22:53:50
 */
public class MioloCadUsuario extends JPanel {
	private JTextField txtId;
	private JPasswordField passUsuario;
	private JTable table;
	private UsuarioModel model;
	private UsuarioDaoImpl ud;
	private ClienteDaoImpl cd;
	private boolean novo = true;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnNovo;
	private JComboBox <Cliente>comboCliente;

	/**
	 * Create the panel.
	 */
	public MioloCadUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 119, 0, 0, 188, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		add(lblId, gbc_lblId);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		add(txtId, gbc_txtId);
		txtId.setColumns(10);

		JLabel lblIdCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblIdCliente = new GridBagConstraints();
		gbc_lblIdCliente.anchor = GridBagConstraints.EAST;
		gbc_lblIdCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdCliente.gridx = 0;
		gbc_lblIdCliente.gridy = 2;
		add(lblIdCliente, gbc_lblIdCliente);
		
		comboCliente = new JComboBox(new DefaultComboBoxModel());
		GridBagConstraints gbc_comboCliente = new GridBagConstraints();
		gbc_comboCliente.insets = new Insets(0, 0, 5, 5);
		gbc_comboCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCliente.gridx = 1;
		gbc_comboCliente.gridy = 2;
		add(comboCliente, gbc_comboCliente);

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

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoExcluir();
			}

		});
		
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
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 5;
		add(btnExcluir, gbc_btnExcluir);

		btnSalvar = new JButton("Salvar");
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
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acaoSelecionar();
			}
		});
		scrollPane.setViewportView(table);
		cd = new ClienteDaoImpl();
		preencheCombo();
		setModel();
		acaoNovo();
	}
	
	private void preencheCombo() {
		List<Cliente> lista =  cd.liste();
		for (Cliente c: lista) {
			comboCliente.addItem(c);
		}

	}

	/**
	 * @author Jane Z.
	 * 17 de nov de 2015 20:46:58
	 */

	private void setModel() {
		ud = new UsuarioDaoImpl();
		List<Usuario> lista;
		lista = ud.liste();
		model = new UsuarioModel(lista);
		table.setModel(model);
	}

	protected void acaoNovo() {
		limparCampos();
		novo = true;
		btnExcluir.setEnabled(false);
		btnNovo.setEnabled(false);
		
		
	}

	/**
	 * @author Jane Z. 11 de nov de 2015 22:42:55
	 */
	protected void acaoSelecionar() {
		int id = table.getSelectedRow();
		if (id > 0) {
			txtId.setText(Integer.toString(model.getLista().get(id).getId()));
			passUsuario.setText((model.getLista().get(id).getSenha()));
			novo = false;
			btnExcluir.setEnabled(true);
		}

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
			int resposta = JOptionPane.showConfirmDialog(null, "Confirma exclusão ?");
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
	 * @Author Jane Z. 07/11/2015 01:02:41
	 */
	private void limparCampos() {
		txtId.setText("");
		passUsuario.setText("");

	}

	/**
	 * @Author Jane Z. 07/11/2015 01:04:11
	 */
	protected void acaoSalvar() {
		btnNovo.setEnabled(true);
		int id = 0;
		Usuario u = new Usuario();
		if (!novo) {
			id = Integer.parseInt(txtId.getText().trim());
		}

		int resposta = JOptionPane.showConfirmDialog(null, "Confirma informações?");
		if (resposta == JOptionPane.YES_OPTION) {
			Cliente c = (Cliente) comboCliente.getSelectedItem();
			u.setIdCliente(c.getId());
			if (novo) {
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
			JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
		}
		limparCampos();
		model = new UsuarioModel((ArrayList<Usuario>) ud.liste());
		table.setModel(model);
	}

	private void validaCliente(int id) {
		Cliente c = new Cliente();
		
		
	}

}

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
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * @author Jane
 * 05/11/2015 22:53:50
 */
public class MioloCadUsuario extends JPanel {
	private JTextField txtId;
	private JTextField txtIdCliente;
	private JPasswordField passUsuario;
	private JTextField txtNomeCliente;

	/**
	 * Create the panel.
	 */
	public MioloCadUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 119, 0, 0, 188, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
	}

}

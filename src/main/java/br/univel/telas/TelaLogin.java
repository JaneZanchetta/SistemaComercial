/**
 * 29/10/201520:28:50
 */
package br.univel.telas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 * @author jamzanchetta
 *
 */
public class TelaLogin extends JPanel {
	private JTextField txtUsuario;
	private JPasswordField passField;
	private JButton btnEntrar;
	private Runnable acaoOk;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		setBackground(new Color(240, 248, 255));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurio.anchor = GridBagConstraints.EAST;
		gbc_lblUsurio.gridx = 1;
		gbc_lblUsurio.gridy = 1;
		add(lblUsurio, gbc_lblUsurio);

		txtUsuario = new JTextField();

		GridBagConstraints gbc_txtUsuario = new GridBagConstraints();
		gbc_txtUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsuario.gridx = 2;
		gbc_txtUsuario.gridy = 1;
		add(txtUsuario, gbc_txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.EAST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 1;
		gbc_lblSenha.gridy = 3;
		add(lblSenha, gbc_lblSenha);

		passField = new JPasswordField();
		// passField.setEditable(false);
		GridBagConstraints gbc_passField = new GridBagConstraints();
		gbc_passField.insets = new Insets(0, 0, 5, 0);
		gbc_passField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passField.gridx = 2;
		gbc_passField.gridy = 3;
		add(passField, gbc_passField);
		passField.setColumns(10);

		btnEntrar = new JButton("LOGIN");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.anchor = GridBagConstraints.BASELINE;
		gbc_btnEntrar.gridx = 2;
		gbc_btnEntrar.gridy = 5;
		add(btnEntrar, gbc_btnEntrar);
		configuraListeners();

	}

	private void configuraListeners() {
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					txtUsuario.transferFocus();
				}
			}
		});
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					logar();
				}

			}

		});
	}

	public TelaLogin(Runnable acaoOk) {
		this();

		this.acaoOk = acaoOk;
		btnEntrar.addActionListener(e -> {
			logar();
		});
	}

	private void logar() {
		if (txtUsuario.getText().trim().equals("1") && new String(passField.getPassword()).equals("1")) {
			acaoOk.run();
		} else {
			JOptionPane.showMessageDialog(TelaLogin.this, "Usu�rio e/ou senha inv�lidos!");
		}

	}

}

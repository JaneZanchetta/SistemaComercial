package br.univel.telas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Button;

public abstract class MolduraAbstrata extends JPanel {
	private JPanel panel;
	private Button btnSair;

	protected abstract void configuraMiolo();

	public void setCloseAction(ActionListener action) {
		btnSair.addActionListener(action);
	}

	/**
	 * Create the panel.
	 */
	public MolduraAbstrata() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Sistema Comercial");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		panel.add(lblNewLabel);

		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, BorderLayout.SOUTH);

		btnSair = new Button("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setFont(new Font("Dialog", Font.BOLD, 12));
		panel_1.add(btnSair);

		configuraMiolo();

	}

}

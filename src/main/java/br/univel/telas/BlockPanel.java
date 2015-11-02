package br.univel.telas;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BlockPanel extends JPanel {

	/*
  * 
  */
	public BlockPanel() {
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { Double.MIN_VALUE };
		setLayout(gridBagLayout);

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				arg0.consume();
			}
		});

	}

	/**
	 * 
	 * @Author Jane Z. 01/11/2015 09:34:40
	 */

	public BlockPanel(JComponent painelCentral) {

		this();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(painelCentral, gbc_panel);
		setVisible(true);

	}

}

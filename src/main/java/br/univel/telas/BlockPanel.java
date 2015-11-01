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
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
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
	 * @Author Jane Z.
	 * 01/11/2015  09:34:40
	 */
	
	
	public BlockPanel (JComponent painelCentral) {
		
		this();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(painelCentral, gbc_panel);
		setVisible(true);

	}
	/**
	 * 
	 * @Author Jane Z.
	 * 01/11/2015  09:36:11
	 */
	private AlphaComposite ac = 
			AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = g.create();
		int h = (getWidth() / 2)
		
		
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
	}
	
	/*
	 * 
	 * 	Graphics2D g2 = (Graphics2D) g.create();
		
		int posH = (getWidth() / 2) - (image.getWidth(null) / 2);
		int posV = (getHeight() / 2) - (image.getHeight(null) / 2);
		
		g2.drawImage(image, posH, posV, null);
		
		g2.setColor(getBackground());
		g2.setComposite(alcom);
		g2.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

		for (int i = 0; i < getHeight(); i += 4) {
			g2.drawLine(0, i, getWidth(), i);
		}

		g2.dispose();

		super.paintComponent(g);
	}
	 */

}

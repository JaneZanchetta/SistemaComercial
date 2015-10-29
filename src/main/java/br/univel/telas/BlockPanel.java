package br.univel.telas;

import javax.swing.JPanel;

import java.awt.Color;
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
	
	

}

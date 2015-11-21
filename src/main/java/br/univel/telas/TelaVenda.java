package br.univel.telas;

import java.awt.BorderLayout;

public class TelaVenda extends MolduraAbstrata {

	/**
	 * @author Jane Z.
	 * 18 de nov de 2015 23:09:35
	 * Tela para inicializacao do Pane de Vendas
	 */
	
	public TelaVenda() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configuraMiolo() {
		super.add(new MioloVenda(), BorderLayout.CENTER);
		
	}
	

}

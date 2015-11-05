/**
 * @Author
 * 01/11/2015  11:01:45
 */
package br.univel.telas;

import java.awt.BorderLayout;

/**
 * @author Jane
 * 01/11/2015 11:01:45
 */

public class TelaCliente extends MolduraAbstrata {

	public TelaCliente() {
		super();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.univel.telas.MolduraAbstrata#configuraMiolo()
	 */
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadCliente(), BorderLayout.CENTER);

	}

}

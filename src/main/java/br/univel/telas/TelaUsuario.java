/**
 * @Author
 * 05/11/2015  23:03:07
 */
package br.univel.telas;

import java.awt.BorderLayout;

/**
 * @author Jane
 * 05/11/2015 23:03:07
 */
public class TelaUsuario  extends MolduraAbstrata {

	/* (non-Javadoc)
	 * @see br.univel.telas.MolduraAbstrata#configuraMiolo()
	 */
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadUsuario(), BorderLayout.CENTER);
		
	}

}

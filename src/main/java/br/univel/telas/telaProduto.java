/**
 * @Author
 * 05/11/2015  00:15:57
 */
package br.univel.telas;

import java.awt.BorderLayout;

/**
 * @author Jane
 * 05/11/2015 00:15:57
 */
public class telaProduto extends MolduraAbstrata {

	/* (non-Javadoc)
	 * @see br.univel.telas.MolduraAbstrata#configuraMiolo()
	 */
	@Override
	protected void configuraMiolo() {
		super.add(new MioloCadProduto(), BorderLayout.CENTER);
	}

}

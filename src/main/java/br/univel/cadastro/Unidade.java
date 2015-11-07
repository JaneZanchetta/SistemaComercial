package br.univel.cadastro;


public enum Unidade {
	KG,UNID,PCT,PEÇA,CAIXA;
	/**
	 * Esse laço percorre cada ítem desta enum, comparando seu valor convertido
	 * para String com o valor passado por parametro
	 * 
	 * @param value
	 * @return
	 */
	public static Unidade getEnumValue(String value) {
		for (int i = 0; i < values().length; i++) {
			if (value.equals(values()[i].toString()))
				return values()[i];
		}
		return null;
	}
	
}

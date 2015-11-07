package br.univel.cadastro;

public enum Categoria {

	LIMPEZA, FERRAMENTAS, HIGIENE, ALIMENTOS;

	/**
	 * Esse laço percorre cada ítem desta enum, comparando seu valor convertido
	 * para String com o valor passado por parametro
	 * 
	 * @param value
	 * @return
	 */
	public static Categoria getEnumValue(String value) {
		for (int i = 0; i < values().length; i++) {
			if (value.equals(values()[i].toString()))
				return values()[i];
		}
		return null;
	}
}

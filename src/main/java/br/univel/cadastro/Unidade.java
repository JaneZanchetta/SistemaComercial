package br.univel.cadastro;


public enum Unidade {
	KG,UNID,PCT,PEÇA,CAIXA;
	
	public static Unidade getEnumValue(String value){
		for (int i = 0; i < values().length; i++) {
			if(value.equals(values()[i].toString()))
				return values()[i];
		}
		return null;
	}
}

package com.example.ProgettoOOP.Types;

/**Classe che definisce il costruttore MetaData e definisce
 * i metodi get e set per le variabili, definendo anche 
 * l'Override del metodo toString().
 * @author Arianna Agresta
 * @author Marco Ciammaichella
 */

public class MetaData {
	protected String Alias;
	protected String sourceField;
	protected String Type;
	
	public MetaData(String Alias,String sourceField,String Type) {
		this.Alias=Alias;
		this.sourceField=sourceField;
		this.Type=Type;
	}

	public String getAlias() {
		return Alias;
	}

	public String getSourceField() {
		return sourceField;
	}

	public String getType() {
		return Type;
	}

	public void setAlias(String alias) {
		Alias = alias;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public void setType(String type) {
		Type = type;
	}
	@Override
	public String toString() {
		return "MetaData [Alias=" + Alias + ","+""
				+ " sourceField =" + sourceField + ", "
				+ "Type =" + Type + "]";
	}
}

package one.digitalinnovation.personapi.enums;

public enum PhoneType {
	
	RESIDENCIAL("HOME"),
	CELULAR("CELL_PHONE");

	private String tipo;
	PhoneType(String tipo) {
		this.tipo = tipo;
	}
	public String tipo() {
		return tipo;
	}

}

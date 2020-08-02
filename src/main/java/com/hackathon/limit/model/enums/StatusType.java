package com.hackathon.limit.model.enums;

public enum StatusType {
	
	SHEDULED(0,"Agendado"),
	NOW(1, "Em uso");
	
	private int cod;
	private String description;
	
	private StatusType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return this.description;
	}

	public void setDescricao(String description) {
		this.description = description;
	}
	
	public static StatusType toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(StatusType x: StatusType.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido " + cod);
	}
}

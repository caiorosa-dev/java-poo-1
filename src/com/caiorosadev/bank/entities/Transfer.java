package com.caiorosadev.bank.entities;

public class Transfer {
	private final String description;
	private final char type;
	private final double value;

	public Transfer(String description, char type, double value) {
		this.description = description;
		this.type = type;
		this.value = value;
	}

	public String getDescription() {
		return "Transferência de R$" + this.value + ", descrição: " + this.description + ", tipo: " + this.type + ".";
	}
}

package com.caiorosadev.bank.entities;

import java.util.ArrayList;
import java.util.List;

public class Account {
	private final int id;

	private double balance;
	private double limit;
	private boolean canIgnoreLimit = false;

	private final List<Transfer> transfers = new ArrayList<>();

	public Account(int id, double initialMoney) {
		this.id = id;
		this.balance = initialMoney;
	}

	public Account(int id, double initialMoney, double limit) {
		this.id = id;
		this.balance = initialMoney;
		this.limit = limit;

		if (initialMoney > 5000) {
			canIgnoreLimit = true;
		}
	}

	private void createTransfer(String description, char type, double value) {
		Transfer createdTransfer = new Transfer(description, type, value);

		transfers.add(createdTransfer);
	}

	boolean deposit(double value) {
		this.balance += value;

		createTransfer("Depósito", 'D', value);
		return true;
	}

	protected boolean withdraw(double value) {
		if (value > (balance + limit)) {
			if (!canIgnoreLimit) {
				System.out.println("Saldo insuficiente");
				return false;
			}
		} else {
			if (value > balance) {
				System.out.println("Saldo insuficiente");
				return false;
			}
		}

		this.balance -= value;

		createTransfer("Saque", 'W', value);

		return true;
	}

	protected String emitReport() {
		StringBuilder report = new StringBuilder();

		report.append("Conta N ").append(id).append("\n");
		report.append("Saldo: ").append(balance).append("\n");
		report.append("Limite: ").append(limit).append("\n");
		report.append("Transações: \n");

		for (Transfer transfer : transfers) {
			report.append(transfer.getDescription()).append("\n");
		}

		return report.toString();
	}

	public double getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}
}

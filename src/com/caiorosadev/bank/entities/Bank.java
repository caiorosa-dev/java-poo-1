package com.caiorosadev.bank.entities;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private int id;
	private String name;

	private int uniqueIdentifier = 1;
	private final List<Account> accounts = new ArrayList<>();

	public void registerAccount(double initialMoney) {
		Account account = new Account(uniqueIdentifier++, initialMoney);

		accounts.add(account);
	}

	public void createAccount(double initialMoney, double limit) {
		Account account = new Account(uniqueIdentifier++, initialMoney, limit);

		accounts.add(account);
	}

	public void deposit(int accountNumber, double value) {
		Account account = this.getAccount(accountNumber);

		if (account == null) {
			System.out.println("Não foi possível encontrar a conta com número " + accountNumber);
			return;
		}

		boolean success = account.deposit(value);

		if (!success) {
			System.out.println("Não foi possível concluir o depósito da conta " + accountNumber);
		}
	}

	public void withdraw(int accountNumber, double value) {
		Account account = this.getAccount(accountNumber);

		if (account == null) {
			System.out.println("Não foi possível encontrar a conta com número " + accountNumber);
			return;
		}

		boolean success = account.withdraw(value);

		if (!success) {
			System.out.println("Não foi possível concluir o saque da conta " + accountNumber);
		}
	}

	private Account getAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getId() == accountNumber) {
				return account;
			}
		}

		return null;
	}

	public void transfer(int accountNumber, int targetAccountNumber, double value) {
		Account account = this.getAccount(accountNumber);
		Account targetAccount = this.getAccount(targetAccountNumber);

		if (account == null || targetAccount == null) {
			System.out.println("Não foi possível encontrar a conta com número " + accountNumber);
			return;
		}

		boolean withdrawSuccess = account.withdraw(value);
		if (!withdrawSuccess) {
			System.out.println("Não foi possível realizar o saque da conta " + accountNumber);
			return;
		}

		boolean depositSuccess = targetAccount.deposit(value);
		if (!depositSuccess) {
			System.out.println("Não foi possível realizar o depósito na conta " + targetAccountNumber);
			return;
		}

		System.out.println("Transferência realizada com sucesso!");
	}

	public String emitReport(int accountNumber) {
		Account account = this.getAccount(accountNumber);

		if (account == null) {
			return "Não foi possível encontrar a conta com número " + accountNumber;
		}

		return account.emitReport();
	}
}

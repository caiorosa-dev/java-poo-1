package com.caiorosadev.bank.ui;

import com.caiorosadev.bank.entities.Account;
import com.caiorosadev.bank.entities.Bank;

import java.util.Scanner;

public class Menu {
	private Bank bank;

	public Menu() {
		this.bank = new Bank();
	}

	Scanner scanner = new Scanner(System.in);
	public void render() {
		int option = -1;

		while (option != 6) {
			System.out.flush();
			System.out.println("Bem vindo ao banco !");

			System.out.println("1. Criar uma nova conta");
			System.out.println("2. Depositar");
			System.out.println("3. Saque");
			System.out.println("4. Transferencia");
			System.out.println("5. Emitir extrato");
			System.out.println("6. Sair");

			System.out.println("Escolha uma opção: ");

			option = scanner.nextInt();

			switch (option) {
				case 1:
					System.out.println("Criar uma nova conta");
					handleCreateAccount();
					break;
				case 2:
					System.out.println("Depositar");
					handleDeposit();
					break;
				case 3:
					System.out.println("Saque");
					handleWithdraw();
					break;
				case 4:
					System.out.println("Transferencia");
					handleTransfer();
					break;
				case 5:
					System.out.println("Emitir extrato");
					handleExtract();
					break;
				case 6:
					System.out.println("Obrigado por utilizar nosso sistema. Até mais !");
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
		}
	}

	private void handleCreateAccount() {
		System.out.println("----------------------------");
		System.out.println("Criando uma nova conta...\n");

		System.out.println("Informe o saldo inicial: ");
		double initialMoney = scanner.nextDouble();

		System.out.println("Informe o limite: ");
		double limit = scanner.nextDouble();

		bank.createAccount(initialMoney, limit);
		System.out.println("Conta criada com sucesso !");
	}

	private void handleDeposit() {
		System.out.println("----------------------------");
		System.out.println("Depositar...\n");

		System.out.println("Informe o número da conta: ");
		int accountNumber = scanner.nextInt();

		System.out.println("Informe o valor do depósito: ");
		double value = scanner.nextDouble();

		bank.deposit(accountNumber, value);
	}

	private void handleWithdraw() {
		System.out.println("----------------------------");
		System.out.println("Sacar...\n");

		System.out.println("Informe o número da conta: ");
		int accountNumber = scanner.nextInt();

		System.out.println("Informe o valor do saque: ");
		double value = scanner.nextDouble();

		bank.withdraw(accountNumber, value);
	}

	private void handleTransfer() {
		System.out.println("----------------------------");
		System.out.println("Transferir...\n");

		System.out.println("Informe o número da conta de origem: ");
		int accountNumberFrom = scanner.nextInt();

		System.out.println("Informe o número da conta de destino: ");
		int accountNumberTo = scanner.nextInt();

		System.out.println("Informe o valor da transferência: ");
		double value = scanner.nextDouble();

		bank.transfer(accountNumberFrom, accountNumberTo, value);
	}

	private void handleExtract() {
		System.out.println("----------------------------");
		System.out.println("Emitir extrato...\n");

		System.out.println("Informe o número da conta: ");
		int accountNumber = scanner.nextInt();

		String report = bank.emitReport(accountNumber);

		System.out.println(report);
	}
}

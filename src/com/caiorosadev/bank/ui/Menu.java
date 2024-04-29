package com.caiorosadev.bank.ui;

import java.util.Scanner;

public class Menu {
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
					break;
				case 2:
					System.out.println("Depositar");
					break;
				case 3:
					System.out.println("Saque");
					break;
				case 4:
					System.out.println("Transferencia");
					break;
				case 5:
					System.out.println("Emitir extrato");
					break;
				case 6:
					System.out.println("Sair");
					break;
				default:
					System.out.println("Opção inválida");
					break;
			}
		}

	}
}

package main;

import java.util.InputMismatchException;
import java.util.Scanner;


abstract class Aplicacao {
	private static Scanner scanner = new Scanner(System.in);

	public static void iniciar() {
		cabecalho();
		getOpcao();
	}

	private static void cabecalho() {
		System.out.println(" ____________________________________________________________");
		System.out.println("|                                                            |");
		System.out.println("|                    Locadora de Ve�culos                    |");
		System.out.println("|____________________________________________________________|");
		System.out.println();
	}

	private static void menu() {
		System.out.println("[Menu Principal]");
		System.out.println("     1 - Menu de ve�culos");
		System.out.println("     2 - Menu de funcion�rios");
		System.out.println("     3 - Menu de clientes");
		System.out.println("     4 - Menu de loca��es");
		System.out.println();
		System.out.println("     0 - Sair");
		System.out.println();
	}

	private static void getOpcao() {
		int opcao = 1;
		do {
			menu();
			try {
				System.out.print("Escolha sua op��o: ");
				opcao = scanner.nextInt();
				escolherMenu(opcao);
			} catch (InputMismatchException error) {
				System.out.println("Voc� n�o digitou um n�mero. Por favor, digite um n�mero.");
				scanner.next();
			} catch (Exception error) {
				System.out.println("Sinto muito. Algo inesperado aconteceu. Tente novamente!");
				scanner.next();
			}
		} while (opcao != 0);
	}

	private static void escolherMenu(int opcao) {
		switch (opcao) {
		case 0:
			System.out.println("Obrigado por utilizar nosso sistema.");
			break;
		case 1:
			VeiculoMenu.menu();
			System.out.println();
			break;
		case 2:
			FuncionarioMenu.menu();
			System.out.println();
			break;
		case 3:
			ClienteMenu.menu();
			System.out.println();
			break;
		case 4:
			LocacaoMenu.menu();
			System.out.println();
			break;
		default:
			System.out.println("Op��o inv�lida.");
			System.out.println();
		}
	}
}

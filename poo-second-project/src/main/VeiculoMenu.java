package main;

import controladores.ControladorVeiculo;

public abstract class VeiculoMenu {
	private static final ControladorVeiculo controlador = new ControladorVeiculo();
	private static final Util util = new Util();

	private static void exibirMenu() {
		System.out.println();
		System.out.println("[Menu de Ve�culos]");
		System.out.println("     1 - Adicionar ve�culo");
		System.out.println("     2 - Atualizar ve�culo");
		System.out.println("     3 - Excluir ve�culo");
		System.out.println("     4 - Visualizar ve�culo");
		System.out.println();
		System.out.println("     0 - Sair");
	}

	public static void menu() {
		getOpcao();
	}

	private static void getOpcao() {
		int opcao = 1;
		do {
			exibirMenu();
			opcao = util.getInt("Escolha sua op��o: ");
			escolherMenu(opcao);
		} while (opcao != 0);
	}

	private static void escolherMenu(int opcao) {
		switch (opcao) {
		case 0:
			System.out.println("Retornando ao menu principal.");
			break;
		case 1:
			adicionarVeiculo();
			System.out.println();
			break;
		case 2:
			atualizarVeiculo();
			System.out.println();
			break;
		case 3:
			excluirVeiculo();
			System.out.println();
			break;
		case 4:
			listarVeiculo();
			System.out.println();
			break;
		default:
			System.out.println("Op��o inv�lida.");
			System.out.println();
		}
	}

	private static void menuVeiculo() {
		System.out.println("[Menu de Adicionar Ve�culos]");
		System.out.println("Voc� deseja adicionar qual tipo de ve�culo?");
		System.out.println(" 1 - Carro");
		System.out.println(" 2 - Moto");
		System.out.println();
		System.out.println(" 0 - Sair");
	}

	private static void adicionarVeiculo() {
		int opcao = 1;
		do {
			menuVeiculo();
			opcao = util.getInt("Escolha sua op��o: ");
			if (opcao == 1 || opcao == 2) {
				controlador.inserirVeiculo(opcao);
			} else if (opcao != 0) {
				System.out.println("Op��o inv�lida.");
			}
		} while (opcao != 0);
	}

	private static void atualizarVeiculo() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do ve�culo para ser atualizado ou 0 para sair: ");
			if (id != 0)
				controlador.atualizarVeiculo(id);
		} while (id != 0);
	}
	
	private static void excluirVeiculo() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do ve�culo para ser exclu�do ou 0 para sair: ");
			if (id != 0)
				controlador.deletarVeiculo(id);
		} while (id != 0);
	}
	
	private static void listarVeiculo() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do ve�culo para ser listado ou 0 para sair: ");
			if(id != 0)
				controlador.listarVeiculo(id);
		} while (id != 0);
	}
}

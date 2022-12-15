package main;

import controladores.ControladorFuncionario;

public abstract class FuncionarioMenu {
	private static final ControladorFuncionario controlador = new ControladorFuncionario();
	private static final Util util = new Util();

	private static void exibirMenu() {
		System.out.println();
		System.out.println("[Menu de Funcion�rios]");
		System.out.println("     1 - Adicionar funcion�rio");
		System.out.println("     2 - Atualizar funcion�rio");
		System.out.println("     3 - Excluir funcion�rio");
		System.out.println("     4 - Visualizar funcion�rio");
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
			adicionarFuncionario();
			System.out.println();
			break;
		case 2:
			atualizarFuncionario();
			System.out.println();
			break;
		case 3:
			excluirFuncionario();
			System.out.println();
			break;
		case 4:
			listarFuncionario();
			System.out.println();
			break;
		default:
			System.out.println("Op��o inv�lida.");
			System.out.println();
		}
	}

	private static void adicionarFuncionario() {
		controlador.inserirFuncionario();
	}

	private static void atualizarFuncionario() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do funcion�rio para ser atualizado ou 0 para sair: ");
			if (id != 0)
				controlador.atualizarFuncionario(id);
		} while (id != 0);
	}
	
	private static void excluirFuncionario() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do funcion�rio para ser exclu�do ou 0 para sair: ");
			if (id != 0)
				controlador.deletarFuncionario(id);
		} while (id != 0);
	}
	
	private static void listarFuncionario() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do funcion�rio para ser listado ou 0 para sair: ");
			if(id != 0)
				controlador.listarFuncionario(id);
		} while (id != 0);
	}
}

package main;

import controladores.ControladorLocacao;

public abstract class LocacaoMenu {
	private static final ControladorLocacao controlador = new ControladorLocacao();
	private static final Util util = new Util();

	private static void exibirMenu() {
		System.out.println();
		System.out.println("[Menu de Loca��es]");
		System.out.println("     1 - Adicionar loca��o");
		System.out.println("     2 - Atualizar loca��o");
		System.out.println("     3 - Excluir loca��o");
		System.out.println("     4 - Visualizar loca��o");
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
			adicionarLocacao();
			System.out.println();
			break;
		case 2:
			atualizarLocacao();
			System.out.println();
			break;
		case 3:
			excluirLocacao();
			System.out.println();
			break;
		case 4:
			listarLocacao();
			System.out.println();
			break;
		default:
			System.out.println("Op��o inv�lida.");
			System.out.println();
		}
	}

	private static void adicionarLocacao() {
		controlador.inserirLocacao();
	}

	private static void atualizarLocacao() {
		int id = 1;
		do {
			id = util.getInt("Digite o id da loca��o para ser atualizado ou 0 para sair: ");
			if (id != 0)
				controlador.atualizarLocacao(id);
		} while (id != 0);
	}
	
	private static void excluirLocacao() {
		int id = 1;
		do {
			id = util.getInt("Digite o id da loca��o para ser exclu�do ou 0 para sair: ");
			if (id != 0)
				controlador.deletarLocacao(id);
		} while (id != 0);
	}
	
	private static void listarLocacao() {
		int id = 1;
		do {
			id = util.getInt("Digite o id da loca��o para ser listado ou 0 para sair: ");
			if(id != 0)
				controlador.listarLocacao(id);
		} while (id != 0);
	}
}

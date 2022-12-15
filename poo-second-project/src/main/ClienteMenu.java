package main;

import controladores.ControladorCliente;

public abstract class ClienteMenu {
	private static final ControladorCliente controlador = new ControladorCliente();
	private static final Util util = new Util();

	private static void exibirMenu() {
		System.out.println();
		System.out.println("[Menu de Clientes]");
		System.out.println("     1 - Adicionar cliente");
		System.out.println("     2 - Atualizar cliente");
		System.out.println("     3 - Excluir cliente");
		System.out.println("     4 - Visualizar cliente");
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
			opcao = util.getInt("Escolha sua opção: ");
			escolherMenu(opcao);
		} while (opcao != 0);
	}

	private static void escolherMenu(int opcao) {
		switch (opcao) {
		case 0:
			System.out.println("Retornando ao menu principal.");
			break;
		case 1:
			adicionarCliente();
			System.out.println();
			break;
		case 2:
			atualizarCliente();
			System.out.println();
			break;
		case 3:
			excluirCliente();
			System.out.println();
			break;
		case 4:
			listarCliente();
			System.out.println();
			break;
		default:
			System.out.println("Opção inválida.");
			System.out.println();
		}
	}

	private static void menuCliente() {
		System.out.println("[Menu de Adicionar Clientes]");
		System.out.println("Você deseja adicionar qual tipo de cliente?");
		System.out.println(" 1 - Pessoa Física");
		System.out.println(" 2 - Pessoa Jurídica");
		System.out.println();
		System.out.println(" 0 - Sair");
	}

	private static void adicionarCliente() {
		int opcao = 1;
		do {
			menuCliente();
			opcao = util.getInt("Escolha sua opção: ");
			if (opcao == 1 || opcao == 2) {
				controlador.inserirCliente(opcao);
			} else if (opcao != 0) {
				System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
	}

	private static void atualizarCliente() {
		Integer id = 1;
		do {
			id = util.getInt("Digite o id do cliente para ser atualizado ou 0 para sair: ");
			if (id != 0)
				controlador.atualizarCliente(id);
		} while (id != 0);
	}
	
	private static void excluirCliente() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do cliente para ser excluído ou 0 para sair: ");
			if (id != 0)
				controlador.deletarCliente(id);
		} while (id != 0);
	}
	
	private static void listarCliente() {
		int id = 1;
		do {
			id = util.getInt("Digite o id do cliente para ser listado ou 0 para sair: ");
			if(id != 0)
				controlador.listarCliente(id);
		} while (id != 0);
	}
}

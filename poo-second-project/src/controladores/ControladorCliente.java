package controladores;

import entidades.Cliente;
import entidades.ClientePessoaFisica;
import entidades.ClientePessoaJuridica;
import main.Util;
import repositorios.RepositorioClienteArray;

public class ControladorCliente {
	private final RepositorioClienteArray repositorioCliente = new RepositorioClienteArray();
	Util util = new Util();
	private int id = 1; // TODO ao persistir os dados, lembrar de atualizar esse campo

	public void inserirCliente(int opcao) {
		if (opcao == 1) {
			ClientePessoaFisica cliente = criarClientePessoaFisica();
			repositorioCliente.inserirCliente(cliente);
		} else {
			ClientePessoaJuridica cliente = criarClientePessoaJuridica();
			repositorioCliente.inserirCliente(cliente);
		}
	}

	public Cliente procurarCliente(Integer id) {
		return repositorioCliente.procurarCliente(id);
	}

	public void atualizarCliente(Integer id) {
		Cliente cliente = procurarCliente(id);
		if (cliente.getClass() == new ClientePessoaFisica().getClass()) {
			ClientePessoaFisica clientePessoaFisica = atualizarClientePessoaFisica((ClientePessoaFisica) cliente);
			clientePessoaFisica.setId(id);
			repositorioCliente.atualizarClientePessoaFisica(clientePessoaFisica);
		} else {
			ClientePessoaJuridica clientePessoaJuridica = atualizarClientePessoaJuridica((ClientePessoaJuridica) cliente);
			clientePessoaJuridica.setId(id);
			repositorioCliente.atualizarClientePessoaJuridica(clientePessoaJuridica);
		}
	}

	public void deletarCliente(Integer id) {
		repositorioCliente.deletarCliente(id);
	}

	private ClientePessoaJuridica criarClientePessoaJuridica() {
		ClientePessoaJuridica cliente = new ClientePessoaJuridica();
		cliente.setCnpj(util.getString("Digite o CNPJ do cliente: "));
		cliente.setRazaoSocial(util.getString("Digite a raz�o social do cliente: "));
		criarCliente(cliente);
		return cliente;
	}

	private ClientePessoaFisica criarClientePessoaFisica() {
		ClientePessoaFisica cliente = new ClientePessoaFisica();
		adicionarDadosDoClientePessoaFisica(cliente);
		criarCliente(cliente);
		return cliente;
	}

	private void adicionarDadosDoClientePessoaFisica(ClientePessoaFisica cliente) {
		cliente.setNome(util.getString("Digite o nome do cliente: "));
		cliente.setDataNascimento(util.getData());
		cliente.setCpf(util.getString("Digite o cpf do cliente: "));
		cliente.setSexo(util.getSexo("Digite o sexo do cliente [M ou F]: "));
	}

	private ClientePessoaFisica atualizarClientePessoaFisica(ClientePessoaFisica cliente) {
		adicionarDadosDoClientePessoaFisica(cliente);
		adicionarDadosDoCliente(cliente);
		return cliente;
	}

	private void adicionarDadosDoClientePessoaJuridica(ClientePessoaJuridica cliente) {
		cliente.setCnpj(util.getString("Digite o CNPJ do cliente: "));
		cliente.setRazaoSocial(util.getString("Digite a raz�o social do cliente: "));
	}

	private ClientePessoaJuridica atualizarClientePessoaJuridica(ClientePessoaJuridica cliente) {
		adicionarDadosDoClientePessoaJuridica(cliente);
		adicionarDadosDoCliente(cliente);
		return cliente;
	}

	private void criarCliente(Cliente cliente) {
		cliente.setId(id++);
		adicionarDadosDoCliente(cliente);
	}

	private void adicionarDadosDoCliente(Cliente cliente) {
		cliente.setEmail(util.getString("Digite o email do cliente: "));
		cliente.setEndereco(util.getString("Digite o endere�o do cliente: "));
		cliente.setTelefone(util.getString("Digite o telefone do cliente: "));
	}

	public void listarCliente(Integer id) {
		Cliente cliente = procurarCliente(id);
		if (cliente != null)
			exibirCliente(cliente);
	}

	private void exibirCliente(Cliente cliente) {
		System.out.println("[Exibindo cliente]");
		Boolean ePessoaFisica = cliente.getClass() == new ClientePessoaFisica().getClass();
		if (ePessoaFisica) {
			System.out.println("   Tipo: Pessoa F�sica");
			System.out.println("   Nome: " + ((ClientePessoaFisica) cliente).getNome());
			System.out.println("   CPF: " + ((ClientePessoaFisica) cliente).getCpf());
			System.out.println("   Data de nascimento: " + ((ClientePessoaFisica) cliente).getDataNascimento());
			System.out.println("   Sexo: " + ((ClientePessoaFisica) cliente).getSexo());
		} else {
			System.out.println("   Tipo: Pessoa Jur�dica");
			System.out.println("   Raz�o Social: " + ((ClientePessoaJuridica) cliente).getRazaoSocial());
			System.out.println("   CNPJ: " + ((ClientePessoaJuridica) cliente).getCnpj());
		}
		System.out.println("   Email: " + cliente.getEmail());
		System.out.println("   Endere�o: " + cliente.getEndereco());
		System.out.println("   Telefone: " + cliente.getTelefone());
	}
}

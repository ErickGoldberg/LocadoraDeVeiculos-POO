package controladores;

import entidades.Funcionario;
import main.Util;
import repositorios.RepositorioFuncionarioArray;

public class ControladorFuncionario {
	private final RepositorioFuncionarioArray repositorioFuncionario = new RepositorioFuncionarioArray();
	private final Util util = new Util();
	private int id = 1;

	private Funcionario criarFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setCpf(util.getString("Digite o CPF do funcionário: "));
		funcionario.setEmail(util.getString("Digite o email do funcionário: "));
		funcionario.setEndereco(util.getString("Digite o endereço do funcionário: "));
		funcionario.setNome(util.getString("Digite o nome do funcionário: "));
		funcionario.setSalario(util.getFloat("Digite o salário do funcionário: "));
		funcionario.setTelefone(util.getString("Digite o telefone do funcioniário: "));
		return funcionario;
	}

	public void inserirFuncionario() {
		Funcionario funcionario = criarFuncionario();
		funcionario.setId(id++);
		repositorioFuncionario.inserirFuncionario(funcionario);
	}

	public Funcionario procurarFuncionario(Integer id) {
		return repositorioFuncionario.procurarFuncionario(id);
	}

	public void atualizarFuncionario(Integer id) {
		Funcionario funcionario = criarFuncionario();
		funcionario.setId(id);
		repositorioFuncionario.atualizarFuncionario(funcionario);
	}

	public void deletarFuncionario(Integer id) {
		repositorioFuncionario.deletarFuncionario(id);
	}

	public void listarFuncionario(Integer id) {
		Funcionario funcionario = procurarFuncionario(id);
		if (funcionario != null)
			exibirFuncionario(funcionario);
	}

	private void exibirFuncionario(Funcionario funcionario) {
		System.out.println("[Exibindo funcionário]");
		System.out.println("   Nome: " + funcionario.getNome());
		System.out.println("   CPF: " + funcionario.getCpf());
		System.out.println("   Endereço: " + funcionario.getEndereco());
		System.out.println("   Telefone: " + funcionario.getTelefone());
		System.out.println("   Salário: R$" + funcionario.getSalario());
		System.out.println("   Email: " + funcionario.getEmail());
	}
}

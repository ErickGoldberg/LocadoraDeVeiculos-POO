package repositorios;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entidades.Funcionario;

public class RepositorioFuncionarioArray implements RepositorioFuncionario {
	ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

	@Override
	public void atualizarFuncionario(Funcionario novoFuncionario) {
		Funcionario funcionario = procurarFuncionario(novoFuncionario.getId());
		funcionario.setCpf(novoFuncionario.getCpf());
		funcionario.setEmail(novoFuncionario.getEmail());
		funcionario.setEndereco(novoFuncionario.getEndereco());
		funcionario.setNome(novoFuncionario.getNome());
		funcionario.setSalario(novoFuncionario.getSalario());
		funcionario.setTelefone(novoFuncionario.getTelefone());
	}

	@Override
	public void deletarFuncionario(Integer id) {
		funcionarios.removeIf(funcionario -> funcionario.getId() == id);
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	@Override
	public Funcionario procurarFuncionario(Integer id) {
		try {
			return funcionarios.stream().filter(funcionario -> funcionario.getId() == id).collect(Collectors.toList())
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Este funcionário não existe.");
			return null;
		} catch (Exception e) {
			System.out.println("Algo inesperado aconteceu. Por favor, tente novamente.");
			return null;
		}
	}
}

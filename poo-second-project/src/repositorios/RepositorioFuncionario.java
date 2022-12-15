package repositorios;

import entidades.Funcionario;

public interface RepositorioFuncionario {
	void inserirFuncionario(Funcionario funcionario);
	Funcionario procurarFuncionario(Integer id);
	void atualizarFuncionario(Funcionario funcionario);
	void deletarFuncionario(Integer id);
}

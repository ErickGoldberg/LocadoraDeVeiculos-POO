package repositorios;

import entidades.Cliente;
import entidades.ClientePessoaFisica;
import entidades.ClientePessoaJuridica;

public interface RepositorioCliente {
	void inserirCliente(Cliente cliente);
	Cliente procurarCliente(Integer id);
	void atualizarClientePessoaFisica(ClientePessoaFisica cliente);
	void atualizarClientePessoaJuridica(ClientePessoaJuridica cliente);
	void deletarCliente(Integer id);
}

package repositorios;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entidades.Cliente;
import entidades.ClientePessoaFisica;
import entidades.ClientePessoaJuridica;

public class RepositorioClienteArray implements RepositorioCliente {
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	@Override
	public void inserirCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	@Override
	public Cliente procurarCliente(Integer id) {
		try {
			return clientes.stream().filter(cliente -> cliente.getId() == id).collect(Collectors.toList())
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Este cliente não existe.");
			return null;
		} catch (Exception e) {
			System.out.println("Algo inesperado aconteceu. Por favor, tente novamente.");
			return null;
		}
	}

	private void atualizarCliente(Cliente cliente, Cliente novoCliente) {
		cliente.setEmail(cliente.getEmail());
		cliente.setEndereco(cliente.getEndereco());
		cliente.setTelefone(cliente.getTelefone());
	}
	
	@Override
	public void atualizarClientePessoaFisica(ClientePessoaFisica novoCliente) {
		ClientePessoaFisica cliente = (ClientePessoaFisica) procurarCliente(novoCliente.getId());
		atualizarCliente(cliente, novoCliente);
		cliente.setCpf(novoCliente.getCpf());
		cliente.setDataNascimento(novoCliente.getDataNascimento());
		cliente.setNome(novoCliente.getNome());
		cliente.setSexo(novoCliente.getSexo());
	}
	
	@Override
	public void atualizarClientePessoaJuridica(ClientePessoaJuridica novoCliente) {
		ClientePessoaJuridica cliente = (ClientePessoaJuridica) procurarCliente(novoCliente.getId());
		atualizarCliente(cliente, novoCliente);
		cliente.setCnpj(novoCliente.getCnpj());
		cliente.setRazaoSocial(novoCliente.getRazaoSocial());
	}

	@Override
	public void deletarCliente(Integer id) {
		clientes.removeIf(cliente -> (cliente.getId() == id));
	}
}

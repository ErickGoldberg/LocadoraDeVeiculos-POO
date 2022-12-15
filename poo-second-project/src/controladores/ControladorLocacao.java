package controladores;

import entidades.Locacao;
import main.Util;
import repositorios.RepositorioLocacaoArray;

public class ControladorLocacao {
	private int id = 1;
	private final RepositorioLocacaoArray repositorioLocacao = new RepositorioLocacaoArray();
	private final Util util = new Util();
	private final ControladorCliente controladorCliente = new ControladorCliente();
	private final ControladorFuncionario controladorFuncionario = new ControladorFuncionario();
	private final ControladorVeiculo controladorVeiculo = new ControladorVeiculo();

	private Locacao criarLocacao() {
		Locacao locacao = new Locacao();
		locacao.setCliente(controladorCliente.procurarCliente(util.getInt("Digite o número do id do cliente: ")));
		locacao.setDataDeEntrega(util.getData("Digite o ano da entrega: "));
		locacao.setDataDeRetirada(util.getData("Digite o ano da retirada: "));
		locacao.setFuncionario(controladorFuncionario.procurarFuncionario(util.getInt("Digite o número do id do funcionário: ")));
		locacao.setVeiculo(controladorVeiculo.procurarVeiculo(util.getInt("Digite o número do id do veículo: ")));
		locacao.setValorDaLocacao(20F);
		return locacao;
	}

	public void inserirLocacao() {
		Locacao locacao = criarLocacao();
		locacao.setId(id++);
		repositorioLocacao.inserirLocacao(locacao);
	}

	public Locacao procurarLocacao(Integer id) {
		return repositorioLocacao.procurarLocacao(id);
	}

	public void atualizarLocacao(Integer id) {
		Locacao locacao = criarLocacao();
		locacao.setId(id);
		repositorioLocacao.atualizarLocacao(locacao);
	}

	public void deletarLocacao(Integer id) {
		repositorioLocacao.deletarLocacao(id);
	}

	public void listarLocacao(Integer id) {
		Locacao locacao = procurarLocacao(id);
		if (locacao != null)
			exibirLocacao(locacao);
	}

	private void exibirLocacao(Locacao locacao) {
		System.out.println("[Exibindo locação]");
		System.out.println("   Email do cliente: " + locacao.getCliente().getEmail());
		System.out.println("   Endereço do cliente: " + locacao.getCliente().getEndereco());
		System.out.println("   Marca do veículo: " + locacao.getVeiculo().getMarca());
		System.out.println("   Modelo do veículo: " + locacao.getVeiculo().getModelo());
		System.out.println("   Placa do veículo: " + locacao.getVeiculo().getPlaca());
		System.out.println("   Nome do funcionário: " + locacao.getFuncionario().getNome());
		System.out.println("   Data de retirada do veículo: " + locacao.getDataDeRetirada());
		System.out.println("   Data de entrega do veículo: " + locacao.getDataDeEntrega());
		System.out.println("   Valor da locação: R$ " + locacao.getValorDaLocacao());
	}
}

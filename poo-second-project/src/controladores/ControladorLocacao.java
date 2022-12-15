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
		locacao.setCliente(controladorCliente.procurarCliente(util.getInt("Digite o n�mero do id do cliente: ")));
		locacao.setDataDeEntrega(util.getData("Digite o ano da entrega: "));
		locacao.setDataDeRetirada(util.getData("Digite o ano da retirada: "));
		locacao.setFuncionario(controladorFuncionario.procurarFuncionario(util.getInt("Digite o n�mero do id do funcion�rio: ")));
		locacao.setVeiculo(controladorVeiculo.procurarVeiculo(util.getInt("Digite o n�mero do id do ve�culo: ")));
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
		System.out.println("[Exibindo loca��o]");
		System.out.println("   Email do cliente: " + locacao.getCliente().getEmail());
		System.out.println("   Endere�o do cliente: " + locacao.getCliente().getEndereco());
		System.out.println("   Marca do ve�culo: " + locacao.getVeiculo().getMarca());
		System.out.println("   Modelo do ve�culo: " + locacao.getVeiculo().getModelo());
		System.out.println("   Placa do ve�culo: " + locacao.getVeiculo().getPlaca());
		System.out.println("   Nome do funcion�rio: " + locacao.getFuncionario().getNome());
		System.out.println("   Data de retirada do ve�culo: " + locacao.getDataDeRetirada());
		System.out.println("   Data de entrega do ve�culo: " + locacao.getDataDeEntrega());
		System.out.println("   Valor da loca��o: R$ " + locacao.getValorDaLocacao());
	}
}

package repositorios;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entidades.Locacao;

public class RepositorioLocacaoArray implements RepositorioLocacao {
	ArrayList<Locacao> locacoes = new ArrayList<Locacao>();

	@Override
	public void atualizarLocacao(Locacao novaLocacao) {
		Locacao locacao = procurarLocacao(novaLocacao.getId());
		locacao.setCliente(novaLocacao.getCliente());
		locacao.setDataDeEntrega(novaLocacao.getDataDeEntrega());
		locacao.setDataDeRetirada(novaLocacao.getDataDeRetirada());
		locacao.setFuncionario(novaLocacao.getFuncionario());
		locacao.setId(novaLocacao.getId());
		locacao.setValorDaLocacao(novaLocacao.getValorDaLocacao());
		locacao.setVeiculo(novaLocacao.getVeiculo());
	}

	@Override
	public void deletarLocacao(Integer id) {
		locacoes.removeIf(locacao -> locacao.getId() == id);
	}

	@Override
	public void inserirLocacao(Locacao locacao) {
		locacoes.add(locacao);
	}

	@Override
	public Locacao procurarLocacao(Integer id) {
		try {
			return locacoes.stream().filter(locacao -> locacao.getId() == id).collect(Collectors.toList())
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Esta locação não existe.");
			return null;
		} catch (Exception e) {
			System.out.println("Algo inesperado aconteceu. Por favor, tente novamente.");
			return null;
		}
	}
}

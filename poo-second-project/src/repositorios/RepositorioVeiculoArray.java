package repositorios;

import java.util.ArrayList;
import java.util.stream.Collectors;

import entidades.Carro;
import entidades.Moto;
import entidades.Veiculo;

public class RepositorioVeiculoArray implements RepositorioVeiculo {
	ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

	private boolean verificarVeiculo(Veiculo veiculo, Integer idVeiculo) {
		return veiculo.getId() == idVeiculo;
	}

	@Override
	public void inserirVeiculo(Veiculo veiculo) {
		veiculos.add(veiculo);
	}

	@Override
	public Veiculo procurarVeiculo(Integer idVeiculo) {
		try {
			return veiculos.stream().filter(veiculo -> veiculo.getId() == idVeiculo).collect(Collectors.toList())
					.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Este veículo não existe.");
			return null;
		} catch (Exception e) {
			System.out.println("Algo inesperado aconteceu. Por favor, tente novamente.");
			return null;
		}
	}

	private void atualizarVeiculo(Veiculo veiculo, Veiculo novoVeiculo) {
		veiculo.setCor(novoVeiculo.getCor());
		veiculo.setEstaDisponivel(novoVeiculo.getEstaDisponivel());
		veiculo.setMarca(novoVeiculo.getMarca());
		veiculo.setModelo(novoVeiculo.getModelo());
		veiculo.setPlaca(novoVeiculo.getPlaca());
		veiculo.setQuilometragem(novoVeiculo.getQuilometragem());
	}
	
	@Override
	public void atualizarCarro(Carro carro) {
		Carro veiculo = (Carro) procurarVeiculo(carro.getId());
		atualizarVeiculo(veiculo, carro);
		veiculo.setQuantidadeDePortas(carro.getQuantidadeDePortas());
	}
	
	@Override
	public void atualizarMoto(Moto moto) {
		Moto veiculo = (Moto) procurarVeiculo(moto.getId());
		atualizarVeiculo(veiculo, moto);
		veiculo.setVolumeDoBagageiro(moto.getVolumeDoBagageiro());
	}

	@Override
	public void deletarVeiculo(Integer idVeiculo) {
		veiculos.removeIf(veiculo -> verificarVeiculo(veiculo, idVeiculo));
	}
}

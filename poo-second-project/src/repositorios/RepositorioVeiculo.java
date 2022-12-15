package repositorios;

import entidades.Carro;
import entidades.Moto;
import entidades.Veiculo;

public interface RepositorioVeiculo {
	void inserirVeiculo(Veiculo veiculo);
	Veiculo procurarVeiculo(Integer idVeiculo);
	void atualizarCarro(Carro carro);
	void atualizarMoto(Moto moto);
	void deletarVeiculo(Integer idVeiculo);
}

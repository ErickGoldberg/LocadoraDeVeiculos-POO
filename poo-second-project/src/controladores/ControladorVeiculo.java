package controladores;

import entidades.Carro;
import entidades.Moto;
import entidades.Veiculo;
import main.Util;
import repositorios.RepositorioVeiculoArray;

public class ControladorVeiculo {
	private final RepositorioVeiculoArray repositorioVeiculo = new RepositorioVeiculoArray();
	private final Util util = new Util();
	private int id = 1;

	private Carro criarCarro() {
		Carro carro = new Carro();
		carro.setCor(util.getString("Digite a cor do carro: "));
		carro.setMarca(util.getString("Digite a marca do carro: "));
		carro.setModelo(util.getString("Digite o modelo do carro: "));
		carro.setPlaca(util.getString("Digite a placa do carro: "));
		carro.setQuantidadeDePortas(util.getInt("Digite a quantidade de portas do carro: "));
		carro.setQuilometragem(util.getFloat("Digite a quilometragem do carro: "));
		carro.setEstaDisponivel(true);
		return carro;
	}

	private Moto criarMoto() {
		Moto moto = new Moto();
		moto.setCor(util.getString("Digite a cor da moto: "));
		moto.setMarca(util.getString("Digite a marca da moto: "));
		moto.setModelo(util.getString("Digite o modelo da moto: "));
		moto.setPlaca(util.getString("Digite a placa da moto: "));
		moto.setVolumeDoBagageiro(util.getFloat("Digite o volume do bagageiro da moto: "));
		moto.setQuilometragem(util.getFloat("Digite a quilometragem da moto: "));
		moto.setEstaDisponivel(true);
		return moto;
	}

	private Carro inserirCarro() {
		Carro carro = criarCarro();
		carro.setId(id++);
		return carro;
	}

	private Moto inserirMoto() {
		Moto moto = criarMoto();
		moto.setId(id++);
		return moto;
	}

	public void inserirVeiculo(int opcao) {
		if (opcao == 1) {
			Carro carro = inserirCarro();
			repositorioVeiculo.inserirVeiculo(carro);
		} else {
			Moto moto = inserirMoto();
			repositorioVeiculo.inserirVeiculo(moto);
		}
	}

	public Veiculo procurarVeiculo(Integer id) {
		return repositorioVeiculo.procurarVeiculo(id);
	}

	public void atualizarVeiculo(int id) {
		Veiculo veiculo = procurarVeiculo(id);
		if (veiculo.getClass() == new Carro().getClass()) {
			Carro carro = criarCarro();
			carro.setId(id);
			repositorioVeiculo.atualizarCarro(carro);
		} else {
			Moto moto = criarMoto();
			repositorioVeiculo.atualizarMoto(moto);
		}
	}

	public void deletarVeiculo(Integer id) {
		repositorioVeiculo.deletarVeiculo(id);
	}

	public void listarVeiculo(Integer id) {
		Veiculo veiculo = procurarVeiculo(id);
		if (veiculo != null)
			exibirVeiculo(veiculo);
	}

	private void exibirVeiculo(Veiculo veiculo) {
		System.out.println("[Exibindo veículo]");
		Boolean eCarro = veiculo.getClass() == new Carro().getClass();
		if (eCarro)
			System.out.println("   Tipo: Carro");
		else
			System.out.println("   Tipo: Moto");
		System.out.println("   Marca: " + veiculo.getMarca());
		System.out.println("   Modelo: " + veiculo.getModelo());
		System.out.println("   Cor: " + veiculo.getCor());
		System.out.println("   Quilometragem: " + veiculo.getQuilometragem());
		System.out.println("   Está disponível: " + veiculo.getEstaDisponivel());
		System.out.println("   Placa: " + veiculo.getPlaca());
		if (eCarro)
			System.out.println("   Quantidade de Portas: " + ((Carro) veiculo).getQuantidadeDePortas());
		else
			System.out.println("   Volume do bagageiro em litros: " + ((Moto) veiculo).getVolumeDoBagageiro());
	}

}

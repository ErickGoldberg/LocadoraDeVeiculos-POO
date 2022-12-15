package entidades;

public abstract class Veiculo {
	private String marca;
	private Float quilometragem;
	private Boolean estaDisponivel;
	private String placa;
	private String cor;
	private String modelo;
	private Integer id;

	public Float getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(Float quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean getEstaDisponivel() {
		return estaDisponivel;
	}

	public void setEstaDisponivel(Boolean estaDisponivel) {
		this.estaDisponivel = estaDisponivel;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
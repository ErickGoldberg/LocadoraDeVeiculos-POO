package entidades;
import java.util.Date;

public class Locacao {
	private int id;
	private Date dataDeRetirada;
	private Date dataDeEntrega;
	private Float valorDaLocacao;
	private Veiculo veiculo;
	private Cliente cliente;
	private Funcionario funcionario;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataDeRetirada() {
		return dataDeRetirada;
	}
	
	public void setDataDeRetirada(Date dataDeRetirada) {
		this.dataDeRetirada = dataDeRetirada;
	}
	
	public Date getDataDeEntrega() {
		return dataDeEntrega;
	}
	
	public void setDataDeEntrega(Date dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	
	public Float getValorDaLocacao() {
		return valorDaLocacao;
	}
	
	public void setValorDaLocacao(Float valorDaLocacao) {
		this.valorDaLocacao = valorDaLocacao;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
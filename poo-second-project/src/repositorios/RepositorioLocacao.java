package repositorios;

import entidades.Locacao;

public interface RepositorioLocacao {
	void inserirLocacao(Locacao funcionario);
	Locacao procurarLocacao(Integer id);
	void atualizarLocacao(Locacao funcionario);
	void deletarLocacao(Integer id);
}

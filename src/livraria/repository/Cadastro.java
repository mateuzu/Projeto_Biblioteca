package livraria.repository;

public interface Cadastro {

	public boolean verificarSenha(String usuario, Integer senha);
	public void cadastrarAluno(String nome);
	public void listarCadastros();
	public void removerAluno(Integer matricula);
	public int gerarNumero();
}

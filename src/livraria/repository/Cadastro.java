package livraria.repository;

public interface Cadastro {

	public boolean verificarSenha(String usuario, int senha);
	public void cadastrarAluno(String nome);
	public void listarCadastros();
	public void removerAluno(int matricula);
	public int gerarNumero();
	public boolean encontrarAluno(int matricula);
}

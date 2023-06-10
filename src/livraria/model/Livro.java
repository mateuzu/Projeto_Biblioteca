package livraria.model;

public class Livro {
	
	private String nome;
	private int codigo;
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}

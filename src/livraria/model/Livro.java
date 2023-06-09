package livraria.model;

public class Livro {
	
	private String nome;
	private Integer codigo;
	
	public Livro() {
		// TODO Auto-generated constructor stub
	}

	public Livro(String nome, Integer codigo) {
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

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}

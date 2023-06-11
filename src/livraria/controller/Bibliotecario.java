package livraria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import livraria.model.Aluno;
import livraria.repository.Cadastro;
import livraria.util.Cores;

public class Bibliotecario implements Cadastro {
	private String Usuario;
	private int senha;
	private int numero = 0;
	private List<Aluno> alunos = new ArrayList<>();

	public Bibliotecario() {
	}

	public Bibliotecario(String Usuario, int senha) {
		this.Usuario = Usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String Usuario) {
		this.Usuario = Usuario;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public boolean verificarSenha(String Usuario, int senha) {
		if (Usuario.equals("Admin") && senha == 123) {
			aguardarSenha();
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\nLogin realizado com sucesso!\n" + Cores.TEXT_RESET);
			keyPress();
			return true;
		} else {
			System.out.println(
					Cores.TEXT_RED_BOLD_BRIGHT + "\nLogin incorreto, verique o usuário e senha e tente novamente.\n" + Cores.TEXT_RESET);
			return false;
		}
	}

	@Override
	public void cadastrarAluno(String nome) {
		Aluno aluno = new Aluno(nome, gerarNumero());
		alunos.add(aluno);
		System.out
				.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Alune " + aluno.getNome() + " cadastrado!" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Matrícula: " + aluno.getMatricula());
	}

	@Override
	public void listarCadastros() {
		if (alunos.isEmpty()) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Nenhum alune cadastrado!" + Cores.TEXT_RESET);
		}
		for (Aluno alunos : alunos) {
			System.out.println("° Alune: " + alunos.getNome() + ", matrícula: " + alunos.getMatricula());
		}
	}

	@Override
	public void removerAluno(int matricula) {
		Aluno alunoRemovido = null;
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula() == matricula) {
				alunoRemovido = aluno;
			}
		}
		Optional<Aluno> testaAluno = Optional.ofNullable(alunoRemovido);
		if (testaAluno.isPresent()) {
			alunos.remove(alunoRemovido);
			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "O alune " + alunoRemovido.getNome() + " de matrícula: "
					+ alunoRemovido.getMatricula() + " foi removido!" + Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Não foi encontrado nenhum alune com esta matrícula: "
					+ matricula + Cores.TEXT_RESET);
		}
	}

	public void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "Pressione enter para continuar...");
			int key = System.in.read();
			if (key != 13) {
				System.out.println("Você pressionou uma tecla diferente de Enter!");
			}
		} catch (IOException e) {
			System.out.println("Erro de entrada/saída ocorreu ao aguardar a tecla Enter!");
		}
	}

	public static void aguardarSenha() {
		System.out.println("Verificando login...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Erro ao verificar senha!");
			return;
		}
	}

	@Override
	public int gerarNumero() {
		return ++numero;
	}
}

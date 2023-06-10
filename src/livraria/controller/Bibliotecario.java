package livraria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import livraria.model.Aluno;
import livraria.repository.Cadastro;
import livraria.util.Cores;

public class Bibliotecario implements Cadastro {
	private String Bibliotecario;
	private int senha;
	private int numero = 0;
	private List<Aluno> alunos = new ArrayList<>();

	public Bibliotecario() {
	}

	public Bibliotecario(String Bibliotecario, int senha) {
		this.Bibliotecario = Bibliotecario;
		this.senha = senha;
	}

	public String getBibliotecario() {
		return Bibliotecario;
	}

	public void setBibliotecario(String Bibliotecario) {
		this.Bibliotecario = Bibliotecario;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public boolean verificarSenha(String Bibliotecario, int senha) {
<<<<<<< HEAD
		if (Bibliotecario.equals("teste") && senha == 123) {
=======
		if(Bibliotecario.equals("Admin") && senha == 123) {
>>>>>>> 813617deeb956a474ad46afc6e80e164f5d430e1
			aguardarSenha();
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Login feito com sucesso!" + Cores.TEXT_RESET);
			keyPress();
			return true;
		} else {
<<<<<<< HEAD
			System.out.println(
					Cores.TEXT_RED_BOLD_BRIGHT + "\nLogin incorreto, verique o usuário ou senha!\n" + Cores.TEXT_RESET);
=======
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Login incorreto, verifique usuário/senha e tente novamente.\n" + Cores.TEXT_RESET);
>>>>>>> 813617deeb956a474ad46afc6e80e164f5d430e1
			return false;
		}
	}

	@Override
	public void cadastrarAluno(String nome) {
		Aluno aluno = new Aluno(nome, gerarNumero());
		alunos.add(aluno);
<<<<<<< HEAD
		System.out
				.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Alune " + aluno.getNome() + " cadastrado!" + Cores.TEXT_RESET);
=======
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Alune " + aluno.getNome() + " cadastrado!" + Cores.TEXT_RESET);
>>>>>>> 813617deeb956a474ad46afc6e80e164f5d430e1
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Matrícula: " + aluno.getMatricula());
	}

	@Override
	public void listarCadastros() {
<<<<<<< HEAD
		if (alunos.isEmpty()) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Nenhum alune cadastrado!" + Cores.TEXT_RESET);
		}
		for (Aluno alunos : alunos) {
=======
		if(alunos.isEmpty()) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Nenhum alune cadastrado!" + Cores.TEXT_RESET);
		}
		for(Aluno alunos : alunos) {
>>>>>>> 813617deeb956a474ad46afc6e80e164f5d430e1
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
<<<<<<< HEAD
			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "O alune " + alunoRemovido.getNome() + " de matrícula: "
					+ alunoRemovido.getMatricula() + " foi removido!" + Cores.TEXT_RESET);
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Não foi encontrado nenhum alune com esta matrícula: "
					+ matricula + Cores.TEXT_RESET);
=======
			System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT +"O alune " + alunoRemovido.getNome()
				+ " de matrícula: " + alunoRemovido.getMatricula() + " foi removido!" + Cores.TEXT_RESET);
>>>>>>> 813617deeb956a474ad46afc6e80e164f5d430e1
		}
	}

	public void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "Pressione enter para continuar...");
			int key = System.in.read();
			if (key != 13) {
<<<<<<< HEAD
				System.out.println("Você pressionou uma tecla diferente de Enter!");
			}
=======
	            System.out.println("Você pressionou uma tecla diferente de Enter!");
	        }
>>>>>>> 813617deeb956a474ad46afc6e80e164f5d430e1
		} catch (IOException e) {
			System.out.println("Erro de entrada/saída ocorreu ao aguardar a tecla Enter!");
		}
	}

	public static void aguardarSenha() {
<<<<<<< HEAD
		System.out.println("Verificando login...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println("Erro ao verificar senha!");
			return;
		}
	}
=======
        System.out.println("Verificando login...");
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
        	Thread.currentThread().interrupt(); 
            System.err.println("Erro ao verificar login!");
            return;
        }
    }
>>>>>>> 813617deeb956a474ad46afc6e80e164f5d430e1

	@Override
	public int gerarNumero() {
		return ++numero;
	}
}

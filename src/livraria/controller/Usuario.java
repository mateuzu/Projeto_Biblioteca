package livraria.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import livraria.model.Aluno;
import livraria.repository.Cadastro;
import livraria.util.Cores;

public class Usuario implements Cadastro {
	private String usuario;
	private int senha;
	private int numero = 0;
	private List<Aluno> alunos = new ArrayList<>();
	
	public Usuario() {}

	public Usuario(String usuario, int senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	@Override
	public boolean verificarSenha(String usuario, int senha) {
		if(usuario.equals("teste") && senha == 123) {
			aguardarSenha();
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Login sucedido!" + Cores.TEXT_RESET);
			keyPress();
			return true;
		} else {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Login incorreto, entre com usuário/senha corretos!\n" + Cores.TEXT_RESET);
			return false;
		}
	}

	@Override
	public void cadastrarAluno(String nome) {
		Aluno aluno = new Aluno(nome, gerarNumero());
		alunos.add(aluno);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Aluno " + aluno.getNome() + " cadastrado!" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "Matrícula: " + aluno.getMatricula());
	}
		
	@Override
	public void listarCadastros() {
		if(alunos.isEmpty()) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Nenhum aluno cadastrado!" + Cores.TEXT_RESET);
		}
		for(Aluno alunos : alunos) {
			System.out.println("° Aluno: " + alunos.getNome() + ", matrícula: " + alunos.getMatricula());
		}
	}

	@Override
	public void removerAluno(int matricula) {
		Aluno alunoRemovido = null;
		for(Aluno aluno : alunos) {
			if(aluno.getMatricula() == matricula) {
				alunoRemovido = aluno;
			}
		}
		Optional<Aluno> testaAluno = Optional.ofNullable(alunoRemovido);
		if(testaAluno.isPresent()) {
			alunos.remove(alunoRemovido);
			System.out.println("O aluno " + alunoRemovido.getNome() + " de matrícula: " + alunoRemovido.getMatricula() + " foi removido!");
		}
		else {
			System.out.println("Não foi encontrado nenhum aluno com esta matrícula: " + matricula);
		}
	}
	
	public void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + " Pressione enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
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

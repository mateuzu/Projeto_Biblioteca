package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import livraria.controller.Usuario;
import livraria.model.Biblioteca;
import livraria.model.Livro;
import livraria.util.Cores;

public class TestaBiblioteca {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Livro> livros = new ArrayList<>();
		int opcao = 1;
		livros.add(new Livro("Dom quixote", 1));
		livros.add(new Livro("Diario de um banana", 2));
		livros.add(new Livro("O alquimista", 3));
		Biblioteca b1 = new Biblioteca(livros);
		
		System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Bem vindo à biblioteca!" + Cores.TEXT_RESET);
		System.out.print("Informe seu usuário: ");
		String usuario = sc.nextLine();
		System.out.print("Informe sua senha: ");
		int senha = sc.nextInt();
		Usuario user = new Usuario(usuario, senha);
		
		while(user.verificarSenha(usuario, senha) == false) {
			System.out.print("Informe seu usuário: ");
			sc.nextLine();
			usuario = sc.nextLine();
			System.out.print("Informe sua senha: ");
			senha = sc.nextInt();
		}
		user.keyPress();
		while(true) {
			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "\n*****************************************"
					+ "\n* Menu:                                 *"
					+ "\n* 1 - Cadastrar aluno                   *"
					+ "\n* 2 - Visualizar cadastro do aluno      *"
					+ "\n* 3 - Adicionar livro                   *"
					+ "\n* 4 - Retirar um livro pelo código      *"
					+ "\n* 5 - Devolver um livro                 *"
					+ "\n* 6 - Encontrar um livro pelo código    *"
					+ "\n* 7 - Listar livros disponíveis         *"
					+ "\n* 8 - Sair                              *"
					+ "\n*****************************************" + Cores.TEXT_RESET);
			System.out.print("\nEntre com a opção desejada: ");
			try {
				opcao = sc.nextInt();
			} catch(InputMismatchException e) {
				System.err.println("Digite valores inteiros! ");
				sc.nextLine();
				opcao = 0;
			}

			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Cadastrar aluno: \n" + Cores.TEXT_RESET);
				sc.nextLine();
				System.out.print("Informe o nome do aluno: ");
				String nome = sc.nextLine();
				user.cadastrarAluno(nome);
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Visualizar cadastro alunos: \n" + Cores.TEXT_RESET);
				user.listarCadastros();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Adicionar livro: \n" + Cores.TEXT_RESET);
				sc.nextLine();
				System.out.print("Informe o nome do livro: ");
				String nomeLivro = sc.nextLine();
			
				b1.adicionarLivro(nomeLivro);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Retirar livro: \n" + Cores.TEXT_RESET);
				System.out.print("Entre com o código do livro que deseja retirar: ");
				int cod = sc.nextInt();
				b1.retirarLivro(cod);
				keyPress();
				break;
			case 5: 
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Devolver livro: \n" + Cores.TEXT_RESET);
				System.out.print("Entre com o código do livro que deseja devolver: ");
				cod = sc.nextInt();
				b1.devolverLivro(cod);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Encontrar livro: \n" + Cores.TEXT_RESET);
				System.out.print("Informe o código do livro: ");
				cod = sc.nextInt();
				b1.encontrarLivro(cod);
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "Listar livros: \n" + Cores.TEXT_RESET);
				b1.listarLivros();
				keyPress();
				break;
			case 8:
				encerrar();
				sc.close();
				System.exit(0);
			default:
				System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nOpção inválida!" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
			b1.aguardar();
		}
		
	}
	
	public static void encerrar() {
        System.out.println("Encerrando programa...");
        try {
            Thread.sleep(3000); 
        } catch (InterruptedException e) {
        	Thread.currentThread().interrupt(); 
            System.out.println("Erro ao encerrar programa!");
            return;
        }
		System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "\nPrograma encerrado!" + Cores.TEXT_RESET);
    }
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\nPressione enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}
	
}

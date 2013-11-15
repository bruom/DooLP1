package mainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import biblio.*;
import fileReaderWriter.Escrevinhator;
import fileReaderWriter.FilesIn;

public class MainSoQueNao {

	public static void main(String[] args) throws IOException, JAXBException {

		// login();
		singin();

	}

	// ========================================

	public static Usuario login() throws IOException, JAXBException {
		Usuario u = null;
		String userName = "";
		String password = "";
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> usersList = FilesIn.usuarios();

		while (u == null) {// enquanto u for NULL...
			System.out.println("Entre com seu nome de usuario:/n");
			userName = s.readLine();

			// verifica se usuario existe.
			for (String userIdTemp : usersList) {
				if (userIdTemp.contains(userName)) {
					// se existir pergunte a senha e inicialize o mesmo.
					// verifica a permicao do usuario.

					if (userIdTemp.contains("aluno")) {
						u = (Aluno) Escrevinhator.fromXML("aluno-" + userName);
					} else if (userIdTemp.contains("admin")) {
						u = (Admin) Escrevinhator.fromXML("admin-" + userName);
					} else if (userIdTemp.contains("prof")) {
						u = (Professor) Escrevinhator.fromXML("prof-"
								+ userName);
					} else if (userIdTemp.contains("editora")) {
						u = (Editora) Escrevinhator.fromXML("editora-"
								+ userName);
					} else {
						u = (Usuario) Escrevinhator.fromXML("usuario-"
								+ userName);
					}

					while (!u.getPass().equals(password)) {
						// enquanto a senha nao bater, pergunte a senha.
						System.out.println("Entre com sua senha:");
						password = s.readLine();
						if (!u.getPass().equals(password)) {
							// avisar que a senha esta errada
							System.out.println("Senha errada!");
						}
					}
					// se senha bater, retorne o usuario
					System.out.println("Bem Vindo " + u.getId() + u.getNome()
							+ "!");
					return u;
				}
			}
		}

		return null;

	}

	public static void singin() throws IOException, JAXBException {
		System.out.println("Inscricao de Novo Usuario");
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int op;
		

		do {
			System.out.println("Entre com o username");
			String username = s.readLine();
			System.out.println("Escolha a permissao");
			System.out.println("Aluno - 1\nProfessor - 2\nEditora - 3\nAdmin - 4");
			op = Integer.parseInt(s.readLine());
			switch (op) {
			case 1:
				if (!FilesIn.usuarios().contains(
						"aluno-" + username + ".usuario")) {
					Aluno aluno = new Aluno();
					System.out.println("Entre com seu Nome");
					aluno.setNome(s.readLine());
					System.out.println("Entre com a nova senha");
					aluno.setPass(s.readLine());
					aluno.setId("aluno-" + username);
					Escrevinhator.toXML(aluno);
					System.out.println("Usuario Aluno Criado!");
				} else {
					op = 0;
				}
				break;
			case 2:
				if (!FilesIn.usuarios().contains(
						"prof-" + username + ".usuario")) {
					Professor professor = new Professor();
					System.out.println("Entre com seu Nome");
					professor.setNome(s.readLine());
					System.out.println("Entre com a nova senha");
					professor.setPass(s.readLine());
					professor.setId("prof-" + username);
					Escrevinhator.toXML(professor);
					System.out.println("Usuario Professor Criado!");
				} else {
					op = 0;
				}
				break;
			case 3:
				if (!FilesIn.usuarios().contains(
						"editora-" + username + ".usuario")) {
					Editora editora = new Editora();
					System.out.println("Entre com o nome da editora");
					editora.setNome(s.readLine());
					System.out.println("Entre com a nova senha");
					editora.setPass(s.readLine());
					editora.setId("editora-" + username);
					Escrevinhator.toXML(editora);
					System.out.println("Usuario Editora Criado!");
				} else {
					op = 0;
				}
				break;
			case 4:
				if (!FilesIn.usuarios().contains(
						"admin-" + username + ".usuario")) {
					Admin admin = new Admin();
					System.out.println("Entre com o nome do administrador");
					admin.setNome(s.readLine());
					System.out.println("Entre com a nova senha");
					admin.setPass(s.readLine());
					admin.setId("admin-" + username);
					Escrevinhator.toXML(admin);
					System.out.println("Usuario Editora Criado!");
				} else {
					op = 0;
				}
				break;
			default:
				break;
			}
			if(op==0){
				System.out.println("Por favor, escolha um outro username");
			}
		} while (op == 0);

	}

	// ========================================

	public static void criaLivro() {
		Scanner stdin = new Scanner(System.in);
		System.out.println("Teste de upload de Livro!");
		Livro l = new Livro();

		System.out.println("Insira o titulo do livro:");
		System.out.println(stdin.nextLine());
		l.setTitulo(stdin.nextLine());

		System.out.println("Insira o autor:");
		l.setAutor(stdin.nextLine());

		System.out.println("Insira o ID do livro:");
		l.setId("liv-" + stdin.nextLine());

		System.out
				.println("As palavras chave separadas por ';' palavra chave:");
		String[] aux = stdin.nextLine().split(";");
		for (String s : aux) {
			l.addKeyword(s);
		}

		System.out.println("Insira a editora");
		l.setEditora(stdin.nextLine());

		System.out.println("Insira Preco");
		l.setPreco(stdin.nextDouble());

		System.out.println("Insira Ano");
		l.setAno(stdin.nextInt());

		System.out.println("Insira Ano");
		l.setGenero(stdin.nextLine());

		try {
			Escrevinhator.toXML(l);
		} catch (JAXBException e) {
			System.out.println("ERRO MALUCO DO K7");
			e.printStackTrace();
		}
		stdin.close();
	}

	// ==================================

	public static void criaRevista() {
		Scanner stdin = new Scanner(System.in);
		System.out.println("Teste de upload de Livro!");
		Revista l = new Revista();

		System.out.println("Insira o titulo do livro:");
		System.out.println(stdin.nextLine());
		l.setTitulo(stdin.nextLine());

		System.out.println("Insira o autor:");
		l.setAutor(stdin.nextLine());

		System.out.println("Insira o ID do livro:");
		l.setId("rev-" + stdin.nextLine());

		System.out
				.println("As palavras chave separadas por ';' palavra chave:");
		String[] aux = stdin.nextLine().split(";");
		for (String s : aux) {
			l.addKeyword(s);
		}

		System.out.println("Insira Publicacao");
		l.setPublicacao(stdin.nextLine());

		try {
			Escrevinhator.toXML(l);
		} catch (JAXBException e) {
			System.out.println("ERRO MALUCO DO K7");
			e.printStackTrace();
		}

	}

}

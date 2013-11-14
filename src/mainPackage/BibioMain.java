package mainPackage;
 
import java.util.ArrayList;
import java.util.Scanner;
 
import javax.xml.bind.JAXBException;
 
import biblio.*;
 
import fileReaderWriter.Escrevinhator;
 
public class BibioMain {
	static Scanner stdin = new Scanner(System.in);
	
	
	public BibioMain() throws JAXBException{
		Acervo acervo = (Acervo)Escrevinhator.fromXML("ACERVO");
		
		System.out.println("Bem vindo ao Bibliotecator v.1!");
		System.out.println("Um projeto por Bruno Omella e Gabriel Melo.");
		System.out.println("Lembre-se de ler o arquivo 'readMe' na documentacao!");
		

		Usuario user = login();
		mainMenu(user);
	}
	
	
	public static void main(String[]args) throws JAXBException{
		BibioMain bibio = new BibioMain();
	}
	
	
	public static void busca(Acervo acervo) throws JAXBException{

		ArrayList<String> al = new ArrayList<String>();
		System.out.println("Acessando sistema de consulta de acervo.");
		System.out.println("Digite os termos-chave da pesquisa, separados por ';' :");
		String[] aux = stdin.nextLine().split(";");
		for(String s: aux){
			al.add(s);
		}
		Texto t = acervo.consultaAcervo(al).get(0);
		System.out.println(t.getTitulo());
	}
	
	
	public static void escolheTipo() throws JAXBException{
		int tipo;
		System.out.println("Criação de um novo usuário");
		System.out.println("Escolha o tipo de usuário a criar:\n1.Aluno\n2.Professor\n3.Editora\n4.Admin");
		tipo = stdin.nextInt();
		switch(tipo){
			case 1:
				criaUsuario(new Aluno(),"aluno-");
				break;
			case 2:
				criaUsuario(new Professor(),"prof-");
				break;
			case 3:
				criaUsuario(new Editora(),"editora-");
				break;
			case 4:
				criaUsuario(new Admin(),"admin-");
				break;
		}
	}
	
	
	public static void criaUsuario(Usuario user, String s) throws JAXBException{
		System.out.println("Registro de novo usuário");
		System.out.println("Insira o nome de usuário:");
		System.out.println(stdin.nextLine());
		user.setNome(stdin.nextLine());
		System.out.println("Insira a senha do novo usuário:");
		user.setPass(stdin.nextLine());
		user.setId(s + user.getNome());
		Escrevinhator.toXML(user);		
	}
	
	
	public static Usuario login() throws JAXBException{
		String userIn = null;
		String id= null;
		Admin user = null;
		int tipo;
		boolean match = false;
		
		/*do{System.out.println("Selecione seu tipo de usuario:\n1.Aluno\n2.Professor\n3.Editora\n4.Admin");
		tipo = stdin.nextInt();
		} while(tipo<1 || tipo>4);
		
		switch(tipo){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}*/

		while(match == false){
			boolean name = false;
			while(name==false){
				System.out.println("\nDigite seu nome de usuário: ");
				userIn = stdin.next();
				name = validaUser(userIn);
				stdin.reset();
			}
			user = (Admin)Escrevinhator.fromXML("admin"+userIn);
			stdin.reset();
			System.out.println("\nInsira sua senha: ");
			userIn = stdin.next();
			if(userIn.equals(user.getPass())){
				System.out.println("\nAutenticacao concluida. Entrando...\n");
				match = true;
			}
			else if(userIn != user.getPass())
				System.out.println("\nSenha incorreta.");
		}
		return user;
	}
	
	public static boolean validaUser(String id){
		try {
			Escrevinhator.fromXML("admin"+id);
			return true;
		} catch (JAXBException e) {
			System.out.println("Usuario nao existente!");
		}
		return false;
	}
	
	
	public static void upload(Acervo acervo){
		System.out.println("\n.\n.\n.\nTeste de upload de Livro!");
		Livro l = new Livro();
		System.out.println("Insira o ID do livro:");
		System.out.println(stdin.nextLine());
		String temp = stdin.nextLine();
		l.setId(temp);
		acervo.addIndex(temp);
		System.out.println("Insira o titulo do livro:");
		l.setTitulo(stdin.nextLine());
		System.out.println("Insira o autor:");
		l.setAutor(stdin.nextLine());
		System.out.println("Insira uma palavra chave:");
		l.addKeyword(stdin.nextLine());
		
		try {
			Escrevinhator.toXML(l);
		} catch (JAXBException e) {
			System.out.println("ERRO MALUCO DO K7");
			e.printStackTrace();
		}
	}
	
	public static void mainMenu(Usuario user){
		int tipo = user.getPermissao();
		System.out.println("Bem vindo, " + user.getNome());
		System.out.println("Menu principal: ");
		switch(tipo){
		
		
		case 0:

			System.out.println("1.Acessar acervo\n2.Minha conta\n3.Log-out");
			break;
			
			
			
		case 1:
			System.out.println("1.Acessar acervo\n2.Upload de Artigos\n3.Minha conta\n4.Log-out");
			break;
			
			
			
		case 2:
			System.out.println("1.Acessar acervo\n2.Upload de Livros\n3.Minha conta\n4.Log-out");
			break;
			
			
			
		case 3:
			System.out.println("1.Acessar acervo\n2.Upload de Textos\n3.Atualizar usuarios\n4.Minha conta\n5.Log-out");
			break;
		}
	}
	 
}
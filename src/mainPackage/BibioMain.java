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
		
		login();
		
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
				criaUsuario(new Aluno());
				break;
			case 2:
				criaUsuario(new Professor());
				break;
			case 3:
				criaUsuario(new Editora());
				break;
			case 4:
				criaUsuario(new Admin());
				break;
		}
	}
	
	
	public static void criaUsuario(Usuario user) throws JAXBException{
		System.out.println("Registro de novo usuário");
		System.out.println("Insira o nome de usuário:");
		user.setNome(stdin.nextLine());
		System.out.println("Insira a senha do novo usuário:");
		user.setPass(stdin.nextLine());
		Escrevinhator.toXML(user);		
	}
	
	
	public static void login() throws JAXBException{
		String userIn = null;
		String id= null;
		Usuario user;
 
		boolean match = false;
 
		while(match == false){
			boolean name = false;
			while(name==false){
				System.out.println("\nDigite seu nome de usuário: ");
				userIn = stdin.next();
				name = validaUser(userIn);
				stdin.reset();
			}
			user = (Usuario)Escrevinhator.fromXML("usuario-"+userIn);
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
	}
	
	public static boolean validaUser(String id){
		try {
			Usuario user = (Usuario)Escrevinhator.fromXML("usuario-"+id);
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
	 
}
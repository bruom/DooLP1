package mainPackage;
 
import java.util.ArrayList;
import java.util.Scanner;
 
import javax.xml.bind.JAXBException;
 
import biblio.*;
 
import fileReaderWriter.Escrevinhator;
 
public class BibioMain {
	
	
	public BibioMain() throws JAXBException{
		Acervo a = new Acervo();
		Escrevinhator.toXML(a);
		Acervo acervo = (Acervo)Escrevinhator.fromXML("ACERVO");
		Scanner stdin = new Scanner(System.in);
		String userIn;
		String senha;
		String nome;
		Usuario user = new Usuario();
		
		System.out.println("Bem vindo ao Bibliotecator v.1!");
		System.out.println("Um projeto por Bruno Omella e Gabriel Melo.");
		System.out.println("Lembre-se de ler o arquivo 'readMe' na documentacao!");
		System.out.println("\nDigite seu nome de usuário: ");
		userIn = stdin.next();
		
//		System.out.println("Gibe senha");
//		senha = stdin.next();
//		System.out.println("Gibe nome");
//		nome = stdin.next();
//		
//		user.setId(userIn);
//		user.setNome(nome);
//		user.setPass(senha);
//		
//		Escrevinhator.toXML(user);
		
		
		try {
			user = (Usuario)Escrevinhator.fromXML("usuario-"+userIn);
		} catch (JAXBException e) {
			System.out.println("Usuario nao existente!");
		}
		
		System.out.println("\nInsira sua senha: ");
		userIn = stdin.next();
		if(userIn.equals(user.getPass()))
			System.out.println("\nAutenticacao concluida. Entrando...\n");
		else if(userIn != user.getPass())
			System.out.println("\nSenha incorreta.");
		
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
		
		busca(acervo);
		
	}
	
	public static void main(String[]args) throws JAXBException{
		BibioMain bibio = new BibioMain();
	}
	
	public static void busca(Acervo acervo) throws JAXBException{
		Scanner stdin = new Scanner(System.in);
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
	 
}
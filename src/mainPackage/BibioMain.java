package mainPackage;
 
import java.util.Scanner;
 
import javax.xml.bind.JAXBException;
 
import biblio.*;
 
import fileReaderWriter.Escrevinhator;
 
public class BibioMain {
	
	public static void main(String[]args){
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
		l.setId(stdin.nextLine());
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
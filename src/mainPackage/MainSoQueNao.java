package mainPackage;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import biblio.Livro;
import fileReaderWriter.Escrevinhator;

public class MainSoQueNao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void criaLivro(){
		Scanner stdin = new Scanner(System.in);
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
		stdin.close();
	}

}

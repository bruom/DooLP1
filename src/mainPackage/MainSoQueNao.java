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
		System.out.println(stdin.nextLine());
		System.out.println("Teste de upload de Livro!");
		Livro l = new Livro();
		
		System.out.println("Insira o titulo do livro:");
		l.setTitulo(stdin.nextLine());
		
		System.out.println("Insira o autor:");
		l.setAutor(stdin.nextLine());
		
		System.out.println("Insira o ID do livro:");
		l.setId(stdin.nextLine());
		
		System.out.println("As palavras chave separadas por ';' palavra chave:");
		String[] aux = stdin.nextLine().split(";");
        for(String s: aux){
            l.addKeyword(s);
        }
        
        System.out.println("Insira a editora");
		l.setEditora(stdin.nextLine());
		
		 System.out.println("Insira Preco");
		l.setPreco(stdin.nextDouble());
		
		
		try {
			Escrevinhator.toXML(l);
		} catch (JAXBException e) {
			System.out.println("ERRO MALUCO DO K7");
			e.printStackTrace();
		}
		stdin.close();
	}

}

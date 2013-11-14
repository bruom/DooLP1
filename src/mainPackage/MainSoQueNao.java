package mainPackage;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import biblio.*;
import fileReaderWriter.Escrevinhator;

public class MainSoQueNao {

	public static void main(String[] args) {
		
//		criaRevista();
		
		Texto txt = null;
		try {
			txt = (Texto) Escrevinhator.fromXML("rev-Veja");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(txt instanceof Revista){
			System.out.println("é um livro!");
		}
		

	}
	
	
	public static void criaLivro(){
		Scanner stdin = new Scanner(System.in);
		System.out.println("Teste de upload de Livro!");
		Livro l = new Livro();
		
		System.out.println("Insira o titulo do livro:");
		System.out.println(stdin.nextLine());
		l.setTitulo(stdin.nextLine());
		
		System.out.println("Insira o autor:");
		l.setAutor(stdin.nextLine());
		
		System.out.println("Insira o ID do livro:");
		l.setId("liv-"+stdin.nextLine());
		
		System.out.println("As palavras chave separadas por ';' palavra chave:");
		String[] aux = stdin.nextLine().split(";");
        for(String s: aux){
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
	//==================================
	
	public static void criaRevista(){
		Scanner stdin = new Scanner(System.in);
		System.out.println("Teste de upload de Livro!");
		Revista l = new Revista();
		
		System.out.println("Insira o titulo do livro:");
		System.out.println(stdin.nextLine());
		l.setTitulo(stdin.nextLine());
		
		System.out.println("Insira o autor:");
		l.setAutor(stdin.nextLine());
		
		System.out.println("Insira o ID do livro:");
		l.setId("rev-"+stdin.nextLine());
		
		System.out.println("As palavras chave separadas por ';' palavra chave:");
		String[] aux = stdin.nextLine().split(";");
        for(String s: aux){
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

package biblio;
 
import java.util.ArrayList;
import java.util.Scanner;
 
import fileReaderWriter.Escrevinhator;
import interfaces.Gravavel;
 
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
 
@XmlRootElement
public class Usuario implements Gravavel{
	private String id;
	private String nome;
	private String pass;
	private ArrayList<String> comprados = new ArrayList<String>();
	
	public Usuario(){};
 
	
	@XmlAttribute
	public void setId(String s){
		this.id = s;
	}
	
	@Override
	public String getId(){
		return this.id;
	}
	
	@XmlElement
	public void setNome(String s){
		this.nome = s;
	}
	
	public String getNome(){
		return nome;
	}
	
	@XmlElement
	public void setPass(String s){
		this.pass = s;
	}
	
	public String getPass(){
		return this.pass;
	}
	
	@XmlElement
	public void setComprados(ArrayList<String> ids){
		this.comprados = ids;
	}
	
	public void addComprado(String id){
		this.comprados.add(id);
	}
	
	public ArrayList<String> getComprados(){
		return this.comprados;
	}
	
	/**
	 * este metodo retorna o tipo de usuario do objeto na forma de um int, sendo:
	 * 0 - aluno;
	 * 1 - professor;
	 * 2 - editora;
	 * 3 - admin;
	 * 
	 * como default, irá retornar 0, mas isto nunca deveria acontecer... em teoria..
	 */
	public int getPermissao(){
		if(this instanceof Aluno){
			return 0;
		}
		else if(this instanceof Professor){
			return 1;
		}
		else if(this instanceof Editora){
			return 2;
		}
		else if(this instanceof Admin){
			return 3;
		}
		else
			return 0;
	}
	
	@Override
	public String toString(){
		String tipo;
		switch(this.getPermissao()){
			case 1:
				tipo = "professor";
				break;
			case 2:
				tipo = "editora";
				break;
			case 3:
				tipo = "admin";
				break;
			default:
				tipo = "aluno";
				break;
		}
		String saida = "Usuário " + id + "\nNivel de permissao: " + tipo + "\nNome: " + nome + "\nSenha: " + pass;
		if(comprados.size()>0){
			saida += "\nIds dos livros comprados: \n";
			for(String id : comprados){
				saida += id + ";\n";
			}
		}
		else
			saida += "\nNenhum livro comprado.";
		return saida;
	}
	
	public void consultaUsuario(){
		System.out.println(this.toString());
	}
	
	public void atualizarUsuario() throws JAXBException{
		int opt;
		boolean exit = false;
		Scanner stdin = new Scanner(System.in);
		System.out.println("Atualizando os dados do seguinte usuario:");
		this.consultaUsuario();
		while(exit == false){
			System.out.println("\nQual campo deseja atualizar?\n1.Nome\n2.Senha\n3.Adicionar Livros Comprados\n4.Remover Livros Comprados\n5.Sair");
			opt = stdin.nextInt();
			switch(opt){
				case 1:
					System.out.println("\nInsira o novo nome: ");
					System.out.println(stdin.nextLine());
					this.setNome(stdin.nextLine());
					break;
				case 2:
					System.out.println("\nInsira a nova senha: ");
					System.out.println(stdin.nextLine());
					this.setPass(stdin.nextLine());
					break;
				case 3:
					System.out.println("\nInsira o id do livro a ser adicionado (formato 'liv-xxxx'): ");
					this.comprados.add(stdin.nextLine());
					System.out.println(stdin.nextLine());
					break;
				case 4:
					System.out.println("\nInsira o indice do item a ser removido (lembrando que o primeiro e 0): ");
					this.comprados.remove(stdin.nextInt());
					System.out.println(stdin.nextLine());
					break;
				default:
					System.out.println("\nSaindo...");
					exit = true;
					break;
			}
			
		}
		stdin.close();
		Escrevinhator.toXML(this);
		
	}
 
}
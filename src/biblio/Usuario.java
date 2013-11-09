package biblio;

import interfaces.Gravavel;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Usuario implements Gravavel{
	private String id;
	private String nome;
	private String pass;
	
	public Usuario(){};

	
	@XmlAttribute
	public void setId(String s){
		this.id = s;
	}
	
	@Override
	public String getId(){
		return "usuario-"+this.id;
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

}

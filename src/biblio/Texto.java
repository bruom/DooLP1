package biblio;

import interfaces.Gravavel;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Texto implements Gravavel{
	private String titulo;
	private String autor;
	private ArrayList<String> keywords = new ArrayList<String>();
	private String id;
	
	public Texto(){
		
	}
	
	@XmlAttribute
	public void setId(String s){
		this.id = s;
	}
	
	@Override
	public String getId(){
		return this.id;
	}
	
	@XmlElement
	public void setTitulo(String s){
		this.titulo = s;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	@XmlElement
	public void setAutor(String s){
		this.autor = s;
	}
	
	public String getAutor(){
		return this.autor;
	}
	
	@XmlElement
	public void setKeywords(ArrayList<String> al){
		this.keywords = al;
	}
	
	public void addKeyword(String s){
		this.keywords.add(s);
	}
	
	public ArrayList<String> getKeywords(){
		return this.keywords;
	}
	
}

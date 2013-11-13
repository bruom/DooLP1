package biblio;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Livro extends Texto {
	
	private String editora;
	private double preco;
	private int ano;
	private String genero;
	
	public Livro(){
		super();
	}
	
	@XmlElement
	public void setEditora(String editora){
		this.editora = editora;
	}
	
	public String getEditora(){
		return this.editora;
	}
	
	@XmlElement
	public void setPreco(double preco){
		this.preco = preco;
	}
	
	public double getPreco(){
		return this.preco;
	}
	
	@XmlElement
	public void setAno(int ano){
		this.ano = ano;
	}
	
	public int getAno(){
		return this.ano;
	}
	
	@XmlElement
	public void setGenero(String genero){
		this.genero = genero;
	}
	
	public String getGenero(){
		return this.genero;
	}

}

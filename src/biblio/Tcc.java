package biblio;

import javax.xml.bind.annotation.XmlElement;

public class Tcc extends Texto {
	
	private String instituicao;
	private String orientador;
	private String tema;
	
	public Tcc(){
		super();
	}
	
	@XmlElement
	public void setInstituicao(String instituicao){
		this.instituicao = instituicao;
	}
	
	public String getInstituicao(){
		return this.instituicao;
	}
	
	@XmlElement
	public void setOrientador(String orientador){
		this.orientador = orientador;
	}
	
	public String getOrientador(){
		return this.orientador;
	}
	
	@XmlElement
	public void setTema(String tema){
		this.tema = tema;
	}
	
	public String getTema(){
		return this.tema;
	}

}

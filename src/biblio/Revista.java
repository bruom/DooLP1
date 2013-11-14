package biblio;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Revista extends Artigo {
	
	private String publicacao;
	private String data;
	private String pagina;
	
	
	public Revista(){
		super();
	}
	
	@XmlElement
	public void setPublicacao(String publicacao){
		this.publicacao = publicacao;
	}
	
	public String getPublicacao(){
		return this.publicacao;
	}
	
	@XmlElement
	public void setData(String data){
		this.data = data;
	}
	
	public String getData(){
		return this.data;
	}
	
	@XmlElement
	public void setPagina(String pagina){
		this.pagina = pagina;
	}
	
	public String getPagina(){
		return this.pagina;
	}

}

package biblio;

import javax.xml.bind.annotation.XmlElement;

public class ArtigoCongresso extends Artigo {

	private String evento;
	private String data;
	private String local;
	
	public ArtigoCongresso(){
		super();
	}
	
	@XmlElement
	public void setEvento(String evento){
		this.evento = evento;
	}
	
	public String getEvento(){
		return this.evento;
	}
	
	@XmlElement
	public void setData(String data){
		this.data = data;
	}
	
	public String getData(){
		return this.data;
	}
	
	@XmlElement
	public void setLocal(String local){
		this.local = local;
	}
	
	public String getLocal(){
		return this.local;
	}
}

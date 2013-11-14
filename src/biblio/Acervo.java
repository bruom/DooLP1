package biblio;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import fileReaderWriter.Escrevinhator;
import interfaces.Gravavel;

@XmlRootElement
public class Acervo implements Gravavel {

	private final String id = "ACERVO";
	private ArrayList<String> index = new ArrayList<String>();
	
	
	public ArrayList<Texto> consultaAcervo(ArrayList<String> palavrasChave) throws JAXBException{
		ArrayList<Texto> lista = new ArrayList<Texto>();
		
		for(String palavraChaveTemp:palavrasChave){
			for(String idTemp:this.index){
				
				if(((Texto) Escrevinhator.fromXML(idTemp)).getKeywords().contains(palavraChaveTemp)){
					lista.add((Texto) Escrevinhator.fromXML(idTemp));
				}
				
			}
		}
		
		return lista;
	}
	
	
	
	@XmlAttribute
	public void setIndex(ArrayList<String> index){
		this.index = index;
	}
	
	@Override
	public String getId() {
		return this.id;
	}

}

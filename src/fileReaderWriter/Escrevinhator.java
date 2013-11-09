package fileReaderWriter;

import java.io.File;
import biblio.*;
import interfaces.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Escrevinhator {

	private final static String root =  "data"
			+ File.separator;
	private final static String textos = root + "textos" + File.separator;
	private final static String usuarios = root + "usuarios" + File.separator;

	/**
	 * Recebe um Gravavel e o grava em um arquivo.
	 * 
	 * 
	 * @param o Gravavel
	 * @throws JAXBException
	 */
	public static void toXML(Gravavel o) throws JAXBException {
		
		File file = null;
		JAXBContext jaxbContext = null;
		
		if(o instanceof Livro){
			file = new File(textos + o.getId() + ".livro");
			jaxbContext = JAXBContext.newInstance(Livro.class);
		}else if(o instanceof Revista){
			file = new File(textos + o.getId() + ".revista");
			jaxbContext = JAXBContext.newInstance(Revista.class);
		}else if(o instanceof ArtigoCongresso){
			file = new File(textos + o.getId() + ".acongresso");
			jaxbContext = JAXBContext.newInstance(ArtigoCongresso.class);
		}else if(o instanceof Tcc){
			file = new File(textos + o.getId() + ".tcc");
			jaxbContext = JAXBContext.newInstance(Tcc.class);
		}else if(o instanceof Usuario){
			file = new File(usuarios + o.getId() + ".usuario");
			jaxbContext = JAXBContext.newInstance(Usuario.class);
		}
		
		 
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(o, file);
	}

	
	/**
	 * Recebe o ID de um Gravavel e retorna o mesmo.
	 * 
	 * @param id String!
	 * @return O Gravavel
	 * @throws JAXBException
	 */
	public static Object fromXML(String id) throws JAXBException {
		File file = null;
		JAXBContext jaxbContext = null;
		
		if(id.contains("liv")){
			file = new File(textos + id + ".livro");
			jaxbContext = JAXBContext.newInstance(Livro.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Livro o = (Livro) jaxbUnmarshaller.unmarshal(file);
			return o;
		}else if(id.contains("rev")){
			file = new File(textos + id + ".revista");
			jaxbContext = JAXBContext.newInstance(Revista.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Revista o = (Revista) jaxbUnmarshaller.unmarshal(file);
			return o;
		}else if(id.contains("acongr")){
			file = new File(textos + id + ".acongresso");
			jaxbContext = JAXBContext.newInstance(ArtigoCongresso.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ArtigoCongresso o = (ArtigoCongresso) jaxbUnmarshaller.unmarshal(file);
			return o;
		}else if(id.contains("tcc")){
			file = new File(textos + id + ".tcc");
			jaxbContext = JAXBContext.newInstance(Tcc.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Tcc o = (Tcc) jaxbUnmarshaller.unmarshal(file);
			return o;
		}else if(id.contains("usuario")){
			file = new File(usuarios + id + ".usuario");
			jaxbContext = JAXBContext.newInstance(Usuario.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Usuario o = (Usuario) jaxbUnmarshaller.unmarshal(file);
			return o;
		}else{
			return null;
		}
		
	}

}

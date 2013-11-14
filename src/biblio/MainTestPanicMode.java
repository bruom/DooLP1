package biblio;

import javax.xml.bind.JAXBException;

import fileReaderWriter.Escrevinhator;

import mainPackage.BibioMain;

public class MainTestPanicMode {
	
	public static void main(String[]args) throws JAXBException{
		BibioMain.escolheTipo();
		Usuario u = (Usuario) Escrevinhator.fromXML("prof-Samuel Oak");
		if(u instanceof Professor)
			System.out.println("Working as intended");
	}

}

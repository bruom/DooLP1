package fileReaderWriter;

import java.io.File;
import java.util.ArrayList;

public class FilesIn {

	private final static String root = "data" + File.separator;
	private final static String textos = root + "textos" + File.separator;
	private final static String usuarios = root + "usuarios" + File.separator;

	public static ArrayList<String> textos() {
		File folder = new File(textos);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {

			lista.add(listOfFiles[i].getName());
			//System.out.println("File " + listOfFiles[i].getName());

		}

		return lista;
	}// textos

	public static ArrayList<String> usuarios() {
		File folder = new File(usuarios);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {

			lista.add(listOfFiles[i].getName());
			//System.out.println("File " + listOfFiles[i].getName());

		}

		return lista;
	}

}

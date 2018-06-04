package com.iesvirgendelcarmen.mvc.proyecto.modelo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class LeerCSV {

	// Propiedades
	private char separador;
	private char comillas;
	
	// Constructor
	
	/**
	 * Inicializa el constructor definiendo el separador de los campos y las comillas usadas
	 * @param separador
	 * @param comillas
	 */
	public LeerCSV(char separador, char comillas) {
		this.separador = separador;
		this.comillas = comillas;
	}
	
	// M�todos
	/**
	 * Lee un CSV que no contiene el mismo caracter que el separador en su texto
	 * y sin comillas que delimiten los campos
	 * @param path Ruta donde est� el archivo
	 * @throws IOException 
	 */
	public void leerCSVSimple(String path) throws IOException {
		
		// Abro el .csv en buffer de lectura
		BufferedReader bufferLectura = new BufferedReader(new FileReader(path));
		
		// Leo una l�nea del archivo
		String linea = bufferLectura.readLine();
		
		while (linea != null) {
			// Separa la l�nea le�da con el separador definido previamente
			String[] campos = linea.split(String.valueOf(this.separador));
			System.out.println(Arrays.toString(campos));
			
			// Vuelvo a leer del fichero
			linea = bufferLectura.readLine();
		}
		
		// CIerro el buffer de lectura
		if (bufferLectura != null) {
			bufferLectura.close();
		}
	}
}
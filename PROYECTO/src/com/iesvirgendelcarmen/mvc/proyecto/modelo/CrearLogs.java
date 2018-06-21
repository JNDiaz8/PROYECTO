package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class CrearLogs {

	private static File file = new File("logs/logProyecto.txt");
	
	public void crearLog(String log, String clavePrimaria){

		try(PrintWriter output = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file,true)));) {
			output.println(LocalDateTime.now()+" | "+ clavePrimaria +" | "+log+"\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
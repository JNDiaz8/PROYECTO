package com.iesvirgendelcarmen.mvc.proyecto.modelo;


import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeerCSV {

	public static List<CocheDTO> insertarCoche() {
		List<CocheDTO> listaCoches = new ArrayList<>();
		try {
			Scanner in = new Scanner(new File("BD/Datos/Coches.csv"));
			String cabecera = in.nextLine();
			while (in.hasNextLine()){
				String[] datos = in.nextLine().split(",");
				CocheDTO coche = new CocheDTO(Integer.parseInt(datos[0].trim()), datos[1].trim(), datos[2].trim(), datos[3].trim());
				listaCoches.add(coche);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		return listaCoches;
}
}
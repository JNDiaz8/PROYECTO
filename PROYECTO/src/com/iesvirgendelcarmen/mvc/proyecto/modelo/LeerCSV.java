package com.iesvirgendelcarmen.mvc.proyecto.modelo;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeerCSV {

private static List<CocheDTO> ListaCoches = new ArrayList<>();
	
	public List<CocheDTO> getListaCochesFromCSV(String csvFilePath) {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
				
				CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreQuotations(true).build();
				
				CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
				String datosS[];
		
				while((datosS=csvReader.readNext())!=null) {
					ListaCoches.add(new CocheDTO(datosS[0], datosS[1] , Integer.parseInt(datosS[2]), datosS[3]));
					
				}
			} catch (IOException | NumberFormatException | ExcepcionCoche e) {
				System.out.println("IO Exception");		
				e.printStackTrace();
				} 
				
			return ListaCoches;
	}
}
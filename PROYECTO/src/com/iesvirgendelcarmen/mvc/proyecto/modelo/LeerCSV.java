package com.iesvirgendelcarmen.mvc.proyecto.modelo;


import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class LeerCSV {

    public static void main(String[] args) {

        String csvFile = "datos/Coches.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Coche [anioCoche= " + line[0] + ", modeloCoche= " + line[1] + " , marcaCoche=" + line[2] + " , vinCoche=" + line[3] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
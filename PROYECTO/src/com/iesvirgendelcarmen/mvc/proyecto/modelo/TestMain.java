package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		CocheDAO manipulacionCoches = new CocheDAOImp();
		List listaCoches = (List) manipulacionCoches.listarTodosCoches();
		System.out.println("Nº de coches: " + listaCoches.size());
		CocheDTO coche = new CocheDTO(2009, "modeloCoche", "marcaCoche", "vinCoche");
		listaCoches.add(coche);
		listaCoches.add(coche);
		listaCoches.add(coche);
		manipulacionCoches.insertarListaCoches(listaCoches);
	}

}

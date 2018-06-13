package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		CocheDAO manipulacionCoches = new CocheDAOImp();
		List listaCoches = (List) manipulacionCoches.listarTodosCoches();
		System.out.println("Nº de coches: " + listaCoches.size());
		CocheDTO coche = new CocheDTO(2008, "modeloCoche", "marcaCoche", "4vinCoche666");
		listaCoches.add(coche);

		manipulacionCoches.insertarCoches(coche);
		manipulacionCoches.borrarCoches("4vinCoche666");
	}

}

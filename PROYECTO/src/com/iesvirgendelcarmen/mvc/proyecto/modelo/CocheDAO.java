package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.util.List;

public interface CocheDAO {
	
	List<CocheDTO> listarTodosCoches();
	boolean borrarCoches(String VIMCoche);
	boolean actualizarCoches(CocheDTO coche, int añoCoche,String modeloCoche, String marcaCoche);
	boolean insertarCoches(CocheDTO coche);
	boolean insertarListaCoches(List<CocheDTO> listaCoches);
	
}
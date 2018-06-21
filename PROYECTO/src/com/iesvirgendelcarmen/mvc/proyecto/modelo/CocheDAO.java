package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.util.List;

public interface CocheDAO {
	
	List<CocheDTO> listarTodosCoches();
	public void completarArrays(List<CocheDTO> lista);
	boolean borrarCoches(CocheDTO coche);
	boolean actualizarCoches(CocheDTO coche);
	boolean insertarCoches(CocheDTO coche);
	boolean insertarListaCoches(List<CocheDTO> listaCoches);
	boolean crearBaseDatos();
	boolean actualizarListaCoches(List<CocheDTO> listaCoches);
	 boolean borrarListaCoches(List<CocheDTO> listaCoches);
	
}
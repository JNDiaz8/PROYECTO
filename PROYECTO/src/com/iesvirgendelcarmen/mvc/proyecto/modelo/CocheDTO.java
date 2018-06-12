package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.awt.event.MouseEvent;

public class CocheDTO {
	private int anioCoche;
	private String modeloCoche;
	private String marcaCoche;
	private String vinCoche;
	
	public CocheDTO(int anioCoche, String modeloCoche, String marcaCoche, String vinCoche) {
		this.anioCoche = anioCoche;
		this.modeloCoche = modeloCoche;
		this.marcaCoche = marcaCoche;
		this.vinCoche = vinCoche;
	}

	public int getAnioCoche() {
		return anioCoche;
	}

	public void setAnioCoche(int anioCoche) {
		this.anioCoche = anioCoche;
	}

	public String getModeloCoche() {
		return modeloCoche;
	}

	public void setModeloCoche(String modeloCoche) {
		this.modeloCoche = modeloCoche;
	}

	public String getMarcaCoche() {
		return marcaCoche;
	}

	public void setMarcaCoche(String marcaCoche) {
		this.marcaCoche = marcaCoche;
	}

	public String getVinCoche() {
		return vinCoche;
	}

	public void setVinCoche(String vinCoche) {
		this.vinCoche = vinCoche;
	}

	@Override
	public String toString() {
		return "CocheDTO [anioCoche=" + anioCoche + ", modeloCoche=" + modeloCoche + ", marcaCoche=" + marcaCoche
				+ ", vinCoche=" + vinCoche + "]";
	}
	
	

	

}

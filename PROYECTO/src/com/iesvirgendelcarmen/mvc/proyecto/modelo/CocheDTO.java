package com.iesvirgendelcarmen.mvc.proyecto.modelo;

public class CocheDTO {
	private int a�oCoche;
	private String modeloCoche;
	private String marcaCoche;
	private String VIMCoche;
	
	public CocheDTO(int a�oCoche, String modeloCoche, String marcaCoche, String vIMCoche) {
		this.a�oCoche = a�oCoche;
		this.modeloCoche = modeloCoche;
		this.marcaCoche = marcaCoche;
		VIMCoche = vIMCoche;
	}

	public int getA�oCoche() {
		return a�oCoche;
	}

	public void setA�oCoche(int a�oCoche) {
		this.a�oCoche = a�oCoche;
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

	public String getVIMCoche() {
		return VIMCoche;
	}

	public void setVIMCoche(String vIMCoche) {
		VIMCoche = vIMCoche;
	}

	@Override
	public String toString() {
		return "CocheDTO [a�oCoche=" + a�oCoche + ", modeloCoche=" + modeloCoche + ", marcaCoche=" + marcaCoche
				+ ", VIMCoche=" + VIMCoche + "]";
	}
	
	
	
	
	
	
	

}

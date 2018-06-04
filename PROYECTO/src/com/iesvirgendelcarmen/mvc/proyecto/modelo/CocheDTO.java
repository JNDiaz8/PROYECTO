package com.iesvirgendelcarmen.mvc.proyecto.modelo;

public class CocheDTO {
	private int añoCoche;
	private String modeloCoche;
	private String marcaCoche;
	private String VIMCoche;
	
	public CocheDTO(int añoCoche, String modeloCoche, String marcaCoche, String vIMCoche) {
		this.añoCoche = añoCoche;
		this.modeloCoche = modeloCoche;
		this.marcaCoche = marcaCoche;
		VIMCoche = vIMCoche;
	}

	public int getAñoCoche() {
		return añoCoche;
	}

	public void setAñoCoche(int añoCoche) {
		this.añoCoche = añoCoche;
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
		return "CocheDTO [añoCoche=" + añoCoche + ", modeloCoche=" + modeloCoche + ", marcaCoche=" + marcaCoche
				+ ", VIMCoche=" + VIMCoche + "]";
	}
	
	
	
	
	
	
	

}

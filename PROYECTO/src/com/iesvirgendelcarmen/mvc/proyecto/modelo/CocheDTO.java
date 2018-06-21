package com.iesvirgendelcarmen.mvc.proyecto.modelo;


public class CocheDTO {
	private String modeloCoche;
	private String marcaCoche;
	private int anioCoche;
	private String vinCoche;
	
	public CocheDTO(String modeloCoche, String marcaCoche, int anioCoche, String vinCoche) throws ExcepcionCoche {
		if (vinCoche.matches("[0-9A-Z]+")) {

			this.modeloCoche = modeloCoche;
			this.marcaCoche = marcaCoche;
			this.anioCoche = anioCoche;
			this.vinCoche = vinCoche;
		}else 
			throw new ExcepcionCoche("VIN incorrecto");
		
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

	public int getAnioCoche() {
		return anioCoche;
	}

	public void setAnioCoche(int anioCoche) {
		this.anioCoche = anioCoche;
	}

	public String getVinCoche() {
		return vinCoche;
	}

	public void setVinCoche(String vinCoche) {
		this.vinCoche = vinCoche;
	}

	@Override
	public String toString() {
		return "CocheDTO [modeloCoche=" + modeloCoche + ", marcaCoche=" + marcaCoche + ", anioCoche=" + anioCoche
				+ ", vinCoche=" + vinCoche + "]";
	}
	
	
	
	
	

	

}

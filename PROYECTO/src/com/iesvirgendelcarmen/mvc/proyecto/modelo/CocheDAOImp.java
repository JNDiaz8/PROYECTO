package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CocheDAOImp implements CocheDAO {
	Connection conexion = ConexionPF.getConexion();
	private String[] cabeceras = {"Marca", "Modelo", "Año", "VIN"};
	private Object[][] datos;
	private CrearLogs log = new CrearLogs();


	public boolean crearBaseDatos() {
		String sql = "DROP TABLE IF EXISTS coches;"
				+ "CREATE TABLE coches ("
				+ "marcaCoche TEXT,"
				+ "modeloCoche TEXT,"
				+ "anioCoche INTEGER,"
				+ "vinCoche TEXT PRIMARY KEY"
				+ ");";

		try {
			Statement st = conexion.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e1) {
			log.crearLog("Error al crear la base de datos",null);
			return false;
		}
	}

	public void completarArrays(List<CocheDTO> lista) {
		datos = new Object[lista.size()][4];
		int contador = 0;

		for (CocheDTO coche : listarTodosCoches()) {
			datos[contador][0] = coche.getMarcaCoche();
			datos[contador][1] = coche.getModeloCoche();
			datos[contador][2] = coche.getAnioCoche();
			datos[contador][3] = coche.getVinCoche();
			contador++;
		}
	}
	@Override
	public List<CocheDTO> listarTodosCoches() {
		List<CocheDTO> listaCoches = new ArrayList<>();
		String sql = "SELECT * FROM coches;";
		CocheDTO coche;

		try (PreparedStatement statement = conexion.prepareStatement(sql);){
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				coche = new CocheDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
				listaCoches.add(coche);
			}
		} catch (SQLException | ExcepcionCoche e) {
			log.crearLog("Error al listar los datos",null);

		}	
		return listaCoches;
	}

	@Override
	public boolean borrarCoches(CocheDTO coche){
		String sql = "DELETE FROM coches WHERE vinCoche = ?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setString(1,coche.getVinCoche());
			return !preparedStatement.execute();
		} catch (SQLException e) {
			log.crearLog("Error al borrar los datos",coche.getVinCoche());
			return false;
		}
	}

	@Override
	public boolean actualizarCoches(CocheDTO coche) {
		String sql = "UPDATE coches set marcaCoche=?, modeloCoche=?, anioCoche=? WHERE vinCoche = ? ;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setString(1, coche.getMarcaCoche());
			preparedStatement.setString(2, coche.getModeloCoche());
			preparedStatement.setInt(3, coche.getAnioCoche());
			preparedStatement.setString(4, coche.getVinCoche());
			return preparedStatement.execute();
		} catch (SQLException e) {
			log.crearLog("Error al actualizar los datos",coche.getVinCoche());
			return false;
		}
	}

	@Override
	public boolean insertarCoches(CocheDTO coche) {
		String sql = "INSERT into coches (marcaCoche, modeloCoche, anioCoche, vinCoche) VALUES(?,?,?,?)";
		try (PreparedStatement statement = conexion.prepareStatement(sql);){
			statement.setString(1, coche.getMarcaCoche());
			statement.setString(2, coche.getModeloCoche());
			statement.setInt(3, coche.getAnioCoche());
			statement.setString(4, coche.getVinCoche());
			return statement.execute();
		} catch (SQLException e) {
			log.crearLog("Error al insertar los datos",coche.getVinCoche());

		}
		return false;
	}

	@Override
	public boolean insertarListaCoches(List<CocheDTO> listaCoches) {
		try {
			conexion.setAutoCommit(true);
			for (CocheDTO cocheDTO : listaCoches) {
				insertarCoches(cocheDTO);
			}
			System.out.println("Insertando datos de lista correctamente ");
			return true;
		} catch (SQLException e) {
			try {
				conexion.rollback();
				return false;
			} catch (SQLException e1) {
				return false;
			} 
		}
	}
	@Override
	public boolean actualizarListaCoches(List<CocheDTO> listaCoches) {
		try {
			conexion.setAutoCommit(true);
			for (CocheDTO cocheDTO : listaCoches) {
				actualizarCoches(cocheDTO);
			}
			return true;
		} catch (SQLException e) {
			try {
				conexion.rollback();
				return false;
			} catch (SQLException e1) {
				return false;
			} 
		}
	}
	@Override
	public boolean borrarListaCoches(List<CocheDTO> listaCoches) {
		try {
			conexion.setAutoCommit(true);
			for (CocheDTO cocheDTO : listaCoches) {
				borrarCoches(cocheDTO);
			}
			return true;
		} catch (SQLException e) {
			try {
				conexion.rollback();
				return false;
			} catch (SQLException e1) {
				return false;
			} 
		}
	}


	public String[] getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(String[] cabeceras) {
		this.cabeceras = cabeceras;
	}

	public Object[][] getDatos() {
		return datos;
	}

	public void setDatos(Object[][] datos) {
		this.datos = datos;
	}



}

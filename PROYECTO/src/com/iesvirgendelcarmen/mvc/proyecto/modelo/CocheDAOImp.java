package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CocheDAOImp implements CocheDAO {
	private static Connection conexion = ConexionPF.getConexion();
	private String[] cabeceras = {"Marca", "Modelo", "Año", "VIN"};
	private Object[][] datos;
	
	
	public String[] getCabeceras() {
		return cabeceras;
	}

	public Object[][] getDatos() {
		return datos;
	}

	public void completarArrays(List<CocheDTO> lista) {
		datos = new Object[lista.size()][5];
		int contador = 0;
		
		for (CocheDTO coche : listarTodosCoches()) {
			datos[contador][0] = coche.getMarcaCoche();
			datos[contador][1] = coche.getModeloCoche();
			datos[contador][2] = coche.getAnioCoche();
			datos[contador][3] = coche.getVinCoche();
			contador++;
		}
}

	public List<CocheDTO> listarTodosCoches() {
		List<CocheDTO> listaCoches = new ArrayList<>();
		String sql = "SELECT * FROM coches;";
		try (Statement statement = conexion.createStatement();){
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {	
				listaCoches.add(new CocheDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCoches;
	}

	@Override
	public boolean borrarCoches(String vinCoche) {
		int borrados = 0;
		String sql = "DELETE FROM coches WHERE vinCoche = ?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setString(1,vinCoche);
			borrados = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrados != 0;
	}

	@Override
	public boolean actualizarCoches(CocheDTO coche) {
		String sql = "UPDATE FROM coches set coche=? WHERE vinCoche = ? ;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setString(1, coche.getMarcaCoche());
			preparedStatement.setString(2, coche.getModeloCoche());
			preparedStatement.setInt(3, coche.getAnioCoche());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertarCoches(CocheDTO coche) {
		String sql = "INSERT into coches (marcaCoche, modeloCoche, anioCoche, vinCoche) VALUES(?,?,?,?)";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setString(1, coche.getMarcaCoche());
			preparedStatement.setString(2, coche.getModeloCoche());
			preparedStatement.setInt(3, coche.getAnioCoche());
			preparedStatement.setString(4, coche.getVinCoche());
			return preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean insertarListaCoches(List<CocheDTO> listaCoches) {
		try {
			conexion.setAutoCommit(false);
			for (CocheDTO cocheDTO : listaCoches) {
				insertarCoches(cocheDTO);
			}
			conexion.commit();
			System.out.println("Insertando datos de lista correctamente ");
			conexion.setAutoCommit(true);
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
			return false;
			}
		}
		


}

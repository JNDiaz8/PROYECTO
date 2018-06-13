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

	public List<CocheDTO> listarTodosCoches() {
		List<CocheDTO> listaCoches = new ArrayList<>();
		String sql = "SELECT * FROM coches;";
		try (Statement statement = conexion.createStatement();){
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				CocheDTO coche = new CocheDTO(resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4));
				listaCoches.add(coche);
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
	public boolean actualizarCoches(CocheDTO coche, int anioCoche, String modeloCoche, String marcaCoche) {
		int updates = 0;
		String sql = "UPDATE FROM coches WHERE anioCoche = ? AND modeloCoche = ? AND marcaCoche = ?;";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setInt(1, coche.getAnioCoche());
			preparedStatement.setString(2, coche.getModeloCoche());
			preparedStatement.setString(3, coche.getMarcaCoche());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertarCoches(CocheDTO coche) {
		String sql = "INSERT into coches (anioCoche, modeloCoche, marcaCoche, vinCoche) VALUES(?,?,?,?)";
		try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);){
			preparedStatement.setInt(1, coche.getAnioCoche());
			preparedStatement.setString(2, coche.getModeloCoche());
			preparedStatement.setString(3, coche.getMarcaCoche());
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
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				System.out.println("No se puede insertar datos de lista");
				try {
					conexion.setAutoCommit(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return false;
				}
			}
		}

	public boolean crearBaseDatos() {
		String sql = "DROP TABLE IF EXISTS coches;"
				+ "CREATE TABLE coches ("
				+ "vinCoche TEXT PRIMARY KEY,"
		        + "Marca TEXT,"
		        + "Modelo TEXT,"
		        + "Anio INTEGER,"
		        + ");";
		
		try {
			Statement st = conexion.createStatement();
			st.executeUpdate(sql);
			return true;
		} catch (SQLException e1) {
			return false;
		}
}
		


	public void completarArrays(List<CocheDTO> listaCochesEstatica) {
		// TODO Auto-generated method stub
		
	}

	

	

}

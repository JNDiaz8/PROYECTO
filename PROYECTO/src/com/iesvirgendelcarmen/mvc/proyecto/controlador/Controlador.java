package com.iesvirgendelcarmen.mvc.proyecto.controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDAOImp;
import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDTO;
import com.iesvirgendelcarmen.mvc.proyecto.modelo.ExcepcionCoche;
import com.iesvirgendelcarmen.mvc.proyecto.modelo.LeerCSV;
import com.iesvirgendelcarmen.mvc.proyecto.vista.Vista;



public class Controlador implements ActionListener {
	
	Dimension dimension;
	String path=".";
	
	static List<CocheDTO> listaCochesEstatica;
	LeerCSV reader = new LeerCSV();
	CocheDAOImp manipular = new CocheDAOImp();
	
	private List<CocheDTO> listaCoches;
	private Vista vista;
	
	JScrollPane scrollPane; 

	public Controlador(Vista vista) {
		this.vista = vista;
		registrarComponentes();
	}

	private void registrarComponentes() {
		//registramos los menus
		vista.getMenuItemAcercaDe().addActionListener(this);
		vista.getMenuItemCargar().addActionListener(this);
		vista.getMenuItemSalir().addActionListener(this);
		//registramos los botones
		vista.getBtnAñadir().addActionListener(this);
		vista.getBtnBorrar().addActionListener(this);
		vista.getBtnActualizar().addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//agrupamos jmenuitem
		if (e.getSource().getClass() == JMenuItem.class) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			if (menuItem.getText().equals("Salir"))
				salirAplicacion();
			else if (menuItem.getText().equals("Acerca de"))
				desplegarInformacion();
			else
				lanzarEleccionFichero();
				actualizarDatosEnTabla();
			}

		//agruparemos jbutton
		if (e.getSource().getClass() == JButton.class) {
			JButton jButton = (JButton) e.getSource();
			String textoBoton = jButton.getText();


			switch (textoBoton) {
		    case "Añadir":
		    	lanzarInputRecogerDatos();
				break;
			case "Actualizar":
				actualizarFilas();
				break;
			case "Borrar":
				borrarFilas();
				break;
				
				}
			}
	}


	private void lanzarInputRecogerDatos() {
		Object[] textFields = {
				"Marca Coche", vista.getTextAnadirMarcaCoche(),
				"Modelo Coche", vista.getTextAnadirModeloCoche(),
				"Año Coche", vista.getTextAnadirAnioCoche(),
				"VIN Coche", vista.getTextAnadirvinCoche(),

		};
		
		int resultado = JOptionPane.showConfirmDialog(null, textFields, "Añadir datos", JOptionPane.OK_CANCEL_OPTION);
		CocheDTO coche;
		try {
			coche = new CocheDTO(vista.getTextAnadirMarcaCoche().getText(), vista.getTextAnadirModeloCoche().getText(), 
					Integer.parseInt(vista.getTextAnadirAnioCoche().getText()), vista.getTextAnadirvinCoche().getText());
			if(resultado==JOptionPane.OK_OPTION) {
				manipular.insertarCoches(coche);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionCoche e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			actualizarDatosEnTabla();
		
	}

	





	private void lanzarEleccionFichero() {
		JFileChooser fileChooser = new JFileChooser(path);
		int resultado = fileChooser.showOpenDialog(vista.getFrame());
		if(resultado==JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getPath();
			if(listaCoches==null) {
				listaCochesEstatica = reader.getListaCochesFromCSV(path);
				listaCoches = listaCochesEstatica;
				
				if(manipular.listarTodosCoches().size()<=0 ) {
					manipular.crearBaseDatos();
					manipular.insertarListaCoches(listaCoches);
					manipular.completarArrays(listaCoches);
					}
				}
			}
		}

 
	private void desplegarInformacion() {
		JOptionPane.showMessageDialog(vista.getFrame(), 
				"Creado por Joaquín Díaz Ramírez", "Proyecto Final Programacion",
				JOptionPane.INFORMATION_MESSAGE);
		
	}


	private void salirAplicacion() {
		System.exit(0);
		
	}
	
	private void actualizarFilas(){
	    List<CocheDTO> listaCochesSe = new ArrayList<>();
	    String Marca;
	    String Modelo;
		int Anio;
		String vin;
	    if (vista.getTable().getRowCount() > 0) {
	        if (vista.getTable().getSelectedRowCount() > 0) {
	            int selectedRow[] = vista.getTable().getSelectedRows();
	            for (int i : selectedRow) {
	            	Marca = vista.getTable().getValueAt(i, 0).toString();
	        		Modelo= vista.getTable().getValueAt(i, 1).toString();
	        		Anio = Integer.parseInt(vista.getTable().getValueAt(i, 2).toString());
	        		vin = vista.getTable().getValueAt(i, 3).toString();
	        		CocheDTO coche;
					try {
						coche = new CocheDTO(Marca, Modelo, Anio, vin);
						listaCochesSe.add(coche);
					} catch (ExcepcionCoche e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		
	            }
	           
	            manipular.actualizarListaCoches(listaCochesSe);
	            }
	        }
	    }
	
	private void actualizarDatosEnTabla() {
		List<CocheDTO> lista = manipular.listarTodosCoches();
		manipular.completarArrays(lista);
		DefaultTableModel model = new DefaultTableModel(manipular.getDatos(), manipular.getCabeceras()){
			private static final long serialVersionUID = 1L;
			@Override 
		    public boolean isCellEditable(int row, int column){
		    	return column!=3;
		    }
		};
		dimension = vista.getTable().getPreferredSize();
		vista.getTable().setModel(model);
	}
	
	private void borrarFilas()  {
	    List<CocheDTO> listaCochesSeleccionados = new ArrayList<>();
	    String marcaCoche;
	    String modeloCoche;
		int anioCoche;
		String vinCoche;

	    if (vista.getTable().getRowCount() > 0) {
	        if (vista.getTable().getSelectedRowCount() > 0) {
	            int selectedRow[] = vista.getTable().getSelectedRows();
	            for (int i : selectedRow) {
	            	marcaCoche =vista.getTable().getValueAt(i, 0).toString();
	        		modeloCoche = vista.getTable().getValueAt(i, 1).toString();
	        		anioCoche = Integer.parseInt(vista.getTable().getValueAt(i, 2).toString());
	        		vinCoche = vista.getTable().getValueAt(i, 3).toString();

	        		CocheDTO coche;
					try {
						coche = new CocheDTO(marcaCoche, modeloCoche, anioCoche, vinCoche);
						listaCochesSeleccionados.add(coche);
					} catch (ExcepcionCoche e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	            manipular.borrarListaCoches(listaCochesSeleccionados);
	            actualizarDatosEnTabla();
	            }
	        }
	    }
}
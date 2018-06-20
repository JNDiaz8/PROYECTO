package com.iesvirgendelcarmen.mvc.proyecto.controlador;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDAOImp;
import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDTO;
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
	private int posicion=0;

	private int filas = 22;
	
	int alto;

	
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
		vista.getBtnMas().addActionListener(this);
		vista.getBtnMenos().addActionListener(this);
		vista.getBtnAñadir().addActionListener(this);
		vista.getBtnBorrar().addActionListener(this);
		vista.getBtnActualizar().addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//agrupamos jmenuitem
		if (e.getSource().getClass() == JMenuItem.class) {
			JMenuItem menuItem = (JMenuItem) e.getSource();
			String menuString = menuItem.getText();
			if (menuItem.getText().equals("Salir"))
				salirAplicacion();
			else if (menuItem.getText().equals("Acerca de"))
				desplegarInformacion();
			else
				lanzarEleccionFichero();
			}

		//agruparemos jbutton
		if (e.getSource().getClass() == JButton.class) {
			JButton jButton = (JButton) e.getSource();
			String textoBoton = jButton.getText();
			System.out.println(textoBoton);
			int contador = 0;
			switch (textoBoton) {
			case ">":
				contador += 10;
				break;
			case "<":
				contador -= 10;
				break;
		  /*case "Añadir":
				try {
					lanzarInputRecogerDatos();
					vista.getMenuItemGuardar().setEnabled(true);
				} catch (Exception e1) {
					dialogo("Error añadiendo datos");
				}
				break;
				*/
			/*case "Actualizar":
				try {
					dialogo("Actualizados "+vista.getTable().getSelectedRowCount()+" elementos.");
					actualizarFilas();
					vista.getMenuItemGuardar().setEnabled(true);
					} catch (Exception e1) {
					dialogo("Error actualizando datos");
					}
				break;
				*/
			/*case "Borrar":
				
				break;
				*/
				}
			}
	}


	/*private void lanzarInputRecogerDatos() {
		Object[] textFields = {
				"Marca Coche", vista.getTextAnadirMarcaCoche(),
				"Modelo Coche", vista.getTextAnadirModeloCoche(),
				"Año Coche", vista.getTextAnadirAnioCoche(),
				"VIN Coche", vista.getTextAnadirvinCoche(),

		};
		
		int resultado = JOptionPane.showConfirmDialog(null, textFields, "Añadir datos", JOptionPane.OK_CANCEL_OPTION);
		CocheDTO coche = new CocheDTO(vista.getTextAnadirMarcaCoche().getText(), vista.getTextAnadirModeloCoche().getText(), 
				vista.getTextAnadirAnioCoche().getInt(), vista.getTextAnadirvinCoche().getText());
		if(resultado==JOptionPane.OK_OPTION) {
			manipular.insertarCoche(coche);
			dialogo("COCHE INSERTADO "+"\nMarca: "+coche.getMarca()+
								"\nColor: "+coche.getColor()+
								"\nModelo: "+coche.getModelo()+
								"\nOrigen: "+coche.getOrigen());
			actualizarDatosEnTabla();
		}
	}
*/
	





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
		JOptionPane jpJOptionPane = new JOptionPane();
		jpJOptionPane.showMessageDialog(vista.getFrame(), 
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
	        		CocheDTO coche = new CocheDTO(Marca, Modelo, Anio, vin);
	        		listaCochesSe.add(coche);
	            }
	            manipular.insertarListaCoches(listaCochesSe);
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
		    	return column!=0;
		    }
		};
		dimension = vista.getTable().getPreferredSize();
		vista.getTable().setModel(model);
		Component scrollPane = null;
		scrollPane.setPreferredSize(new Dimension(dimension.width, vista.getTable().getRowHeight()*filas ));
	}
	
	/*private void borrarFilas()  {
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
	        		anioCoche = vista.getTable().getValueAt(i, 2).toString();
	        		vinCoche = vista.getTable().getValueAt(i, 3).toString();

	        		CocheDTO coche = new CocheDTO(marcaCoche, modeloCoche, anioCoche, vinCoche);
					listaCochesSeleccionados.add(coche);
	            }
	            manipular.borrarListaCoches(listaCochesSeleccionados);
	            actualizarDatosEnTabla();
	            }
	        }
	    }
	    */
}
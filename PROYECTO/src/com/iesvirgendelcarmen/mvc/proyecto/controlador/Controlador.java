package com.iesvirgendelcarmen.mvc.proyecto.controlador;

import java.awt.Component;
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

import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDAOImp;
import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDTO;
import com.iesvirgendelcarmen.mvc.proyecto.modelo.LeerCSV;
import com.iesvirgendelcarmen.mvc.proyecto.vista.Vista;



public class Controlador implements ActionListener {
	
	String path=".";
	
	static List<CocheDTO> listaCochesEstatica;
	
	private Vista vista;
	private List<CocheDTO> listaCoches;
	
	LeerCSV reader = new LeerCSV();
	CocheDAOImp manipular = new CocheDAOImp();
	
	
	public Controlador(Vista vista) {
		this.vista = vista;
		
		
		registrarComponentes();
	}





	private void registrarComponentes() {
		//registramos item de menÃº
		vista.getMenuItemAcercaDe().addActionListener(this);
		vista.getMenuItemCargar().addActionListener(this);
		vista.getMenuItemSalir().addActionListener(this);
		//registramos botones
		vista.getBtnMas().addActionListener(this);
		vista.getBtnMenos().addActionListener(this);
		vista.getBtnBorrar().addActionListener(this);
		vista.getBtnLeer().addActionListener(this);
		vista.getBtnActualizar().addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//agrupamos jmenuitem
		if (e.getSource().getClass() == JMenuItem.class) {
			//System.out.println("pulsado un menÃº item");
			JMenuItem menuItem = (JMenuItem) e.getSource();
			//identificamos el jmenuitem que genera el evento
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
			case "Añadir":
				break;
			case "Actualizar":
				break;
			case "Borrar":
				break;
				}
			}

	}


	

	private void lanzarEleccionFichero() {
		JFileChooser fileChooser = new JFileChooser("./ficherosCSV");
		int resultado = fileChooser.showOpenDialog(vista.getFrame());
		if(resultado==JFileChooser.APPROVE_OPTION) {
			path = fileChooser.getSelectedFile().getPath();
			if(listaCoches==null) {
				listaCochesEstatica = reader.getCarListFromCSV(path);
				listaCoches = listaCochesEstatica;
				
				if(manipular.listarTodosCoches().size()<=0 ) {
					manipular.crearBaseDatos();
					manipular.insertarListaCoches(listaCochesEstatica);
					manipular.completarArrays(listaCochesEstatica);
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

}
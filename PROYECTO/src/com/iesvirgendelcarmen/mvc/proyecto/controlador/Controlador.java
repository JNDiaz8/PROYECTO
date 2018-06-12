package com.iesvirgendelcarmen.mvc.proyecto.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDAOImp;
import com.iesvirgendelcarmen.mvc.proyecto.modelo.CocheDTO;
import com.iesvirgendelcarmen.mvc.proyecto.vista.Vista;



public class Controlador implements ActionListener {
	
	private Vista vista;

	
	public Controlador(Vista vista) {
		this.vista = vista;
		
		registrarComponentes();
	}


	private void colocarFormularioCoche(int i, List<CocheDTO> lista) {
		vista.getTextFieldMarca().setText(
				lista.get(i).getMarcaCoche());
		vista.getTextFieldModelo().setText(
				lista.get(i).getModeloCoche());
		vista.getTextFieldvin().setText(
				lista.get(i).getVinCoche());
	
	}


	private void registrarComponentes() {
		//registramos item de menÃº
		vista.getMenuItemAcercaDe().addActionListener(this);
		vista.getMenuItemCargar().addActionListener(this);
		vista.getMenuItemSalir().addActionListener(this);
		//registramos botones
		vista.getBotonMas().addActionListener(this);
		vista.getBotonMenos().addActionListener(this);
		vista.getBotonSalir().addActionListener(this);
		vista.getBotonBuscar().addActionListener(this);

		
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
				System.out.println("pulsado " + textoBoton);
				contador += 10;
			//	colocarFormularioCoche(contador);
				break;
			case "<":
				System.out.println("pulsado " + textoBoton);
				contador -= 10;
			//	colocarFormularioCoche(contador);
				break;
			case "Salir":
				salirAplicacion();
			case "Filtrar":
				}
			}

	}


	

	private void lanzarEleccionFichero() {
		// TODO Auto-generated method stub
		
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
package com.iesvirgendelcarmen.mvc.proyecto.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;

public class Vista {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	private JMenuItem menuItemCargar;
	private JMenuItem menuItemSalir;
	private JMenuItem menuItemAcercaDe;
	private JTabbedPane tabbedPane_1;
	private JSplitPane splitPane;
	private JTabbedPane tabbedPane;
	private JSplitPane splitPane_1;
	private JPanel panel;
	private JTextField textFieldAnio;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldvin;
	private JPanel panel_1;
	
	private JButton botonMenos;
	private JButton botonMas;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblNewLabel;
	private JComboBox comboBoxMarca;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxModelo;
	private JButton botonBuscar;
	private JButton botonSalir;
	private JButton botonReset;
	private ButtonGroup bgGroup;
	private JLabel lblAo;
	private JComboBox comboBoxAnio;
	private JScrollPane scrollPane;
	private ScrollPane scrollPane_1;

	//private JTable table;
	
	public JButton getBotonMenos() {
		return botonMenos;
	}

	public JButton getBotonMas() {
		return botonMas;
	}

	
	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}

	public JButton getBotonReset() {
		return botonReset;
	}

	public JTextField getTextFieldAnio() {
		return textFieldAnio;
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarca;
	}

	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}

	public JTextField getTextFieldvin() {
		return textFieldvin;
	}

	public JComboBox getComboBoxLenguaje() {
		return comboBoxMarca;
	}

	public JComboBox getComboBoxRaza() {
		return comboBoxModelo;
	}

	/*public void setTable(JTable table) {
		this.table = table;
	}*/

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public JMenuItem getMenuItemCargar() {
		return menuItemCargar;
	}

	public JMenuItem getMenuItemSalir() {
		return menuItemSalir;
	}

	public JMenuItem getMenuItemAcercaDe() {
		return menuItemAcercaDe;
	}

	public ButtonGroup getBgGroup() {
		return bgGroup;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * Create the application.
	 */
	public Vista() {
	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnDatos = new JMenu("Datos");
		menuBar.add(mnDatos);
		
		menuItemCargar = new JMenuItem("Cargar datos");
		mnDatos.add(menuItemCargar);
		
		menuItemSalir = new JMenuItem("Salir");
		mnDatos.add(menuItemSalir);
		
		JMenu mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);
		
		menuItemAcercaDe = new JMenuItem("Acerca de");
		mnAcercaDe.add(menuItemAcercaDe);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.25);
		tabbedPane.addTab("Filtros", null, splitPane_1, null);
		
		panel = new JPanel();
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel labelAnio = new JLabel("Año");
		panel.add(labelAnio);
		
		textFieldAnio = new JTextField();
		panel.add(textFieldAnio);
		textFieldAnio.setColumns(10);
		
		JLabel labelMarca = new JLabel("Marca");
		panel.add(labelMarca);
		
		textFieldMarca = new JTextField();
		panel.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		
		JLabel labelModelo = new JLabel("Modelo");
		panel.add(labelModelo);

		
		textFieldModelo = new JTextField();
		panel.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		
		JLabel labelvin = new JLabel("VIN");
		panel.add(labelvin);
		
		textFieldvin = new JTextField();
		panel.add(textFieldvin);
		textFieldvin.setColumns(10);
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		
		botonMenos = new JButton("<");
		panel_1.add(botonMenos);
		
		botonMas = new JButton(">");
		botonMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(botonMas);
		
		panel_2 = new JPanel();
		splitPane_1.setLeftComponent(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		lblAo = new JLabel("Año");
		panel_3.add(lblAo);
		
		comboBoxAnio = new JComboBox();
		panel_3.add(comboBoxAnio);
		
		bgGroup = new ButtonGroup();
		
		panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		lblNewLabel = new JLabel("Marca");
		panel_4.add(lblNewLabel);
		
	//	String[] items = {"item1", "item2", "item3","item4", "item5" };
		comboBoxMarca = new JComboBox();
		panel_4.add(comboBoxMarca);
		
		panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		lblNewLabel_1 = new JLabel("Modelo");
		panel_5.add(lblNewLabel_1);
		
		comboBoxModelo = new JComboBox();
		panel_5.add(comboBoxModelo);

		
		panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		botonBuscar = new JButton("Filtrar");
		panel_6.add(botonBuscar);
		
		botonReset = new JButton("Reset");
		panel_6.add(botonReset);
		
		botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_6.add(botonSalir);
		
		scrollPane_1 = new ScrollPane();
		tabbedPane.addTab("Tabla", null, scrollPane_1, null);
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
	
		
		
	}

	public Object getComboBoxMarca() {
		// TODO Auto-generated method stub
		return null;
	}

	

}


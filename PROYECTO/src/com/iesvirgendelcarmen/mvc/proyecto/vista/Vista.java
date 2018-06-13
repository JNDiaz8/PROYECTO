package com.iesvirgendelcarmen.mvc.proyecto.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Component;

public class Vista {

	private JFrame frame;
	private JTable table;
	private JMenuItem menuItemCargar;
	private JMenuItem menuItemSalir;
	private JMenuItem menuItemAcercaDe;
	private JButton btnMenos;
	private JButton btnMas;
	private JButton btnAñadir;
	private JButton btnActualizar;
	private JButton btnBorrar;

	public JButton getBtnMenos() {
		return btnMenos;
	}

	public void setBtnMenos(JButton btnMenos) {
		this.btnMenos = btnMenos;
	}

	public JButton getBtnMas() {
		return btnMas;
	}

	public void setBtnMas(JButton btnMas) {
		this.btnMas = btnMas;
	}

	public JButton getBtnLeer() {
		return btnAñadir;
	}

	public void setBtnLeer(JButton btnLeer) {
		this.btnAñadir = btnLeer;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}
	*/
	public JMenuItem getMenuItemCargar() {
		return menuItemCargar;
	}

	public JMenuItem getMenuItemSalir() {
		return menuItemSalir;
	}

	public JMenuItem getMenuItemAcercaDe() {
		return menuItemAcercaDe;
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
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnActualizar = new JButton("Actualizar");
			
		btnAñadir = new JButton("Añadir");
		
		
		btnBorrar = new JButton("Borrar");
		
		
		btnMenos = new JButton("<");

		
		btnMas = new JButton(">");
		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnMenos)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMas)
							.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
							.addComponent(btnAñadir)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(8)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMas)
						.addComponent(btnMenos)
						.addComponent(btnAñadir, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Marca", "Modelo", "Anio", "VIN"
			}
		));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}

	public AbstractButton getBotonMas() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public AbstractButton getBotonMenos() {
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractButton getBotonSalir() {
		// TODO Auto-generated method stub
		return null;
	}

	public Component getFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTable() {
		// TODO Auto-generated method stub
		return null;
	}
}

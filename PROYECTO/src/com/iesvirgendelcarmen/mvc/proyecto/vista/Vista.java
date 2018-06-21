package com.iesvirgendelcarmen.mvc.proyecto.vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Vista {

	private JFrame frame;
	private JTable table;
	private JMenuItem menuItemCargar;
	private JMenuItem menuItemSalir;
	private JMenuItem menuItemAcercaDe;
	private JButton btnAñadir;
	private JButton btnActualizar;
	private JButton btnBorrar;
	private Object tabbedPane;
	private JScrollPane scrollPaneTablas;
	
	private JTextField textAnadirMarcaCoche = new JTextField();
	private JTextField textAnadirModeloCoche = new JTextField();
	private JTextField textAnadirAnioCoche = new JTextField();
	private JTextField textAnadirvinCoche = new JTextField();
	



	public JTextField getTextAnadirMarcaCoche() {
		return textAnadirMarcaCoche;
	}

	public void setTextAnadirMarcaCoche(JTextField textAnadirMarcaCoche) {
		this.textAnadirMarcaCoche = textAnadirMarcaCoche;
	}

	public JTextField getTextAnadirModeloCoche() {
		return textAnadirModeloCoche;
	}

	public void setTextAnadirModeloCoche(JTextField textAnadirModeloCoche) {
		this.textAnadirModeloCoche = textAnadirModeloCoche;
	}

	public JTextField getTextAnadirAnioCoche() {
		return textAnadirAnioCoche;
	}

	public void setTextAnadirAnioCoche(JTextField textAnadirAnioCoche) {
		this.textAnadirAnioCoche = textAnadirAnioCoche;
	}

	public JTextField getTextAnadirvinCoche() {
		return textAnadirvinCoche;
	}

	public void setTextAnadirvinCoche(JTextField textAnadirvinCoche) {
		this.textAnadirvinCoche = textAnadirvinCoche;
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
		
		JPanel panelTablas = new JPanel();
		panelTablas.setBorder(new LineBorder(Color.GRAY, 3));
		panelTablas.setLayout(new BorderLayout(0, 0));
		
		scrollPaneTablas = new JScrollPane(table);
        scrollPaneTablas.setEnabled(false);
		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(btnAñadir)
							.addGap(10)
							.addComponent(btnActualizar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAñadir, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnActualizar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnBorrar, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		table = new JTable();
		
			

		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JTable getTable() {
		return table;
	}

	public JFrame getFrame() {
		return frame;
	}

	public Object getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(Object tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	public JScrollPane getScrollPaneTablas() {
		return scrollPaneTablas;
	}

	public void setScrollPaneTablas(JScrollPane scrollPaneTablas) {
		this.scrollPaneTablas = scrollPaneTablas;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setMenuItemCargar(JMenuItem menuItemCargar) {
		this.menuItemCargar = menuItemCargar;
	}

	public void setMenuItemSalir(JMenuItem menuItemSalir) {
		this.menuItemSalir = menuItemSalir;
	}

	public void setMenuItemAcercaDe(JMenuItem menuItemAcercaDe) {
		this.menuItemAcercaDe = menuItemAcercaDe;
	}

	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}

	public JButton getBtnAñadir() {
		return btnAñadir;
	}



	
	
	
}
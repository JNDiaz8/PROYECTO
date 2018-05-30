package com.iesvirgendelcarmen.mvc.proyecto;

import java.awt.EventQueue;

public class Principal {
	public static void  main (String [] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Vista window = new Vista();
				new Controlador(window);
				
			}
		});		
	}
}

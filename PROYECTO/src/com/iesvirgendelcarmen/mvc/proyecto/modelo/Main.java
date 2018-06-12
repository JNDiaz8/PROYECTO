package com.iesvirgendelcarmen.mvc.proyecto.modelo;

import java.awt.EventQueue;

import com.iesvirgendelcarmen.mvc.proyecto.controlador.Controlador;
import com.iesvirgendelcarmen.mvc.proyecto.vista.Vista;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					new Controlador(window);
					} catch (Exception e) {
						e.printStackTrace();
						}
				}
			});
		}
	}


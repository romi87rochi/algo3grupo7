package algo3.grupo7.algoman.vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;
import java.awt.Rectangle;

import javax.swing.JPanel;

import algo3.grupo7.algoman.modelo.Juego;
import algo3.grupo7.algoman.modelo.Teclado;

import algo3.grupo7.algoman.vista.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;


public class VentanaPrincipal extends Ventana {
	private Juego juego;
	private Label labelPuntaje = null;

	public VentanaPrincipal() {
		super(700, 700);
	
		this.setTitle("Facman");
		this.setFocusable(true);
		labelPuntaje = new Label();
		labelPuntaje.setBounds(new Rectangle(161, 113, 129, 61));
		labelPuntaje.setText("Label");
		   juego = new Juego();
			this.setControlador(juego.getControlador());
			juego.getControlador().setSuperficieDeDibujo(this);
			this.addKeyListener(juego.getControladorPacman());
			this.setVisible(true);
	
		this.iniciar();
	}



	
	private static final long serialVersionUID = 1L;
	
	public void iniciar(){
		juego.iniciar();
	}

	public static void main(String[] args) {
	VentanaPrincipal ventana=new VentanaPrincipal();
	ventana.iniciar();
	}
	
}

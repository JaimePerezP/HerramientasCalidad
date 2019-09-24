package practica;

import java.util.ArrayList;

public class Joven extends Cliente {

	private int numCarnetJoven;
	
	public Joven(String dni, String nombre, String apellidos, Tarjeta tarjeta, Fecha fechaNacimeinto, long telefono, String email, ArrayList<Solicitud> solicitudes, int numero){
		
		super(dni, nombre, apellidos, tarjeta, fechaNacimeinto, telefono, email, solicitudes);
		this.numCarnetJoven = numero;
		
	}
	
	public double descuento(){
		return 0.20+super.descuento();
	}

	public int getNumero() {
		return numCarnetJoven;
	}

	public void setNumero(int numero) {
		this.numCarnetJoven = numero;
	}
	
}

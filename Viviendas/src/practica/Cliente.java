package practica;

import java.util.ArrayList;

public class Cliente {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private long telefono;
	private Fecha fechaNacimiento;
	private Tarjeta tarjeta;
	private String email;
	private ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();

	public Cliente(String dni, String nombre, String apellidos, Tarjeta numTarjeta, Fecha fechaNacimiento, long telefono, String email, ArrayList<Solicitud> solicitudes){
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.tarjeta = numTarjeta;
		this.email = email;
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Tarjeta getNumTrjeta() {
		return tarjeta;
	}

	public void setNumTarjeta(Tarjeta tarjetaCredito) {
		this.tarjeta = tarjetaCredito;
	}
	
	public void addSolicitud(Solicitud solicitud){
		solicitudes.add(solicitud);
	}
	
	public ArrayList<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public void quitSolicitud(Solicitud solicitud){
		solicitudes.remove(solicitud);
	}
	
	public boolean esHabitual(){
		if(solicitudes==null){
			return false;
		}
		return solicitudes.size()>=3;
	}
	
	public double descuento(){
		if (esHabitual()){
			return 0.10;
		}else{
			return 0;
		}
		
	}
	
}

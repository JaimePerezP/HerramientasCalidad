package practica;

public class Tarjeta {

	private long numTarjeta;
	private String entidad;
	private Fecha fechaCaducidad;
	private String titular;
	private int cvc;
	
	public Tarjeta(long numTarjeta, String titular, String entidad, Fecha fechaCaducidad, int cvc){
		
		this.numTarjeta = numTarjeta;
		this.entidad = entidad;
		this.fechaCaducidad = fechaCaducidad;
		this.titular=titular;
		this.cvc=cvc;
		
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public long getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(long numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public Fecha getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Fecha fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
}

package practica;

public abstract class Vivienda {
	
	private int identificador;
	private int metros;
	private int antiguedad;
	private boolean ventalquiler;
	private int precio;
	
	public Vivienda(int identificador, int metros, int precio, int antiguedad, boolean ventalquiler){
		
		this.identificador = identificador;
		this.metros = metros;
		this.antiguedad = antiguedad;
		this.ventalquiler = ventalquiler;
		this.precio = precio;
		
	}
	
	public int getIdentificador(){
		return identificador;
	}
	
	public int getMetros(){
		return metros;
	}
	
	public int getAntiguedad(){
		return antiguedad;
	}
	
	public boolean getVentalquiler(){
		return ventalquiler;
	}
	
	public int getPrecio(){
		return precio;
	}
	
	public void setIdentificador(int identificador){
		this.identificador = identificador;
	}
	
	public void setMetros(int metros){
		this.metros = metros;
	}
	
	public void setAntiguedad(int antiguedad){
		this.antiguedad = antiguedad;
	}
	
	public void setVentalquiler(boolean ventalquiler){
		this.ventalquiler = ventalquiler;
	}
	
	public void setPrecio(int precio){
		this.precio = precio;
	}

}

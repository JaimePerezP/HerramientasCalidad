package practica;

public class Chalet extends Vivienda {
	
	private int distancia;
	private boolean piscina;
	
	public Chalet(int identificador, int metros, int precio, int antiguedad, boolean ventalquiler, int distancia, boolean piscina){
		
		super(identificador, metros, precio, antiguedad, ventalquiler);
		this.distancia = distancia;
		this.piscina = piscina;
		
	}
	
	public int getDistancia(){
		return distancia;
	}
	
	public boolean getPiscina(){
		return piscina;
	}
	
	public void setDistancia(int distancia){
		this.distancia = distancia;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

}

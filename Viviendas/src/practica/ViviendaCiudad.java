package practica;

public class ViviendaCiudad extends Vivienda{

	private boolean amueblado;
	private TPiso tipo;
	
	public ViviendaCiudad(int identificador, int metros, int precio, int antiguedad, boolean ventalquiler, boolean amueblado, TPiso tipo){
		
		super(identificador, metros, precio, antiguedad, ventalquiler);
		this.amueblado = amueblado;
		this.tipo = tipo;
		
	}
	
public boolean getAmueblado() {
		return amueblado;
	}

	public void setAmueblado(boolean amueblado) {
		this.amueblado = amueblado;
	}

	public TPiso getTipo() {
		return tipo;
	}

	public void setTipo(TPiso tipo) {
		this.tipo = tipo;
	}


  }


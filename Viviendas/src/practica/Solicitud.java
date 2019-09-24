package practica;

public class Solicitud {
	
	private Vivienda vivienda;
	private SEstado estado;
	private Cliente cliente;
	private String dni;
	private int idVivienda;
	
	public Solicitud(Vivienda vivienda, Cliente cliente,SEstado estado){
		
		this.vivienda=vivienda;
		this.cliente=cliente;
		this.estado=estado;
		this.idVivienda=idVivienda;
		this.dni=dni;
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public SEstado getEstado() {
		return estado;
	}

	public void setEstado(SEstado estado) {
		this.estado = estado;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}

	public int getIdVivienda() {
		return idVivienda;
	}

	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	
}
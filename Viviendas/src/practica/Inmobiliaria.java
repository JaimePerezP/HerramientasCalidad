package practica;

import java.util.ArrayList;

public class Inmobiliaria {
	
	private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
	private ArrayList<Vivienda> viviendas=new ArrayList<Vivienda>();
	
	public Inmobiliaria(ArrayList<Cliente> clientes, ArrayList<Vivienda> viviendas){
		
		this.clientes=clientes;
		this.viviendas=viviendas;
		
	}
	
	//método para cargar los clientes a las solicitudes
	public static Cliente clienteSolicitud(ArrayList<Cliente> clientes, String dni){
		Cliente clienteS=null;
		for(int i=0;i<clientes.size();i++){
			if(clientes.get(i).getDni().compareTo(dni)==0){
				clienteS=clientes.get(i);
			}
		}return clienteS;
	}
	
	//método para cargar las solicitudes a los clientes
	public static ArrayList<Solicitud> solicitudCliente(ArrayList<Solicitud> solicitudes, String dni){
		  ArrayList<Solicitud> solicitudesC=new ArrayList<Solicitud>();
		  for(int i=0; i<solicitudes.size(); i++){
			  if(solicitudes.get(i).getDni().compareTo(dni)==0){
				  solicitudesC.add(solicitudes.get(i));
			  }
		  }return solicitudesC;
	  }
	
	//método para cargar las viviendas a las solicitudes
	public static Vivienda viviendaSolicitud(ArrayList<Vivienda> viviendas, int idVivienda){
		  Vivienda vivSolicitud = null;
		  for(int i=0; i<viviendas.size(); i++){
			  Vivienda vivienda=viviendas.get(i);
			  if (idVivienda==vivienda.getIdentificador()){
				  vivSolicitud=vivienda;
			  }
		  }return vivSolicitud;
	  }
	
	//método para cargar las tarjetas a los clientes
	  public static Tarjeta tarjetaCliente(ArrayList<Tarjeta> tarjetas, long numTarjeta){
		  Tarjeta tarCliente = null;
		  for (int i=0; i<tarjetas.size(); i++){
			  Tarjeta tarjeta=tarjetas.get(i);
			  if (numTarjeta==tarjeta.getNumTarjeta()){
				  tarCliente=tarjeta;
			  }
		  }return tarCliente;
	  }

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Vivienda> getViviendas() {
		return viviendas;
	}

	public void setViviendas(ArrayList<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	
}

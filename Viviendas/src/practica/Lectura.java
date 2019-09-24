package practica;

import java.io.*;
import java.util.*;

public class Lectura {
	
  public static ArrayList<Vivienda> leerViviendas () throws IOException{
	ArrayList<Vivienda> viviendas = new ArrayList <Vivienda>();
	File f=new File("C:\\Users\\jaime\\Documents\\Ficheros\\Viviendas.txt");
    Scanner nombre_f = new Scanner (f);    
    while (nombre_f.hasNext()){
      char opcion=nombre_f.next().charAt(0);
      int identificador=nombre_f.nextInt();
      int metros=nombre_f.nextInt();
      int precio=nombre_f.nextInt();
      int antiguedad=nombre_f.nextInt();
      String vent=nombre_f.next();
      String venta="venta";
      String alquiler="alquiler";
      boolean ventalquiler = false;
      if(vent.compareTo(venta)==0){
    	  ventalquiler=true;
      }
      else if(vent.compareTo(alquiler)==0){
    	  ventalquiler=false;
      }
      if (opcion=='c'){
        int distancia=nombre_f.nextInt();
        boolean piscina=nombre_f.nextBoolean();
        viviendas.add(new Chalet(identificador,metros,precio,antiguedad,ventalquiler,distancia,piscina));
      }
      else {
    	boolean amueblado=nombre_f.nextBoolean();
    	TPiso tipo;
    	if (opcion=='e'){
    		tipo=TPiso.ESTUDIO;
    	}else if (opcion=='a'){
    		tipo=TPiso.APARTAMENTO;
    	}else{
    		tipo=TPiso.PISO;
    	}
    	viviendas.add(new ViviendaCiudad(identificador,metros,precio,antiguedad,ventalquiler,amueblado,tipo));
      }
    }
    nombre_f.close();
    return viviendas;
  }
  
  public static ArrayList<Cliente> leerClientes ()throws IOException{
		ArrayList<Cliente> clientes = new ArrayList <Cliente>();
	    File f=new File("C:\\Users\\jaime\\Documents\\Ficheros\\Clientes.txt");
	    Scanner nombre_f = new Scanner (f);
	    while (nombre_f.hasNext()){
	      String dni=nombre_f.next();
		  String nombre=nombre_f.next();
		  String apellidos=nombre_f.next();
		  long numTarjeta=nombre_f.nextLong();
		  Tarjeta tarjeta=Inmobiliaria.tarjetaCliente(leerTarjetas(), numTarjeta);
		  String fecha=nombre_f.next();
	   	  Fecha fechaNacimiento=pasarFecha(fecha);
		  long telefono=nombre_f.nextLong();
		  String email=nombre_f.next();
		  ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
		  if (nombre_f.hasNextInt()){
			 int numero=nombre_f.nextInt();
			 clientes.add(new Joven (dni, nombre, apellidos, tarjeta,fechaNacimiento, telefono, email, solicitudes,numero));
			 }
		  else {
			 clientes.add(new Cliente(dni, nombre, apellidos, tarjeta,fechaNacimiento, telefono, email,solicitudes));
				      }
	    }
	    nombre_f.close();
	    return clientes;
	  }  
  
  public static ArrayList<Tarjeta> leerTarjetas ()throws IOException{
		ArrayList<Tarjeta> tarjetas = new ArrayList <Tarjeta>();
	    File f=new File("C:\\Users\\jaime\\Documents\\Ficheros\\Tarjetas.txt");
	    Scanner nombre_f = new Scanner (f);
	    while (nombre_f.hasNext()){
	    	long numTarjeta=nombre_f.nextLong();
	    	String titular=nombre_f.next();
	    	String entidad=nombre_f.next();
	    	String fecha=nombre_f.next();
			Fecha fechaCaducidad=pasarFecha(fecha);
	    	int cvc=nombre_f.nextInt();
	    	tarjetas.add(new Tarjeta(numTarjeta,titular,entidad,fechaCaducidad,cvc));
	       }
	       nombre_f.close();
	       return tarjetas;
	    }
  
  public static ArrayList<Solicitud> leerSolicitudes ()throws IOException{
		ArrayList<Solicitud> solicitudes = new ArrayList <Solicitud>();
	    File f=new File("C:\\Users\\jaime\\Documents\\Ficheros\\Solicitudes.txt");
	    Scanner nombre_f = new Scanner (f);
	    while (nombre_f.hasNext()){
	    	String dni=nombre_f.next();
	    	int idVivienda=nombre_f.nextInt();
	    	Vivienda vivienda = null;
	    	Cliente cliente=null;
	    	SEstado estado = SEstado.PENDIENTE;
	    	Solicitud solicitud=new Solicitud(vivienda, cliente, estado);
	    	solicitud.setDni(dni);
	    	solicitud.setIdVivienda(idVivienda);
	    	solicitudes.add(solicitud);
	       }
	       nombre_f.close();
	       return solicitudes;
	    }
  
  //m�todo para pasar String fecha a varios int
  public static Fecha pasarFecha(String sFecha){
	  String[] parts=sFecha.split("/");
	  String part1 = parts[0];
	  String part2 = parts[1];
	  String part3 = parts[2];
      int dia = Integer.parseInt(part1);
      int mes = Integer.parseInt(part2);
      int ano = Integer.parseInt(part3);
	  Fecha fecha=new Fecha(dia,mes,ano);
	  return fecha;
  }
	
  
}
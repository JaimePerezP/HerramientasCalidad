package practica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {

	static Scanner TECLADO = new Scanner(System.in);

	// m�todo para pedir los datos de un nuevo cliente
	public static ArrayList<Cliente> nuevoCliente(char respuesta) {

		ArrayList<Cliente> clienteNuevo = new ArrayList<Cliente>();
		System.out.println("DNI: ");
		String dni = TECLADO.next();
		System.out.println("Nombre: ");
		String nombre = TECLADO.next();
		System.out.println("Apellidos: ");
		String apellidos = TECLADO.next();
		long telefono = 0;
		do {
			System.out.println("Tel�fono :");
			String telefono1 = TECLADO.next();
			try {
				telefono = Long.parseLong(telefono1);
			} catch (NumberFormatException n) {
				System.out.println("Vuelva a intentarlo.");
			}
		} while (telefono == 0);
		System.out.println("Fecha de nacimiento (dd/mm/aaaa): ");
		String fecha = TECLADO.next();
		Fecha fechaNacimiento = Lectura.pasarFecha(fecha);
		System.out.println("eMail: ");
		String email = TECLADO.next();
		ArrayList<Solicitud> solicitudes = null;
		Tarjeta tarjeta = nuevaTarjeta();
		if (respuesta == 'N') {
			clienteNuevo
					.add(new Cliente(dni, nombre, apellidos, tarjeta, fechaNacimiento, telefono, email, solicitudes));
		} else if (respuesta == 'S') {
			int numero = 0;
			do {
				System.out.println("Introduzca el numero del carnet joven: ");
				String numero1 = TECLADO.next();
				try {
					numero = Integer.parseInt(numero1);
				} catch (NumberFormatException n) {
					System.out.println("Vuelva a intentarlo.");
				}
			} while (numero == 0);
			clienteNuevo.add(
					new Joven(dni, nombre, apellidos, tarjeta, fechaNacimiento, telefono, email, solicitudes, numero));
		}
		return clienteNuevo;
	}

	// m�todo para pedir los datos de la tarjeta del nuevo cliente
	public static Tarjeta nuevaTarjeta() {

		long numero = 0;
		do {
			System.out.println("Numero de tarjeta: ");
			String numero1 = TECLADO.next();
			try {
				numero = Long.parseLong(numero1);
			} catch (NumberFormatException n) {
				System.out.println("Vuelva a intentarlo.");
			}
		} while (numero == 0);
		System.out.println("Titular: ");
		String titular = TECLADO.next();
		System.out.println("Entidad bancaria: ");
		String entidad = TECLADO.next();
		System.out.println("Fecha de caducidad (dd/mm/aaaa): ");
		String fecha = TECLADO.next();
		Fecha fechaCaducidad = Lectura.pasarFecha(fecha);
		int cvc = 0;
		do {
			System.out.println("CVC: ");
			String cvc1 = TECLADO.next();
			try {
				cvc = Integer.parseInt(cvc1);
			} catch (NumberFormatException n) {
				System.out.println("Vuelva a intentarlo.");
			}
		} while (cvc == 0);
		Tarjeta tarjetaNueva = new Tarjeta(numero, titular, entidad, fechaCaducidad, cvc);
		return tarjetaNueva;
	}

	// m�etodo para mostrar las viviendas en venta
	public static void mostrarVentas(ArrayList<Vivienda> viviendas) {
		for (int i = 0; i < viviendas.size(); i++) {
			Vivienda vivienda = viviendas.get(i);
			if (vivienda.getVentalquiler() == true) {
				System.out.print("\nIdentificador: " + vivienda.getIdentificador() + "\tMetros: " + vivienda.getMetros()
						+ "\tAntiguedad: " + vivienda.getAntiguedad() + "\tPrecio: " + vivienda.getPrecio());
				if (vivienda.getClass().getSimpleName().compareTo("Chalet") == 0) {
					Chalet chalet = (Chalet) viviendas.get(i);
					System.out.print("\tTipo: Chalet\tDistancia: " + chalet.getDistancia() + "\tPiscina: "
							+ chalet.getPiscina());
				} else if (vivienda.getClass().getSimpleName().compareTo("ViviendaCiudad") == 0) {
					ViviendaCiudad piso = (ViviendaCiudad) viviendas.get(i);
					System.out.print("\tTipo: " + piso.getTipo() + "\tAmueblado: " + piso.getAmueblado());
				}
			}
		}
		System.out.println();
	}

	// m�todo para mostrar las viviendas en alquiler
	public static void mostrarAlquiler(ArrayList<Vivienda> viviendas) {
		for (int i = 0; i < viviendas.size(); i++) {
			Vivienda vivienda = viviendas.get(i);
			if (vivienda.getVentalquiler() == false) {
				System.out.print("\nIdentificador: " + vivienda.getIdentificador() + "\tMetros: " + vivienda.getMetros()
						+ "\tAntiguedad: " + vivienda.getAntiguedad() + "\tPrecio: " + vivienda.getPrecio());
				if (vivienda.getClass().getSimpleName().compareTo("Chalet") == 0) {
					Chalet chalet = (Chalet) viviendas.get(i);
					System.out.print("\tTipo: Chalet\tDistancia: " + chalet.getDistancia() + "\tPiscina: "
							+ chalet.getPiscina());
				} else if (vivienda.getClass().getSimpleName().compareTo("ViviendaCiudad") == 0) {
					ViviendaCiudad piso = (ViviendaCiudad) viviendas.get(i);
					System.out.print("\tTipo: " + piso.getTipo() + "\tAmueblado: " + piso.getAmueblado());
				}
			}
		}
		System.out.println();
	}

	// m�todo para buscar una vivienda por su identificador
	public static Vivienda viviendaDeseada(int id) {
		Vivienda vivienda = null;
		try {
			for (int i = 0; i < Lectura.leerViviendas().size(); i++) {
				Vivienda viviendaM = Lectura.leerViviendas().get(i);
				if (id == viviendaM.getIdentificador()) {
					vivienda = viviendaM;
					System.out.print("La vivienda que ha seleccionado:\nIdentificador: " + vivienda.getIdentificador()
							+ "\tMetros: " + vivienda.getMetros() + "\tAntiguedad: " + vivienda.getAntiguedad()
							+ "\tPrecio: " + vivienda.getPrecio());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vivienda;
	}

	// m�todo para registrarse como nuevo cliente
	public static Cliente registrarse() {
		char respuesta = 0;
		do {
			System.out.println("�Tiene carnet joven?   S=SI    N=NO");
			respuesta = TECLADO.next().toUpperCase().charAt(0);
		} while (respuesta != 'N' && respuesta != 'S');
		ArrayList<Cliente> cliente = nuevoCliente(respuesta);
		return cliente.get(0);
	}

	// m�todo para consultar el numero de solicitudes de una vivienda
	public static int numeroSolicitudes(int idVivienda, ArrayList<Solicitud> solicitudes) {

		int contador = 0;

		for (int i = 0; i < solicitudes.size(); i++) {
			if (idVivienda == solicitudes.get(i).getVivienda().getIdentificador()) {
				contador++;
			}
		}
		return contador;
	}

	// m�todo para consultar las solicitudes de un cliente
	public static void consultarSolicitudes(ArrayList<Solicitud> solicitudes, ArrayList<Cliente> clientes) {
		System.out.println("Introduzca el dni del cliente que quiere consultar:");
		String dni = TECLADO.next();
		Cliente cliente = null;
		for (int i = 0; i < clientes.size(); i++) {
			if (dni.compareTo(clientes.get(i).getDni()) == 0) {
				cliente = clientes.get(i);
			}
		}
		if (cliente == null) {
			System.out.println("No se ha encontrado el DNI.");
		} else {
			System.out.println("Este cliente ha solicitado las viviendas: ");
			for (int i = 0; i < solicitudes.size(); i++) {
				if (dni.compareTo(solicitudes.get(i).getCliente().getDni()) == 0) {
					System.out.print(solicitudes.get(i).getVivienda().getIdentificador() + "\t");
				}
			}
		}
	}

	// m�todo para realizar una nueva solicitud
	public static void realizarSolicitud(ArrayList<Cliente> clientes, ArrayList<Vivienda> viviendas,
			ArrayList<Solicitud> solicitudes) {
		System.out.println("Introduzca su DNI:");
		String dni = TECLADO.next();
		Cliente cliente = null;
		for (int i = 0; i < clientes.size(); i++) {
			if (dni.compareTo(clientes.get(i).getDni()) == 0) {
				cliente = clientes.get(i);
			}
		}

		if (cliente == null) {
			System.out
					.println("Este DNI no esta registrado, para registrarse como nuevo cliente introduzca los datos:");
			cliente = registrarse();
			clientes.add(cliente);
		}
		int respuesta = 0;
		do {
			System.out.println("�Quiere comprar o alquilar una vivienda?\n1: comprar   2: alquilar");
			String respuesta1 = TECLADO.next();
			try {
				respuesta = Integer.parseInt(respuesta1);
			} catch (NumberFormatException n) {
				System.out.println("Vuelva a intentarlo.");
			}
		} while (respuesta < 1 || respuesta > 2);
		if (respuesta == 1) {

			mostrarVentas(viviendas);

		} else if (respuesta == 2) {

			mostrarAlquiler(viviendas);

		}
		int idVivienda = 0;
		Vivienda vivienda = null;

		do {
			System.out.println("\nIntroduzca el identificador de la vivienda que desea: ");
			String idVivienda1 = TECLADO.next();
			try {
				idVivienda = Integer.parseInt(idVivienda1);
			} catch (NumberFormatException n) {
				System.out.println("Vuelva a intentarlo.");
			}
		} while (idVivienda < 1 || idVivienda > 12);
		vivienda = viviendaDeseada(idVivienda);
		SEstado estado = SEstado.PENDIENTE;
		Solicitud solicitud = new Solicitud(vivienda, cliente, estado);
		solicitudes.add(solicitud);
		cliente.addSolicitud(solicitud);
		System.out.println("\nPrecio con descuento: " + (vivienda.getPrecio() * (1 - cliente.descuento())));

	}

	// m�todo para elegir entre viviendas en venta o alquiler
	public static void verViviendas(ArrayList<Vivienda> viviendas) {
		int resp = 0;

		do {
			System.out.println("Ver viviendas en venta o alquiler:\n1: venta   2: alquiler");
			String resp1 = TECLADO.next();
			try {
				resp = Integer.parseInt(resp1);

			} catch (NumberFormatException n) {
				System.out.println("Vuelva a intentarlo.");

			}
		} while (resp < 1 || resp > 2);
		if (resp == 1) {
			mostrarVentas(viviendas);
		} else if (resp == 2) {
			mostrarAlquiler(viviendas);
		}
	}

	// m�todo para mostrar los nombres de los clientes ordenados alfab�ticamente
	public static void nombresAlf(ArrayList<Cliente> clientes) {
		ArrayList<String> nombres = new ArrayList<String>();

		for (int i = 0; i < clientes.size(); i++) {
			nombres.add(clientes.get(i).getApellidos() + " " + clientes.get(i).getNombre());
		}
		Collections.sort(nombres);
		System.out.println("Los nombres de los clientes son:");
		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i));
		}
	}

	// m�todo para mostrar los clientes ordenados por DNI
	public static void dniAlf(ArrayList<Cliente> clientes) {
		ArrayList<String> dni = new ArrayList<String>();

		for (int i = 0; i < clientes.size(); i++) {
			dni.add(clientes.get(i).getDni());
		}
		Collections.sort(dni);
		System.out.println("Los DNI de los clientes son:");
		for (int i = 0; i < dni.size(); i++) {
			System.out.println(dni.get(i));
		}
	}

	// m�todo para consultar si un cliente es considerado joven
	public static void consultarJoven(ArrayList<Cliente> clientes) {
		int edad = -1;
		boolean existe = false;
		do {
			System.out.println("Introduzca una edad");
			String edad1 = TECLADO.next();
			try {
				edad = Integer.parseInt(edad1);
			} catch (NumberFormatException n) {
				System.out.println("Vuelva a intentarlo.");
			}
		} while (edad < 0);

		for (int i = 0; i < clientes.size(); i++) {
			if (2017 - clientes.get(i).getFechaNacimiento().getAno() == edad) {
				existe = true;
				if (clientes.get(i).getClass().getSimpleName().compareTo("Joven") == 0) {
					System.out.println(clientes.get(i).getNombre() + " " + clientes.get(i).getApellidos()
							+ " tiene carnet joven.");
				} else {
					System.out.println(clientes.get(i).getNombre() + " " + clientes.get(i).getApellidos()
							+ " NO tiene carnet joven.");
				}
			}
		}
		if (existe == false) {
			System.out.println("No hay ningun cliente con esa edad");
		}
	}

	// m�todo para mostrar los clientes con carnet joven mayores de 25 a�os
	private static void retirarJoven(ArrayList<Cliente> clientes) {
		System.out.println("Los clientes a los que se les deberia retirar el carnet joven son:");
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getClass().getSimpleName().compareTo("Joven") == 0) {
				if (2017 - clientes.get(i).getFechaNacimiento().getAno() > 25) {
					System.out.println(clientes.get(i).getNombre() + " " + clientes.get(i).getApellidos());
				}
			}
		}

	}

	// m�todo para consultar si un cliente es considerado habitual
	public static void clienteHabitual(ArrayList<Cliente> clientes) {
		System.out.println("Introduzca el dni del cliente que quiere consultar:");
		String dni = TECLADO.next();
		Cliente cliente = null;
		for (int i = 0; i < clientes.size(); i++) {
			if (dni.compareTo(clientes.get(i).getDni()) == 0) {
				cliente = clientes.get(i);
			}
		}
		if (cliente == null) {
			System.out.println("No se ha encontrado el DNI.");
		} else {
			if (cliente.esHabitual()) {
				System.out.println(cliente.getNombre() + " " + cliente.getApellidos() + " es cliente habitual.");
			} else if (cliente.esHabitual() == false) {
				System.out.println(cliente.getNombre() + " " + cliente.getApellidos() + " NO es cliente habitual.");
			}
		}
	}

	// m�todo para consultar el descuento que se le aplica a un cliente
	private static void consultarDescuento(ArrayList<Cliente> clientes) {
		System.out.println("Introduzca el dni del cliente que quiere consultar:");
		String dni = TECLADO.next();
		Cliente cliente = null;
		for (int i = 0; i < clientes.size(); i++) {
			if (dni.compareTo(clientes.get(i).getDni()) == 0) {
				cliente = clientes.get(i);
			}
		}
		if (cliente == null) {
			System.out.println("No se ha encontrado el DNI.");
		} else {
			System.out.println("Se le aplica un descuento de " + (cliente.descuento() * 100) + "%");
		}
	}

	// m�todo principal
	public static void main(String[] args) {
		// cargamos los datos de los ficheros
		ArrayList<Vivienda> viviendas = null;
		ArrayList<Cliente> clientes = null;
		ArrayList<Solicitud> solicitudes = null;

		try {
			try {
				solicitudes = Lectura.leerSolicitudes();
			} catch (FileNotFoundException e) {
				System.out.println("No se ha encontrado el fichero Solicitudes");
			}
			try {
				viviendas = Lectura.leerViviendas();
			} catch (FileNotFoundException e) {
				System.out.println("No se ha encontrado el fichero Viviendas");
			}
			try {
				clientes = Lectura.leerClientes();
			} catch (FileNotFoundException e) {
				System.out.println("No se ha encontrado el fichero Clientes");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// cargamos los datos correspondientes en su sitio
		for (int i = 0; i < solicitudes.size(); i++) {
			solicitudes.get(i)
					.setVivienda(Inmobiliaria.viviendaSolicitud(viviendas, solicitudes.get(i).getIdVivienda()));
		}
		for (int i = 0; i < solicitudes.size(); i++) {
			solicitudes.get(i).setCliente(Inmobiliaria.clienteSolicitud(clientes, solicitudes.get(i).getDni()));
		}
		for (int i = 0; i < clientes.size(); i++) {
			clientes.get(i).setSolicitudes(Inmobiliaria.solicitudCliente(solicitudes, clientes.get(i).getDni()));
		}

		boolean fin = false;
		do {
			boolean con = false;
			int opcion = 0;
			do {
				// opciones del men�
				System.out.println(
						"\nEliga una opci�n del men�:\n1.Realizar una solicitud.\n2.Consultar el numero de solicitudes de una vivienda.\n3.Ver viviendas.\n4.Consultar las solicitudes de un cliente.\n5.Listado alfab�tico clientes.\n6.Lista DNI de los clientes.\n7.Consultar clientes con carnet joven por edad.\n8.Consultar los clientes que no deberian tener carnet joven.\n9.Consultar si un cliente es habitual.\n10.Consultar descuento.\n11.Finalizar el programa.");
				String opcion1 = TECLADO.next();

				try {
					opcion = Integer.parseInt(opcion1);
					con = true;
				} catch (NumberFormatException n) {
					System.out.println("Vuelva a intentarlo.");
					con = true;
				}
			} while (con == false);

			// MEN�
			switch (opcion) {
			case 1:
				realizarSolicitud(clientes, viviendas, solicitudes);
				break;
			case 2:
				int idVivienda = 0;
				do {
					System.out.println("\nIntroduzca el identificador de la vivienda que quiere consultar:");
					String idVivienda1 = TECLADO.next();
					try {
						idVivienda = Integer.parseInt(idVivienda1);
					} catch (NumberFormatException n) {
						System.out.println("Vuelva a intentarlo.");
					}
				} while (idVivienda < 1 || idVivienda > 12);
				int contador = numeroSolicitudes(idVivienda, solicitudes);
				System.out.println("Esta vivienda tiene " + contador + " solicitudes.");
				break;
			case 3:
				verViviendas(viviendas);
				break;
			case 4:
				consultarSolicitudes(solicitudes, clientes);
				break;
			case 5:
				nombresAlf(clientes);
				break;
			case 6:
				dniAlf(clientes);
				break;
			case 7:
				consultarJoven(clientes);
				break;
			case 8:
				retirarJoven(clientes);
				break;
			case 9:
				clienteHabitual(clientes);
				break;
			case 10:
				consultarDescuento(clientes);
				break;
			case 11:
				fin = true;
				System.out.println("Fin del programa.");
				break;
			}
		} while (fin == false);

	}// fin main

}// fin clase

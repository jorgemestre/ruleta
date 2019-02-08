package ruletaConsola;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Menus {

	public static ArrayList<Jugador> menuJugadores() {

		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

		System.out.println("Bienvenido a la primera ruleta luego de 20 anyos."); // la enie porque deja simbolos.

		// Obtener las cantidad de jugadores y guardarlo en una variable. numJugadores
		System.out.println("Cuantos jugadores han venido?");
		int numJugadores = scan.nextInt();

		// Necesario para limpiar el buffer del Scanner
		scan.nextLine();

		//
		for (int i = 0; i < numJugadores; i++) {
			System.out.println("Nombre del jugador " + (i + 1));
			String name = scan.nextLine();
			Jugador j = new Jugador(name);
			jugadores.add(j);
			System.out.println("Bienvenido " + j.getName() + "(ID: " + j.getID() + ")");

		}

		// fix: resource leak scanner never closed. si no lo hago yo...en esta casa no
		// lo hace nadie.

		scan.close();
		return jugadores;

	}

	// Devuelve el jugador elegido o la ultima opcion "salir"
	public static int MostrarMenuGeneral(ArrayList<Jugador> jugadores) {

		/*
		 * Menu general 1- NomJugador 1 2- NomJugador 2 3- Salir
		 */

		System.out.println("Menu Principal de Apuestas. Selecciona jugador.");
		System.out.println("---- --------- -- --------- ---------- --------");
		int c = 1;
		for (Jugador j : jugadores) {
			System.out.println(c++ + "- " + j.getName());
		}

		System.out.println("   -----\n" + c + "- Salir");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int opcionElegida = 0;
		try {
			opcionElegida = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return opcionElegida;

	}

	private static TipoApuesta menuElejirApuesta() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Scanner scan = new Scanner(System.in);
		TipoApuesta tipoApuesta;

		System.out.println("1) Pleno");
		System.out.println("2) Color");
		System.out.println("3) Docena");

		int opcionElegida = 0;
		try {
			opcionElegida = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (opcionElegida) {
		case 1: {
			tipoApuesta = new TipoApuesta("pleno");
			break;
		}
		case 2: {
			tipoApuesta = new TipoApuesta("color");
			break;
		}
		case 3: {
			tipoApuesta = new TipoApuesta("docena");
			break;
		}
		default: {
			tipoApuesta = null;
			break;
		}
		}
		return tipoApuesta;

	}

	public static Apuesta menuApostar() {
		TipoApuesta ta = menuElejirApuesta();
		int[] detalle = null;

		switch (ta.getNombre()) {
		case "pleno": {
			detalle = menuApuestaPleno();
			break;
		}
		case "color": {
			detalle = menuApuestaColor();
			break;
		}
		case "docena": {
			detalle = menuApuestaDocena();
			break;
		}
        //NO implementado en TipoApuesta ni en menuElejirApuesta
		case "paridad": {
			detalle = menuApuestaParidad();
			break;
		}
        //NO implementado en TipoApuesta ni en menuElejirApuesta	
		case "mayoria": {
			detalle = menuApuestaMayoria();
			break;
		}
        //NO implementado en TipoApuesta ni en menuElejirApuesta	
		case "columna": {
			detalle = menuApuestaColumna();
			break;
		}
        //NO implementado en TipoApuesta ni en menuElejirApuesta
		case "fila": {
			detalle = menuApuestaFila();
			break;
		}
		}
		System.out.println("Cuanto le metemos?");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		float cantidad = 0;
		try {
			cantidad = Float.parseFloat(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Apuesta(ta, detalle, cantidad);

	}

	private static int[] menuApuestaFila() {
		System.out.println("Que fila? (1-12");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int fila = 0;
		try {
			fila = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (fila) {
		case 1:
			return new int[] { 1, 2, 3, };
		case 2:
			return new int[] { 4, 5, 6 };
		case 3:
			return new int[] { 7, 8, 9 };
		case 4:
			return new int[] { 10, 11, 12 };
		case 5:
			return new int[] { 13, 14, 15, };
		case 6:
			return new int[] { 16, 17, 18 };
		case 7:
			return new int[] { 19, 20, 21 };
		case 8:
			return new int[] { 22, 23, 24 };
		case 9:
			return new int[] { 25, 26, 27 };
		case 10:
			return new int[] { 28, 29, 30 };
		case 11:
			return new int[] { 31, 32, 33 };
		case 12:
			return new int[] { 34, 35, 36 };

		default:
			return null;
		}
	}

	private static int[] menuApuestaColumna() {
		System.out.println("Que columna (1/2/3)");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int columna = 0;
		try {
			columna = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (columna) {
		case 1:
			return new int[] { 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34 };
		case 2:
			return new int[] { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35 };
		case 3:
			return new int[] { 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36 };

		default:
			return null;
		}
	}

	private static int[] menuApuestaMayoria() {
		System.out.println("Mayor o menor? (mayor/menor)");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String mayoria = null;
		try {
			mayoria = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (mayoria) {
		case "menor":
			return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		case "impar":
			return new int[] { 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };
		default:
			return null;
		}
	}

	private static int[] menuApuestaParidad() {
		System.out.println("A que paridad? (par/impar)");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String paridad = null;
		try {
			paridad = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (paridad) {
		case "par":
			return new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36 };
		case "impar":
			return new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35 };

		default:
			return null;
		}

	}

	private static int[] menuApuestaDocena() {
		System.out.println("A que docena? (1/2/3)");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int docena = 0;
		try {
			docena = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (docena) {
		case 1:
			return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		case 2:
			return new int[] { 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
		case 3:
			return new int[] { 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };

		default:
			return null;
		}

	}

	private static int[] menuApuestaColor() {
		System.out.println("A que color? (rojo/negro)");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String color = null;
		try {
			color = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		switch (color) {
		case "rojo":
			return new int[] { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
		case "negro":
			return new int[] { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };
		default:
			return null;
		}
	}

	private static int[] menuApuestaPleno() {

		System.out.println("A que numerito? (solo uno campeon!)");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] _detalle = null;
		try {
			_detalle = in.readLine().split(",");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int[] detalle = new int[1];
		detalle[0] = Integer.parseInt(_detalle[0]);

		return detalle;
	}

	// verdadero si quiere seguir apostando
	// falso si no quiere
	public static boolean menuOtraApuesta() {
		System.out.println("Desea realizar otra apuesta? (n para terminar)");
		java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String respuesta = null;
		try {
			respuesta = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (respuesta.length() == 1 && respuesta.startsWith("n")) {
			return false;
		} else {
			return true;
		}

	}

}

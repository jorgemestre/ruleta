package ruletaConsola;

import java.util.ArrayList;
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


	
}

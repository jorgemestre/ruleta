
package ruletaConsola;

import java.util.ArrayList;

import java.util.Scanner;

public class Principal {

	public static ArrayList<Jugador> menuJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		System.out.println("Bienvenido a la primera ruleta luego de 20 anyos."); // la enie porque deja simbolos.
		System.out.println("Cuantos jugadores han venido?");

		Scanner scan = new Scanner(System.in);
		int numJugadores = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < numJugadores; i++) {
			System.out.println("Nombre del jugador " + (i + 1));
			String name = scan.nextLine();
			Jugador j = new Jugador(name);
			jugadores.add(j);
			System.out.println("Bienvenido " + j.getName());
		}
		// fix: resource leak scanner never closed. si no lo hago yo...en esta casa no lo hace nadie.
		scan.close(); 
		return jugadores;

	}

	public static void main(String[] args) {
		Boolean DrawMeLikeOneOfYourFrenchGirls = false; // los cheats! los cheats!
		Tablero tablero = new Tablero();
		for (Jugador jugador : menuJugadores()) {
			System.out.println(jugador.getName());
			tablero.AgregarJugador(jugador);
		}
	}
}
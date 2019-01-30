
package ruletaConsola;

import java.util.ArrayList;

import java.util.Scanner;

public class Principal {

	public static ArrayList<Jugador> menuJugadores() {

		ArrayList<Jugador> jugadores = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bienvenido a la primera ruleta luego de 20 anyos."); // la enie porque deja simbolos.
		
		//Obtener las cantidad de jugadores y guardarlo en una variable. numJugadores
		System.out.println("Cuantos jugadores han venido?");
		int numJugadores = scan.nextInt();
		
		//Necesario para limpiar el buffer del Scanner 
		scan.nextLine();

		//
		for (int i = 0; i < numJugadores; i++) 
		{
			System.out.println("Nombre del jugador " + (i + 1));
			String name = scan.nextLine();
			jugadores.add(new Jugador(name));
			System.out.println("Bienvenido " + name);
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
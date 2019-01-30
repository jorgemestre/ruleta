
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

			Jugador j = new Jugador(name);
			Jugador.aumentarID();
			j.setID(Jugador.getContadorIDs());
			jugadores.add(j);
			System.out.println("Bienvenido " + j.getName() + "(ID: " + j.getID() + ")");

		}

		
		
		// fix: resource leak scanner never closed. si no lo hago yo...en esta casa no lo hace nadie.

		scan.close();
		return jugadores;

	}

	public static void main(String[] args) {

		Boolean DrawMeLikeOneOfYourFrenchGirls = false; // los cheats! los cheats!


		// flag para presentar jugadores automaticamente
		Boolean auto_menuJugadores = false;


		Tablero tablero = new Tablero();

	
		for (Jugador jugador : menuJugadores())
		{
			System.out.println(jugador.getName());
			tablero.AgregarJugador(jugador);

		if (auto_menuJugadores) 
		{
			// TODO
		} 
		else
		{
			// presentar jugadores manualmente
			for (Jugador j : menuJugadores()) 
			{
				System.out.println(j.getName());
				tablero.AgregarJugador(j);
			}

		}
	   
		// Comienzan las apuestas.
		/*
		 * crear menu para elegir jugador y que haga su apuesta
		 * mas un item extra que el cruiper o como se llame diga basta
		 * tipo:
		 * Menu de Apuestas
		 * 1- Austin Powers
		 * 2- Peperino Pomoro
		 * 3- No mas apuestas
		 * con un submenu para tipo de apuestas, etc.
		 * 
		 * */
		}
	}
}
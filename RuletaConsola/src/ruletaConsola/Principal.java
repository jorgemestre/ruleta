
package ruletaConsola;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Tablero tablero = new Tablero();
		
		System.out.println("Bienvenido a la primera ruleta luego de 20 años.");
		System.out.println("Cuantos jugadores han venido?");
		
		Scanner scan = new Scanner(System.in);
		
		int numJugadores = scan.nextInt();
		

		scan.nextLine();
		for (int i = 0; i<numJugadores; i++)
		{
			System.out.println("Nombre del jugador " + (i+1));
			String name = scan.nextLine();
			Jugador j = new Jugador(name);
			tablero.AgregarJugador(j);
			System.out.println("Bienvenido " + j.getName());
		}
		
	}

}

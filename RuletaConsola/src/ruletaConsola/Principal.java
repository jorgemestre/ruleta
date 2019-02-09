
package ruletaConsola;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		// TODO Boolean DrawMeLikeOneOfYourFrenchGirls = false; // los cheats! los
		// cheats!

		// flag para presentar jugadores automaticamente
		// SE SUPONE QUE TODO ESTO SE VA EN UNA VERSION RELEASE
		Boolean auto_menuJugadores = true;

		Tablero tablero = Tablero.iniciarTablero(auto_menuJugadores);

		// Comienzan las apuestas.
		System.out.println("\nCROUPIER: mesa cerrada con " + tablero.getJugadores().size()
				+ " participantes, que comiencen las apuestas!\n");

		do {

			//aqui empiezan y finalizan las rondas de apuestas
			Tablero.abrirApuestas(tablero);
			
			Tablero.mostrarApuestas(tablero);

			Casilla casilla = new Casilla(Utiles.generarIntRandom(0, 36));
			System.out.println("la bolita ha caido en la casilla: " + casilla.getNomColor() + " " + casilla.getNumero());
			//Casilla casilla = new Casilla(1); // FOR TESTING ONLY!! Siempre sale el UNO

			//// TODO: Verificar el numero con las apuestas ganadoras.
			tablero.pagarApuestas(casilla);

		} while (true);
	}
}

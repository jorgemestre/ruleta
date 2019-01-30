
package ruletaConsola;



public class Principal {

	public static void main(String[] args) {

		// TODO Boolean DrawMeLikeOneOfYourFrenchGirls = false; // los cheats! los
		// cheats!

		// flag para presentar jugadores automaticamente
		Boolean auto_menuJugadores = true;

		Tablero tablero = new Tablero();

		if (auto_menuJugadores) {
			int cantJugadores = Utiles.generarIntRandom(2, 5);
			System.out.println("[auto] van a Jugar " + cantJugadores + " jugadores:\n");
			for (Jugador j : Utiles.generarJugadores(cantJugadores)) {
				System.out.println("[auto] " + j.getName() + "(ID: " + j.getID() + ")");
				tablero.AgregarJugador(j);
			}

		} else {
			// presentar jugadores manualmente
			for (Jugador j : Menus.menuJugadores()) {
				System.out.println(j.getName());
				tablero.AgregarJugador(j);
			}

		}

		// Comienzan las apuestas.
		System.out.println("\nCROUPIER: mesa cerrada con " + tablero.getCantidadDeJugadores()
				+ " participantes, que comiencen las apuestas!");
		
		/*
		 * crear menu para elegir jugador y que haga su apuesta mas un item extra que el
		 * cruiper o como se llame diga basta tipo: Menu de Apuestas 1- Austin Powers 2-
		 * Peperino Pomoro 3- No mas apuestas con un submenu para tipo de apuestas, etc.
		 * 
		 */
	}
}
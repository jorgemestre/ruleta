
package ruletaConsola;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		// TODO Boolean DrawMeLikeOneOfYourFrenchGirls = false; // los cheats! los
		// cheats!

		// flag para presentar jugadores automaticamente

		// SE SUPONE QUE TODO ESTO SE VA EN UNA VERSION RELEASE
		Boolean auto_menuJugadores = true;

		Tablero tablero = iniciarTablero(auto_menuJugadores);

		// Comienzan las apuestas.
		System.out.println("\nCROUPIER: mesa cerrada con " + tablero.getJugadores().size()
				+ " participantes, que comiencen las apuestas!\n");

		
		// do-while (true) por ahora, despues vemos como salimos del juego.
		//Una vez definidos los jugadores entra un bucle infinito 
		// 1) Hacer apuestas
		// 2) tirar bolita
		// 3) pagar a ganadores
		// ... for ever and ever
		
		
		do {

		/*
		 * crear menu para elegir jugador y que haga su apuesta mas un item extra que el
		 * crouiper o como se llame diga basta tipo: Menu de Apuestas 1- Austin Powers
		 * 2- Peperino Pomoro 3- No mas apuestas con un submenu para tipo de apuestas,
		 * etc.
		 * 
		 */

		
		// Este metodo podria estar en Tablero como Tablero.AbrirApuestas(), o algo asi

			abrirApuestas(tablero);



			// EL NUMERO GANADOR!!!
			// Casilla casilla = new Casilla(tablero.GirarRuleta());

			Casilla casilla = new Casilla(1); // FOR TESTING ONLY!! Siempre sale el UNO
			// EL NUMERO GANADOR PERO VISTO DESDE ABAJO

			//// TODO: Verificar el numero con las apuestas ganadoras.
			pagarApuestas(tablero, casilla);
		} while (true);
	}

	/**
	 * @param tablero
	 * @param casilla
	 */
	private static void pagarApuestas(Tablero tablero, Casilla casilla) {
		for (Jugador j : tablero.getJugadores()) {
			ArrayList<Apuesta> apuestas = j.getApuestas();

			if (!apuestas.isEmpty()) {
				for (Apuesta a : apuestas) {
					for (int num : a.getDetalle()) {
						if (num == casilla.getNumero()) {
							
							// Aqui se hacen todos los calculines para pagar las apuestas y esas cosa.
							float premio = a.getTipo().getGAnancia() * a.getCantidad();
							j.setDinero(j.getDinero() + premio);

							System.out.println("Le hemos pegado a uno aqui");
							System.out.println(j.getName() + " tiene ahora " + j.getDinero());
						}
					}
				}
			}
		}
	}

	/**
	 * @param tablero
	 */
	private static void abrirApuestas(Tablero tablero) {
		int MenuGeneral = 0;
		
		
		while (MenuGeneral != (tablero.getJugadores().size() + 1)) {
			MenuGeneral = Menus.MostrarMenuGeneral(tablero.getJugadores());

			if (MenuGeneral <= (tablero.getJugadores().size())) {
				Jugador player = (tablero.getJugadores()).get(MenuGeneral - 1);
				System.out.println("has elegido a " + player.getName() + ". Me parece bien.");
				Apuesta apuesta = Menus.menuApostar();
				player.Apostar(apuesta);

			} else {
				System.out.println("Salimos del menu general..el codigo de mas abajo...");
				System.out.println(
						"/// Hic sunt dracones /// https://pbs.twimg.com/profile_images/807529718417391616/g3-s6tIV_400x400.jpg");
			}

		}
	}

	/**
	 * @param auto_menuJugadores
	 * @return
	 */
	private static Tablero iniciarTablero(Boolean auto_menuJugadores) {
		Tablero tablero = new Tablero();

		if (auto_menuJugadores) {
			int cantJugadores = Utiles.generarIntRandom(2, 2); /// LOCO! dos jugadores para testear esta mas que bien!
			System.out.println("[auto] van a Jugar " + cantJugadores + " jugadores:\n");
			for (Jugador j : Utiles.generarJugadores(cantJugadores)) {
				System.out.println("[auto] " + j.getName() + " (ID: " + j.getID() + "). " + "Guita: " + j.getDinero());
				tablero.AgregarJugador(j);
			}
/// HASTA AQUI Y LO QUE ESTA DENTRO DEL ELSE QUEDA EN EL RELEASE
		} else {
			// presentar jugadores manualmente
			for (Jugador j : Menus.menuJugadores()) {
				System.out.println(j.getName());
				tablero.AgregarJugador(j);
			}

		}
		return tablero;
	}
}
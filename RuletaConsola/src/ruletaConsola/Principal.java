
package ruletaConsola;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {

		// TODO Boolean DrawMeLikeOneOfYourFrenchGirls = false; // los cheats! los
		// cheats!

		// flag para presentar jugadores automaticamente
		Boolean auto_menuJugadores = true;

		Tablero tablero = new Tablero();

		if (auto_menuJugadores) {
			int cantJugadores = Utiles.generarIntRandom(2, 2);
			System.out.println("[auto] van a Jugar " + cantJugadores + " jugadores:\n");
			for (Jugador j : Utiles.generarJugadores(cantJugadores)) {
				System.out.println("[auto] " + j.getName() + " (ID: " + j.getID() + "). " + "Guita: " + j.getDinero());
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
				+ " participantes, que comiencen las apuestas!\n");

		/*
		 * crear menu para elegir jugador y que haga su apuesta mas un item extra que el
		 * crouiper o como se llame diga basta tipo: Menu de Apuestas 1- Austin Powers
		 * 2- Peperino Pomoro 3- No mas apuestas con un submenu para tipo de apuestas,
		 * etc.
		 * 
		 */
<<<<<<< HEAD
		
		
		//do-while (true) por ahora, despues vemos como salimos del juego. 
		//Este metodo podria estar en Tablero como Tablero.AbrirApuestas(), o algo asi
		
		do 
		{
			//Cada jugador hace una sola apuesta por ahora, la idea es 
			//hacer funcionar primero el systema de apuestas y pago a ganadores. 
			for(Jugador j : tablero.getJugadores())
			{
				
				while (Menus.menuOtraApuesta())
				{
					
					System.out.println("Jugador " + j.getName() + " apeste (typo no casual");
					Apuesta apuesta = Menus.menuApostar();
					j.Apostar(apuesta);
					
				}
								
=======

		// do-while (true) por ahora, despues vemos como salimos del juego.
		// Este metodo podria estar en Tablero como Tablero.AbrirApuestas(), o algo asi

		int MenuGeneral = 0;
		while (MenuGeneral != (tablero.getCantidadDeJugadores() + 1)) {
			MenuGeneral = Menus.MostrarMenuGeneral(tablero.getJugadores());
			if (MenuGeneral <= (tablero.getCantidadDeJugadores())) {
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

		do {
			// Cada jugador hace una sola apuesta por ahora, la idea es
			// hacer funcionar primero el systema de apuestas y pago a ganadores.
			for (Jugador j : tablero.getJugadores()) {
				System.out.println("Jugador " + j.getName() + " apeste (typo no casual");
				Apuesta apuesta = Menus.menuApostar();
				j.Apostar(apuesta);

>>>>>>> branch 'master' of https://github.com/jorgemestre/ruleta.git
			}

			// EL NUMERO GANADOR!!!
			// Casilla casilla = new Casilla(tablero.GirarRuleta());

			Casilla casilla = new Casilla(1); // FOR TESTING ONLY!! Siempre sale el UNO
			// EL NUMERO GANADOR PERO VISTO DESDE ABAJO

			//// TODO: Verificar el numero con las apuestas ganadoras.
			for (Jugador j : tablero.getJugadores()) {
				ArrayList<Apuesta> apuestas = j.getApuestas();
				if (!apuestas.isEmpty()) {
					for (Apuesta a : apuestas) {
						for (int num : a.getDetalle()) {
							if (num == casilla.getNumero()) {
								// Aqui se hacen todos los calculines para pagar las apuestas y esas cosa.
								float premio = a.getTipo().getGAnancia() * a.getCantidad();
								j.setDinero(j.getDinero() + premio);
<<<<<<< HEAD
								System.out.println("Hemos acertado " + a.getTipo().getNombre());
=======
								System.out.println("Le hemos pegado a uno aqui");
								System.out.println(j.getName() + " tiene ahora " + j.getDinero());
>>>>>>> branch 'master' of https://github.com/jorgemestre/ruleta.git
							}
						}
					}
				}
				System.out.println(j.getName() + " tiene ahora " + j.getDinero() );
				//limpia la lista de apuestas, ya esta listo para empezar a apostar de nuevo
				j.BorrarApuestas();
			}
		} while (true);
	}
}
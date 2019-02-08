package ruletaConsola;

import java.util.ArrayList;

public class Tablero {

	// public ArrayList<Apuesta> Apuestas;
	// Le saque el static, creo que no tiene sentido, si lo tiene lo volvemos a
	// poner
	private ArrayList<Jugador> Jugadores;

	/// Contructor del tablero

	public Tablero() {

		this.Jugadores = new ArrayList<Jugador>();

	}

	public int GirarRuleta() {

		return (int) (Math.random() * 37); // aleatorio del 0 al 36
	}

	public void AgregarJugador(Jugador jugador) {
		Jugadores.add(jugador);

	}

	// NO TIENE SENTIDO SI ESTA LA FUNCION DE ABAJO QUE DEVUELVE LOS JUGADORES (y
	// tiene nombre muy largo, jeje)
	// DEPRECATED

	/*
	 * public int getCantidadDeJugadores(){ // return Jugadores.size(); }
	 */

	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}

	public void pagarApuestas(Casilla casilla) {
		for (Jugador j : this.Jugadores) {
			ArrayList<Apuesta> apuestas = j.getApuestas();

			if (!apuestas.isEmpty()) {
				for (Apuesta a : apuestas) {
					for (int num : a.getDetalle()) {
						if (num == casilla.getNumero()) {

							// Aqui se hacen todos los calculines para pagar las apuestas y esas cosa.
							float premio = a.getTipo().getGAnancia() * a.getCantidad();
							j.setDinero(j.getDinero() + premio);

							//
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
	public static void abrirApuestas(Tablero tablero) {
		int MenuGeneral = 0;

		while (MenuGeneral != (tablero.getJugadores().size() + 1)) {
			MenuGeneral = Menus.MostrarMenuGeneral(tablero.getJugadores());

			if (MenuGeneral <= (tablero.getJugadores().size())) {
				Jugador player = (tablero.getJugadores()).get(MenuGeneral - 1);
				System.out.println("has elegido a " + player.getName() + ". Me parece bien.");
				Apuesta apuesta = Menus.menuApostar();
				player.Apostar(apuesta);

			} else {
				System.out.println("Salimos del menu general...");
			}

		}
	}

	/**
	 * @param auto_menuJugadores
	 * @return
	 */
	public static Tablero iniciarTablero(Boolean auto_menuJugadores) {
		Tablero tablero = new Tablero();

		if (auto_menuJugadores) {
			int cantJugadores = Utiles.generarIntRandom(2, 3);
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

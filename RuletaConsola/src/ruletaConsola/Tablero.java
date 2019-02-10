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

	public static void mostrarApuestas(Tablero t) {
		for (Jugador j : t.Jugadores) {
			System.out.println("------------------------------------");
			System.out.println(j.getName() + ", sus apuestas:");
			for (Apuesta a : j.getApuestas()) {
				System.out.println(
						"\t-> " + a.getCantidad() + " a " + a.getTipo().getNombre() + " (" + a.getDescripcion() + ")");

			}
		}
	}

	public static void abrirApuestas(Tablero tablero) {
		int MenuGeneral = 0;

		while (MenuGeneral != (tablero.getJugadores().size() + 1)) {
			MenuGeneral = Menus.MostrarMenuGeneral(tablero.getJugadores());

			if (MenuGeneral <= (tablero.getJugadores().size())) {
				// elige del arraylist de jugadores el del int que se selecciono en MenuGeneral
				Jugador player = (tablero.getJugadores()).get(MenuGeneral - 1);
				System.out.println("has elegido a " + player.getName());
				// va al menu apostar, devuelve una apuesta
				Apuesta apuesta = Menus.menuApostar();
				// lo agrega al arraylist de apuestas del jugador
				player.Apostar(apuesta);

			} else {
				System.out.println("Fin de apuestas.Se tira la bolita...");
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
		} else {
			// presentar jugadores manualmente
			for (Jugador j : Menus.menuJugadores()) {
				System.out.println(j.getName());
				tablero.AgregarJugador(j);
			}

		}
		return tablero;
	}

	public static int[] getSecciones(String tipo, String seccion) {
		switch (tipo) {
		case "parimpar": case "par": case "impar":

			switch (seccion) {
			case "par":
				return new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36 };
			case "impar":
				return new int[] { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35 };
			}
		case "menormayor":
			switch (seccion) {
			case "menor":
				return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
			case "mayor":
				return new int[] { 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };
			}
		case "color":
			switch (seccion) {
			case "rojo":
				return new int[] { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
			case "negro":
				return new int[] { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };
			}

		case "columna":
			switch (seccion) {
			case "1":
				return new int[] { 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34 };
			case "2":
				return new int[] { 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35 };
			case "3":
				return new int[] { 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36 };
			}

		case "fila":
			switch (seccion) {
			case "1":
				return new int[] { 1, 2, 3, };
			case "2":
				return new int[] { 4, 5, 6 };
			case "3":
				return new int[] { 7, 8, 9 };
			case "4":
				return new int[] { 10, 11, 12 };
			case "5":
				return new int[] { 13, 14, 15, };
			case "6":
				return new int[] { 16, 17, 18 };
			case "7":
				return new int[] { 19, 20, 21 };
			case "8":
				return new int[] { 22, 23, 24 };
			case "9":
				return new int[] { 25, 26, 27 };
			case "10":
				return new int[] { 28, 29, 30 };
			case "11":
				return new int[] { 31, 32, 33 };
			case "12":
				return new int[] { 34, 35, 36 };
			}
		case "docena":
			switch (seccion) {
			case "1":
				return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
			case "2":
				return new int[] { 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24 };
			case "3":
				return new int[] { 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 };

			}
		}
		return new int[] {};
	}
}

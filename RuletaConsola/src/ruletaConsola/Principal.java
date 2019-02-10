package ruletaConsola;

public class Principal {

	public static void main(String[] args) {
		// flag para presentar jugadores automaticamente
		// SE SUPONE QUE TODO ESTO SE VA EN UNA VERSION RELEASE
		Boolean auto_menuJugadores = true;

		Tablero tablero = Tablero.iniciarTablero(auto_menuJugadores);

		// Comienzan las apuestas.
		System.out.println("\nCROUPIER: mesa cerrada con " + tablero.getJugadores().size()
				+ " participantes, que comiencen las apuestas!\n");

		do {

			// aqui empiezan y finalizan las rondas de apuestas
			Tablero.abrirApuestas(tablero);

			Tablero.mostrarApuestas(tablero);

			Casilla casilla = new Casilla(tablero.GirarRuleta());
			System.out
					.println("la bolita ha caido en la casilla: " + casilla.getNomColor() + " " + casilla.getNumero());

			//// TODO: Verificar el numero con las apuestas ganadoras.
			tablero.pagarApuestas(casilla);

		} while (true);
	}
}

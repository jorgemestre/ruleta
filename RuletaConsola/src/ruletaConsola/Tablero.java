package ruletaConsola;

import java.util.ArrayList;

public class Tablero {

	//public ArrayList<Apuesta> Apuestas;
	public ArrayList<Jugador> Jugadores;

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

}

package ruletaConsola;

import java.util.ArrayList;

public class Tablero {

	//public ArrayList<Apuesta> Apuestas;
	// Le saque el static, creo que no tiene sentido, si lo tiene lo volvemos a poner
	private static ArrayList<Jugador> Jugadores;

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
	
	
	//NO TIENE SENTIDO SI ESTA LA FUNCION DE ABAJO QUE DEVUELVE LOS JUGADORES (y tiene nombre muy largo, jeje)
	//DEPRECATED
	
	/*public int getCantidadDeJugadores(){
	//	return Jugadores.size();
	}*/

	public ArrayList<Jugador> getJugadores() {
		return Jugadores;
	}
}

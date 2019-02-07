package ruletaConsola;

import java.util.ArrayList;

public class Tablero {

	//public ArrayList<Apuesta> Apuestas;
	// Le saque el static, creo que no tiene sentido, si lo tiene lo volvemos a poner
	private  ArrayList<Jugador> Jugadores;

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
	
	public void pagarApuestas(Casilla casilla)
	{
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
	
	
}

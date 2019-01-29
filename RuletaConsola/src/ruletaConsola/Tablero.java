package ruletaConsola;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

public class Tablero {
	
	public List<Apuesta> Apuestas;
	public List<Jugador> Jugadores;
	
	///Contructor del tablero
	
	
	public Tablero ()
	{
		;
		Jugadores = new ArrayList<Jugador> ();
		
	}
	
	public int GirarRuleta()
	{
		
		return  (int)(Math.random() * 37 ); // aleatorio del 0 al 36
		
	}
	
	public void AgregarJugador(Jugador jugador)
	{
		Jugadores.add(jugador);
		
	}
	
=======
public class Tablero {
>>>>>>> refs/remotes/origin/master

}

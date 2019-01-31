
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
		
		
		//do-while (true) por ahora, despues vemos como salimos del juego. 
		//Este metodo podria estar en Tablero como Tablero.AbrirApuestas(), o algo asi
		
		do 
		{
			//Cada jugador hace una sola apuesta por ahora, la idea es 
			//hacer funcionar primero el systema de apuestas y pago a ganadores. 
			for(Jugador j : tablero.getJugadores())
			{
				System.out.println("Jugador " + j.getName() + " apeste (typo no casual");
				Apuesta apuesta = Menus.menuApostar();
				j.Apostar(apuesta);
				
			}
			
			//EL NUMERO GANADOR!!!
			int numeroGanador = tablero.GirarRuleta(); 
			numeroGanador = 1; //FOR TESTING ONLY!! Siempre sale el UNO
			//EL NUMERO GANADOR PERO VISTO DESDE ABAJO
			
			
			////TODO: Verificar el numero con las apuestas ganadoras. 
			for (Jugador j : tablero.getJugadores())
			{
				ArrayList<Apuesta> apuestas = j.getApuestas(); 
				if (!apuestas.isEmpty())
				{
					for (Apuesta a : apuestas)
					{
						for (int num : a.getDetalle())
						{
							if (num == numeroGanador)
							{
								//Aqui se hacen todos los calculines para pagar las apuestas y esas cosa. 
								float premio = a.getTipo().getGAnancia() * a.getCantidad(); 
								j.setDinero(j.getDinero() + premio);
								System.out.println("Le hemos pegado a uno aqui");
								System.out.println(j.getName() + " tiene ahora " + j.getDinero() );
								
							}
						}
						
					}
					
				}
				
			}
			
		}
		while(true);
	}
}
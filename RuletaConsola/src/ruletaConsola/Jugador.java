package ruletaConsola;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	public String Name;
	public float Dinero;
	private List<Apuesta> Apuestas;
	
	Jugador(String name)
	{
		Name = name;
		Apuestas = new ArrayList<Apuesta>();
	}
	
	public void Apostar(Apuesta apuesta)
	{
		if (apuesta.Cantidad <= this.Dinero)
		{
			this.Dinero -= apuesta.Cantidad;
			this.Apuestas.add(apuesta);
		}
		else 
		{
			//Un mensaje de error supongo
			System.out.println("No hay dinero suficiente");
		}
		
	}
	

}

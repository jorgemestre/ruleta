package ruletaConsola;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	
	private String Name;
	private float Dinero;
	private List<Apuesta> Apuestas;
	
	Jugador(String name)
	{
		this.Name = name;
		this.Apuestas = new ArrayList<Apuesta>();
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public float getDinero() {
		return Dinero;
	}

	public void setDinero(float dinero) {
		Dinero = dinero;
	}
}
	

package ruletaConsola;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
	private static int contadorIDs = 0;
	private int ID;
	private String Name;
	private float Dinero;
	private List<Apuesta> Apuestas;

	Jugador(String name) {
		this.Name = name;
		this.Apuestas = new ArrayList<Apuesta>();
	}

	public void Apostar(Apuesta apuesta) {
		if (apuesta.getCantidad() <= this.Dinero) {
			this.Dinero -= apuesta.getCantidad();
			this.Apuestas.add(apuesta);
		} else {
			// Un mensaje de error supongo
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
	
	public static int getContadorIDs() {
		return contadorIDs;
	}

	public static void aumentarID() {
		contadorIDs = contadorIDs + 1;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}

package ruletaConsola;

import java.util.ArrayList;

public class Jugador {

	private static int contadorIDs = 0;
	private int ID;
	private String Name;
	private float Dinero;
	private ArrayList<Apuesta> Apuestas;

	public Jugador(String name) {
		this.Name = name;
		this.Apuestas = new ArrayList<Apuesta>();
		aumentarID();
		this.setID(Jugador.getContadorIDs());
	}

	Jugador(String name, float dinero) {

		this(name);
		this.Dinero = dinero;

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

	public void BorrarApuestas() {
		this.Apuestas.clear();
	}

	// GETTERS Y SETTERS
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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
		contadorIDs++;
	}

	public ArrayList<Apuesta> getApuestas() {
		return Apuestas;
	}

}

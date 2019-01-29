package ruletaConsola;

<<<<<<< HEAD
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
	

=======
public class Jugador {
	private int ID;
	private String nom;
	private double totalCash;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(double totalCash) {
		this.totalCash = totalCash;
	}
>>>>>>> refs/remotes/origin/master
}

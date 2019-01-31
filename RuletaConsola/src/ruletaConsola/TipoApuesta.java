package ruletaConsola;

// import java.util.ArrayList;

public class TipoApuesta {
	
	private String Nombre; 
	private int Ganancia;
	
	
	//contructor parametrizado
	TipoApuesta(String nombre)
	{
		this.Nombre = nombre; 
		setGanancia();
	}

	
	private void setGanancia()
	{
		
		//Hay que completar con todos los tipos de apuesta, 
		//por ahora solo unos pocos para probar
		
		switch (this.Nombre)
		{
		case "pleno": this.Ganancia= 36; 
			break;
		case "color": this.Ganancia = 2; 
			break;
		case "docena": this.Ganancia = 3;
			break;
		default: this.Ganancia = 0 ; 
		
		}
		
	}
	
	
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getGAnancia() {
		return Ganancia;
	}
	
	
	

}

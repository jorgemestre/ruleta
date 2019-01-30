package ruletaConsola;

public class Apuesta {
	
	private String Tipo;
	private String Detalle;
	private float Cantidad; 
	
	
	
	Apuesta (String tipo, String detalle, float cantidad)
	{
		this.Tipo = tipo; 
		this.Detalle = detalle; 
		this.Cantidad = cantidad; 
		
	}
	
	
	
	
	
	
	//Getters and settere
	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public float getCantidad() {
		return Cantidad;
	}

	public void setCantidad(float cantidad) {
		Cantidad = cantidad;
	}
}

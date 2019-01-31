package ruletaConsola;

public class Apuesta {
	private TipoApuesta Tipo;
	private int[] Detalle;
	private float Cantidad; 
	
	
	
	Apuesta (TipoApuesta tipo, int[] detalle, float cantidad)
	{
		this.Tipo = tipo; 
		this.Detalle = detalle; 
		this.Cantidad = cantidad; 
		
	}
	

	//Getters and settere
	public TipoApuesta getTipo() {
		return Tipo;
	}

	public void setTipo(TipoApuesta tipo) {
		Tipo = tipo;
	}

	public int[] getDetalle() {
		return Detalle;
	}

	public void setDetalle(int[] detalle) {
		Detalle = detalle;
	}

	public float getCantidad() {
		return Cantidad;
	}

	public void setCantidad(float cantidad) {
		Cantidad = cantidad;
	}

}

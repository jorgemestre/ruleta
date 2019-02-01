package ruletaConsola;

public class Casilla {
	
	private int Numero; // SI es CERO, todas las demas propiedades son -1
	private int Color;  //cero es rojo, uno en negro
	private int Paridad; //cero es par, uno es impar
	private int Mayoria; // cero es menor, uno es mayor; 
	private int Docena; 
	private int Columna; 
	private int Fila;
	
	
	

	Casilla(int numero) {
		
		Numero = numero;
		switch (numero)
		{
			case 0: Color = -1; break; 
			
			case 1: case 3: case 5: case 7: case 9: case 12:
			case 14: case 16: case 18: case 19: case 21: case 23:
			case 25: case 27: case 30: case 32: case 34: case 36:
				Color = 0; 
			case 2: case 4: case 6: case 8: case 10: case 11:
			case 13: case 15: case 17: case 20: case 22: case 24:
			case 26: case 28: case 29: case 31: case 33: case 35:
				Color = 1; 
			default : Color =  -1; 
		}

		Paridad = (numero != 0)? numero % 2: -1;
		Mayoria = (numero != 0)? numero / 18: -1;
		Docena = (numero != 0)? numero / 12: -1;
		Columna = (numero != 0)? ((numero - 1) % 3) + 1: -1;
		Fila = (numero != 0)? (numero / 3) + 1: -1;;
	}
	
	public int getNumero() {
		return Numero;
	}
	public int getColor() {
		return Color;
	}
	public int getParidad() {
		return Paridad;
	}
	public int getMayoria() {
		return Mayoria;
	}
	public int getDocena() {
		return Docena;
	}
	public int getColumna() {
		return Columna;
	}
	public int getFila() {
		return Fila;
	} 
	
	
	
}

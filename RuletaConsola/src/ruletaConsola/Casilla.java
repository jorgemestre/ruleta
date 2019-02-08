package ruletaConsola;

public class Casilla {

	private int Numero; // SI es CERO, todas las demas propiedades son -1
	private int Color; // cero es rojo, uno en negro
	private int Paridad; // cero es par, uno es impar
	private int Mayoria; // cero es menor, uno es mayor;
	private int Docena;
	private int Columna;
	private int Fila;
	private int[] rojo = new int[] { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
	private int[] negro = new int[] { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35}; 

	Casilla(int numero) {
		Numero = numero;
		Color = getNumColor(numero);
		Paridad = (numero != 0) ? numero % 2 : -1;
		Mayoria = (numero != 0) ? numero / 18 : -1;
		Docena = (numero != 0) ? numero / 12 : -1;
		Columna = (numero != 0) ? ((numero - 1) % 3) + 1 : -1;
		Fila = (numero != 0) ? (numero / 3) + 1 : -1;
		;
	}

	public int getNumero() {
		return Numero;
	}

	public int getColor() {
		return Color;
	}

	public String getNomColor() {

		if (Utiles.ArrayContains(this.rojo, this.Numero)) {
			return "rojo";
		}
		else if (Utiles.ArrayContains(this.negro, this.Numero)) {
			return "negro";
		}
		else if (this.Numero == 0) {
			return "verde";
		}
		else
			{return "sin color, ERROR";}
		
	}
	
	public int getNumColor(int nro) {
		if (Utiles.ArrayContains(this.rojo, nro)) {
			return 0;
		}
		else if (Utiles.ArrayContains(this.negro, nro)) {
			return 1;
		}
		else if (nro == 0) {
			return -1;
		}
		else
			{return -1;}
		
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

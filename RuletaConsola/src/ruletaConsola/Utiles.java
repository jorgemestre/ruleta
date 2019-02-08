package ruletaConsola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



public class Utiles {
	public static int generarIntRandom(int low,int high) {
		Random cj = new Random();
		return cj.nextInt((high+1) - low) + low;
	}
	

	public static ArrayList<Jugador> generarJugadores(int cantJugadores){
		ArrayList<Jugador> res = new ArrayList<Jugador>();
		String nomsS = "Austin Powers,Paolo Conte,Peperino Pomoro,Mazinger Z,Mr. Pinedo";
		String[] noms = nomsS.split(",");
		for (int i=0;i < cantJugadores;i++){
			Jugador j = new Jugador(noms[i], generarIntRandom(50, 2000));
			res.add(j);	
		}
				
		return res;
	}
	public static boolean ArrayContains(final int[] array, final int key) {  
	     Arrays.sort(array);  
	     return Arrays.binarySearch(array, key) >= 0;  
	}  
}


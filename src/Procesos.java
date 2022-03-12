import java.util.Iterator;
import java.util.Scanner;

public class Procesos {
	public static void main(String[] args) {
//Pedir cuantos procesos
		Scanner in = new Scanner(System.in);
		System.out.println("Cuanto procesos quieres usar:");
		int procesos = in.nextInt();
		int numero = 0;
		int cont = 0;
		int y = 0;
		int x = procesos;
		int[] tllegadas = new int[procesos];
		int[] t = new int[procesos];
		for (int i = 0; i < procesos; i++) {
			System.out.println("Proceso " + (i + 1) + " Instante de llagada : ");
			tllegadas[i] = in.nextInt();
			System.out.println("Proceso " + (i + 1) + " Tiempo : ");
			t[i] = in.nextInt();
		}
		for (int i = 0; i < t.length; i++) {
			numero += t[i];
		}
		System.out.println("Numero de t's: " + numero);

		while (y < procesos) {
			if (tllegadas[y] > 0) {
				for (int i = 0; i < tllegadas[y]; i++) {
					System.out.print("_");
				}
			}
			//
			for (int i = 0; i < t[y]; i++) {
				System.err.print("X");
			}
			for (int i = 0; i < (numero - t[y]); i++) {
				System.out.print("_");
			}
			System.out.println("");
			y++;
			cont++;
		}
	}
}

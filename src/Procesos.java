import java.util.Iterator;
import java.util.Scanner;

public class Procesos {
	public static void main(String[] args) {
//Pedir cuantos procesos
		Scanner in = new Scanner(System.in);
		System.out.println("Cuanto procesos quieres usar:");
		int procesos = in.nextInt();
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
			System.out.println("*");
		}
	}
}

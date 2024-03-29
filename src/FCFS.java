
import java.util.*;

public class FCFS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero de procesos ");
		int n = sc.nextInt();
		int nprocesos[] = new int[n];
		int tllegadas[] = new int[n];
		int t[] = new int[n];
		int fin[] = new int[n];
		int Tmas[] = new int[n];
		int E[] = new int[n];
		int y = 0;
		int temp;
		int cont = 0;
		float avgwt = 0;
		float avgta = 0;
		int numero = 0;

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " Tiempo de llegada: ");
			tllegadas[i] = sc.nextInt();
			System.out.println((i + 1) + " Tiempo");
			t[i] = sc.nextInt();
			nprocesos[i] = i + 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - (i + 1); j++) {
				if (tllegadas[j] > tllegadas[j + 1]) {
					temp = tllegadas[j];
					tllegadas[j] = tllegadas[j + 1];
					tllegadas[j + 1] = temp;
					temp = t[j];
					t[j] = t[j + 1];
					t[j + 1] = temp;
					temp = nprocesos[j];
					nprocesos[j] = nprocesos[j + 1];
					nprocesos[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				fin[i] = tllegadas[i] + t[i];
			} else {
				if (tllegadas[i] > fin[i - 1]) {
					fin[i] = tllegadas[i] + t[i];
				} else
					fin[i] = fin[i - 1] + t[i];
			}
			Tmas[i] = fin[i] - tllegadas[i];
			E[i] = Tmas[i] - t[i];
			avgwt += E[i];
			avgta += Tmas[i];
		}

		System.out.println("-----------------------------------------------------------");
		for (int i = 0; i < t.length; i++) {
			numero += t[i];
		}
		while (y < n) {
			if (tllegadas[y] > 0) {
				for (int i = 0; i < tllegadas[y]; i++) {
					System.out.print(" _ ");
					cont++;
				}
			}
			for (int i = 0; i < E[y]; i++) {
				System.out.print(" 0 ");
			}
			for (int i = 0; i < t[y]; i++) {
				System.out.print(" X ");
				cont++;
			}
			for (int i = 0; i < (numero - t[y]); i++) {
				System.out.print(" _ ");
			}
			System.out.println("");
			y++;
		}
		System.out.println("-----------------------------------------------------------");
	}

}
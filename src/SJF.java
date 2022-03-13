import java.util.*;

public class SJF {
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
		int f[] = new int[n];
		int y = 0;
		int numero = 0;
		int cont = 0;
		int st = 0, tot = 0;

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " Tiempo de llegada: ");
			tllegadas[i] = sc.nextInt();
			System.out.println((i + 1) + " Tiempo");
			t[i] = sc.nextInt();
			nprocesos[i] = i + 1;
			f[i] = 0;
		}
		boolean a = true;
		while (true) {
			int c = n, min = 999;
			if (tot == n)
				break;
			for (int i = 0; i < n; i++) {
				if ((tllegadas[i] <= st) && (f[i] == 0) && (t[i] < min)) {
					min = t[i];
					c = i;
				}
			}
			if (c == n)
				st++;
			else {
				fin[c] = st + t[c];
				st += t[c];
				Tmas[c] = fin[c] - tllegadas[c];
				E[c] = Tmas[c] - t[c];
				f[c] = 1;
				tot++;
			}
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
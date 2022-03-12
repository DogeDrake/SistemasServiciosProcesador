
import java.util.*;

public class FCFS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce numero de procesos ");
		int n = sc.nextInt();
		int nprocesos[] = new int[n]; // process ids
		int tllegadas[] = new int[n]; // arrival times
		int t[] = new int[n]; // burst or execution times
		int fin[] = new int[n]; // completion times
		int Tmas[] = new int[n]; // turn around times
		int E[] = new int[n]; // waiting times
		int temp;
		float avgwt = 0, avgta = 0;

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + " Tiempo de llegada: ");
			tllegadas[i] = sc.nextInt();
			System.out.println((i + 1) + " Tiempo");
			t[i] = sc.nextInt();
			nprocesos[i] = i + 1;
		}

//sorting according to arrival times
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
// finding completion times
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				fin[i] = tllegadas[i] + t[i];
			} else {
				if (tllegadas[i] > fin[i - 1]) {
					fin[i] = tllegadas[i] + t[i];
				} else
					fin[i] = fin[i - 1] + t[i];
			}
			Tmas[i] = fin[i] - tllegadas[i]; // turnaround time= completion time- arrival time
			E[i] = Tmas[i] - t[i]; // waiting time= turnaround time- burst time
			avgwt += E[i]; // total waiting time
			avgta += Tmas[i]; // total turnaround time
		}

////////////////////////////////////////////////////////////////////////////////////////////////////////		
		System.out.println("\npid  arrival  brust  complete turn waiting");
		for (int i = 0; i < n; i++) {
			System.out.println(
					nprocesos[i] + "  \t " + tllegadas[i] + "\t" + t[i] + "\t" + fin[i] + "\t" + Tmas[i] + "\t" + E[i]);
		}
		sc.close();
		System.out.println("\naverage waiting time: " + (avgwt / n)); // printing average waiting time.
		System.out.println("average turnaround time:" + (avgta / n)); // printing average turnaround time.
	}
}
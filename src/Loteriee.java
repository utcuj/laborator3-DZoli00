import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Loteriee {

	private int numereCastigatoare[] = new int[6];
	private int numereAlese[] = new int[6];
	
	
	private int[] nrbilet() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Introduceti numerele alese:");

		for( int i = 0 ; i < numereAlese.length; ++i) {
		 int nrExtras = in.nextInt();
		}
		
		Arrays.sort(numereAlese);
		
		in.close();
		return numereAlese;
		
	}
	
	private int[] extragere() {
		
		Random random = new Random();
		
		System.out.println("Numerele extrase sunt:");
		for(int i = 0 ; i < numereCastigatoare.length ; ++i) {
			int numarExtras = 1 + random.nextInt(49);// folosim +1 ca numarul sa nu fie = 0
			verificare_dublicate: // verificam daca numarul generat random nu exista deja in array
			for( int j = 0 ; j < i ; ++j) {
				if(numereCastigatoare[j] == numarExtras) {
					numarExtras = 1 + random.nextInt(49);
					continue verificare_dublicate;
				}
			}
			numereCastigatoare[i] = numarExtras;	

		}
		Arrays.sort(numereCastigatoare);
		
		for(int i = 0 ; i < numereCastigatoare.length; ++i) {
			System.out.println(numereCastigatoare[i]);
		}
		return numereCastigatoare;
	}	
	
	
	public static void main(String[] args) {
		Loteriee loterie = new Loteriee();
		long impachetare;
		int numereAlese[] = loterie.nrbilet();
		
		int numereCastigatoare[] = loterie.extragere();
		Bilet biletulMeu = new Bilet(numereAlese);
		
		int count = 0 ;
		for(int i =0; i < numereCastigatoare.length; i++) {
			int numereDePeBilet[] = biletulMeu.getNumere();
			for(int j = 0 ; j < 6; j++) {
				if(numereDePeBilet[j] == numereCastigatoare[i]) {
					count ++ ;
				}
			}
		}
		
		if( count == 6) {
			System.out.println("Ai castigat!");
		}else {
			System.out.println("Mai incearca!");
		}
		
	}
	

}

package raccoltaClassi;
import java.io.*;

public class Gestione {
	public static void main(String argv[]){
		int num = 0;
		int num2= 0;
		String leggi= null;
		InputStreamReader input=new InputStreamReader(System.in);
		BufferedReader tastiera= new BufferedReader(input);
		
		try {
			System.out.println("Inserisci primo numero primo per codifica RSA: (ex. 3, 7):");
			String leggiNumero = tastiera.readLine();
			num = Integer.valueOf(leggiNumero).intValue();
		}
		catch(Exception Menu) {
			System.out.println("Dato non valido!!");
			
		}try {
			System.out.println("Inserisci primo numero primo per codifica RSA: (ex. 3, 7):");
			String leggiNumero = tastiera.readLine();
			num2 = Integer.valueOf(leggiNumero).intValue();
		}
		catch(Exception Menu) {
			System.out.println("Dato non valido!!");
			
		}
		RSA r=new RSA(num,num2);
		
		try {
			String leggiNumero = tastiera.readLine();
			leggi= String.valueOf(leggiNumero);
		}
		catch(Exception Menu) {
			System.out.println("Dato non valido!!");
			
		}
		System.out.println("\n");
		System.out.println("****RISULTATO****");
		
		int[] array= r.Codifica(leggi);
		System.out.println("Testo codificato:");
		for(int i = 0;i<array.length;i++) {
			
			System.out.print(array[i]+",");
		}
		System.out.println("\n");
		String array1= (String) r.Decodifica(array);
		System.out.println("Testo decodificato:");
		System.out.print(array1);
		
		
	}

}

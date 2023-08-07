package raccoltaClassi;
import java.io.*;
import java.math.BigInteger;

public class RSA {
	
	public BigInteger n;
	private int z;
	private int p;
	private int q;
	public int priv;
	public int pub;
	NumPrimi nmp= new NumPrimi();
	
	
	public RSA(int p,int q) {
		Rsa(p,q);
	}
	
	private void Rsa(int p,int q) {
		this.p=p;
		this.q=q;
		
		this.n=BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
		this.z=(p-1)*(q-1);
		
		this.priv=nmp.privato(z);
		BigInteger zBI = BigInteger.valueOf(z);
		BigInteger privBI = BigInteger.valueOf(priv);
		BigInteger restoBI = BigInteger.valueOf(resto());
		
		BigInteger result = privBI.multiply(zBI.add(restoBI));
		this.pub=result.divide(privBI).intValue();
		
		System.out.println("Chiave pubblica: ("+n+","+pub+")"+"\n"+"Chiave privata: ("+n+","+priv+")");
		
		
	}
	
	private int resto() {
		int n=0;
		n=priv-(z%priv);
		return n;
	}
	
	public int[] Codifica(String f) {
		char[] array=f.toCharArray();
		int[] fnew = new int[array.length];
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVZ1234567890.,;: ".toCharArray();
		int[] numbers = new int[alphabet.length];
		
		try{
			for (int i = 0; i < alphabet.length; i++) {
		    numbers[i] = i ;
		}
		}catch(Exception E) {
			System.out.println(E.getMessage());
		}
		

		for(int i = 0;i< array.length;i++) {
			for(int y=0;y<alphabet.length;y++) {
				
				if (array[i]==alphabet[y]) {
					BigInteger yBI = BigInteger.valueOf(y);
					BigInteger pubBI = BigInteger.valueOf(pub);
					BigInteger result = yBI.pow(pub);
					BigInteger c = result.mod(n);
					fnew[i]=c.intValue();
				}
			}
		}
		return fnew;
	}
	
	public String Decodifica(int[] array) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVZ1234567890.,;: ".toCharArray();
		int[] numbers = new int[alphabet.length];
		char[] arr= new char[array.length];
		StringBuilder sb = new StringBuilder();
		
		try{
			for (int i = 0; i < alphabet.length; i++) {
		    numbers[i] = i ;
		}
		}catch(Exception E) {
			System.out.println(E.getMessage());
		}
		
		for(int i=0;i<array.length;i++) {
			BigInteger d= BigInteger.valueOf(array[i]).pow(priv);
			BigInteger m=d.mod(n);
			for (int y=0;y<numbers.length;y++) {
				if(m.intValue()==numbers[y]) {
					arr[i]=alphabet[y];
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}


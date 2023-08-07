package raccoltaClassi;

public class NumPrimi {
	
	public boolean IfPrimi(int n) {
		int f=0;
		for(int i=1;i<=n;i++){
			if((n%i)==0) {
				f=f+1;
			}
		}
		if(f==2) {
			return true;
		}else {
			return false;
		}
	}
	
	public int privato(int n) {
		boolean t=false;
		for(int i=3;i<=n;i++){
			if(IfPrimi(i) && n%i!=0 && t==false) {
				t=true;
				return i;
			}
		}
		return 0;
	}


	
}

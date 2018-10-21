package Model;

public class Vecteur {
	
	private long[] x;	
	private double norme;
	private long[] matProvisoire;
	
	/***************** GET ************************/
	
	public long[]GetX(){
		return x;
	}
	
	public double GetNorme(){
		return norme;
	}
	
	public long[] GetMatProvisoire(){
		return matProvisoire;
	}
	
	/***************** SET ************************/
	
	public void SetX(long[] x){
		this.x = x;
	}
	
	public void SetNorme(double norme){
		this.norme = norme;
	}
	
	public void SetMatProvisoire(long[] matProvisoire){
		this.matProvisoire = matProvisoire;
	}
	
}

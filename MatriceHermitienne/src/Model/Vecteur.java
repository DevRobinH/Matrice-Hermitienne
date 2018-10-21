package Model;

import java.util.Arrays;

/**
 * Gestion des vecteurs
 * @author QMS,Flo M, Multirob
 * @version 1.0
 */
public class Vecteur {
	
	/** les valeurs du vecteur*/
	private double[] x;	
	/**La norme du vecteur*/
	private double norme;
	
	/**
	 * Création du vecteur quelconque en début d'algorithme
	 * en lui attribuant des valeurs
	 * @param x Les valeurs du vecteur
	 */
	public Vecteur(double[] x) {
		super();
		this.x = x;
		this.norme = this.calculNorme();
	}
	
	/**
	 * Création du vecteur
	 * @param x Les valeurs du vecteur
	 * @param norme la norme du vecteur
	 */
	public Vecteur(double[] x, double norme) {
		super();
		this.x = x;
		this.norme = norme;
	}

	
	/**
	 * Calcul de la norme du vecteur
	 * @return norme la norme du vecteur calculé
	 */
	public double calculNorme() {
		// norme du vecteur à retourner
		double norme = 0;
		
		// Cas vecteur taille 2
		if( this.getX().length == 2) {
			norme = Math.sqrt(Math.pow(this.getX()[0], 2) 
					+ Math.pow(this.getX()[1], 2));
		// Vecteur de taille 3
		} else if (this.getX().length == 3) {
			norme = Math.sqrt(Math.pow(this.getX()[0], 2) 
					+ Math.pow(this.getX()[1], 2)
					+ Math.pow(this.getX()[2], 2));
	    }
		
		return norme;
	}
	/**
	 * @return the x
	 */
	public double[] getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double[] x) {
		this.x = x;
	}

	/**
	 * @return the norme
	 */
	public double getNorme() {
		return norme;
	}

	/**
	 * @param norme the norme to set
	 */
	public void setNorme(double norme) {
		this.norme = norme;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vecteur [x=" + Arrays.toString(x) + ", norme=" + norme + "]";
	}
	
	
}

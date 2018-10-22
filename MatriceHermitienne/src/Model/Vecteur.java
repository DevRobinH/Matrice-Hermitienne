package Model;

import java.util.Arrays;

/**
 * Gestion des vecteurs
 * @author QMS,Flo M, Multirob
 * @version 1.0
 */
public class Vecteur {
	
	/** les valeurs du vecteur*/
	private Complexe[] x;	
	/**La norme du vecteur*/
	private double norme;
	
	/**
	 * Création du vecteur quelconque en début d'algorithme
	 * en lui attribuant des valeurs
	 * @param x Les valeurs du vecteur
	 */
	public Vecteur(Complexe[] x) {
		super();
		this.x = x;
		this.norme = this.calculNorme();
	}
	
	/**
	 * Création du vecteur
	 * @param x Les valeurs du vecteur
	 * @param norme la norme du vecteur
	 */
	public Vecteur(Complexe[] x, double norme) {
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
			norme = Math.sqrt(Math.pow(this.getX()[0].module(), 2) 
					+ Math.pow(this.getX()[1].module(), 2));
		// Vecteur de taille 3
		} else if (this.getX().length == 3) {
			norme = Math.sqrt(Math.pow(this.getX()[0].module(), 2) 
					+ Math.pow(this.getX()[1].module(), 2)
					+ Math.pow(this.getX()[2].module(), 2));
	    }
		
		return norme;
	}
	
	/**
	 * Division des valeurs du vecteur par un nombre
	 * @param valeur nombre servant à effectuer la division
	 * @return le vecteur avec les nouvelles valeurs
	 */
	public Vecteur divise(double valeur) {
		Complexe[] valeursVecteur = {new Complexe(0,0),new Complexe(0,0),new Complexe(0,0)};
		for(int i = 0; i < x.length; i++) {
			valeursVecteur[i] = this.getX()[i].multiplication(1/valeur);  
		}
		return new Vecteur(valeursVecteur);
	}
	/**
	 * @return the x
	 */
	public Complexe[] getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Complexe[] x) {
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
		StringBuilder chaine = new StringBuilder("[");
		
		for(int i =0; i<x.length; i++) {
			chaine.append(getX()[i].toString() + " ");
		}
		chaine.append("]");
		return chaine.toString();
	}


	
	
}

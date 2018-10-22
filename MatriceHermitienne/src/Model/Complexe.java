/**
 * 
 */
package Model;

/**
 * Gestion des nombres complexe en java
 * @author QMS,Flo M, Multirob
 * @version 1.0
 */
public class Complexe {

	/**Partie réel du nombre complexe*/
	private double reel;   
	/**Partie imaginaire du nombre complexe*/
	private double imaginaire;   

	
	/**
	 * Création d'un nombre complexe en lui attribuant une partie réel et 
	 * imaginaire
	 * @param real
	 * @param imag
	 */
	public Complexe(double real, double imag) {
		this.reel = real;
		this.imaginaire = imag;
	}

	
	public String toString() {
		// reel
		if (this.imaginaire == 0) 
			return this.reel + "";
		// imaginaire
		if (this.reel == 0) 
			return this.imaginaire + "i";
		// imaginaire négatif
		if (this.imaginaire <  0) 
			return this.reel + " - " + (-this.imaginaire) + "i";
		
		return this.reel + " + " + this.imaginaire + "i";
	}

	
	/**
	 * Calcul du module du nombre complexe
	 * @return le module du nombre complexe
	 */
	public double module() {
		return Math.hypot(reel, imaginaire);
	}

	
	/**
	 * Calcul de l'argument du nombre complexee
	 * @return l'argument du nombre complexe
	 */
	public double argument() {
		return Math.atan2(imaginaire, reel);
	}

	
	/**
	 * Addition de deux nombre complexe
	 * @param b second membre de l'addition
	 * @return le resultat de l'addition
	 */
	public Complexe addition(Complexe b) {
		double reel = this.reel + b.reel;
		double imag = this.imaginaire + b.imaginaire;
		return new Complexe(reel, imag);
	}

	
	/**
	 * Soustraction de deux nombre complexe
	 * @param b second membre de la soustraction
	 * @return le resultat de la soustraction
	 */
	public Complexe soustraction(Complexe b) {
		double reel = this.reel - b.reel;
		double imag = this.imaginaire - b.imaginaire;
		return new Complexe(reel, imag);
	}

	
	/**
	 * Multiplication de deux nombre complexe
	 * @param b second membre de la multiplication
	 * @return le resultat de la multiplication
	 */
	public Complexe multiplication(Complexe b) {
		double reel = this.reel * b.reel - this.imaginaire * b.imaginaire;
		double imag =this.reel * b.imaginaire + this.imaginaire * b.reel;
		return new Complexe(reel, imag);
	}

	
	/**
	 * Multiplication d'un nombre complexe par une valeur
	 * @param alpha valeur par laquelle on souhaite multiplier le nombre complexe
	 * @return le resultat de la multiplication
	 */
	public Complexe multiplication(double alpha) {
		return new Complexe(alpha * this.reel, alpha * this.imaginaire);
	}

	
	/**
	 * Determination du conjugué du nombre complexe
	 * @return
	 */
	public Complexe conjugue() {
		return new Complexe(this.reel, -this.imaginaire);
	}

	/**
	 * Calcul de la réciproque du nombre complexe
	 * @return la réciproque du nombre complexe
	 */
	public Complexe reciprocal() {
		double scale = reel*reel + imaginaire*imaginaire;
		return new Complexe(reel / scale, -imaginaire / scale);
	}

	/**
     * Division de deux nombre complexe
	 * @param b second membre de la division
	 * @return le resultat de la division
	 */
	public Complexe division(Complexe b) {
		return this.multiplication(b.reciprocal());
	}

	/**
	 * @return the reel
	 */
	public double getReel() {
		return reel;
	}

	/**
	 * @return the imaginaire
	 */
	public double getImaginaire() {
		return imaginaire;
	}
/*
 * Pas utile pour le moment
	// return a new Complex object whose value is the complex sine of this
	public Complex sin() {
		return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
	}

	// return a new Complex object whose value is the complex cosine of this
	public Complex cos() {
		return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
	}

	// return a new Complex object whose value is the complex tangent of this
	public Complex tan() {
		return sin().divides(cos());
	}
*/
	/**
	 * Détermine si deux nombre complexe sont égaux
	 * @return true s'il sont égaux, false sinon
	 */
	public boolean equals(Object x) {
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		Complexe that = (Complexe) x;
		return (this.reel == that.reel) && (this.imaginaire == that.imaginaire);
	}
	
	
	/**
	 * Determine si deux nombre complexe sont les conjugués l'un de l'autre
	 * @param x
	 * @return true si conjugué, false sinon
	 */
	public boolean estConjugue(Object x) {
		Complexe that = (Complexe) x;
		return (this.reel == that.reel) && (this.imaginaire == -that.imaginaire);
	}

}

package Model;

import Model.Vecteur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import Model.Complexe;

/**
 * Gestion de matrice carré 2x2 et 3x3
 * Afin de determiner leurs valeurs propre (plus grande et plus petites)
 * Matrice hermitienne et symétrique gérée
 * @author QMS,Flo M, Multirob
 * @version 1.0
 */
public class Matrice {


	/** taille de la matrice carré */
	private int taille; 
	/** Valeur de la matrice carré 
	 * à chaque multiple de taille on passe à la ligne suivante de la matrice
	 */
	private List<Complexe> valeurs;

	/**
	 * Création d'une matrice en lui attribuant une taille et des valeurs
	 * @param taille la taille de la matrice
	 * @param valeurs liste des valeurs de la matrice
	 */
	public Matrice(int taille, List<Complexe> valeurs)
	{   
		this.taille = taille;
		// Itérator pour parcourir la liste de valeurs
		this.valeurs = valeurs; 
	}


	/**
	 * Détermine si une matrice est symétrique (valeurs réels)
	 * ou si ell est hermitienne (valeurs complexe)
	 * c'est à dire que les opposées par rapport à la diagonales sont égaux 
	 * ou bien elles sont le conjuguées l'une de l'autre
	 * @return true si matrice symétrique/hermitienne false sinon 
	 */
	public boolean estHermitienne(){
		// variable temporaire de stockage
		Complexe val1_2, val1_3,val2_1 ,val2_3,val3_1,val3_2;

		// cas matrice 2x2 
		if (this.getTaille() == 2) {
			// Récupération des valeurs à comparer
			val1_2 = new Complexe(this.getValeurs().get(1).getReel()
					,this.getValeurs().get(1).getImaginaire());
			val2_1 = new Complexe(this.getValeurs().get(2).getReel()
					,this.getValeurs().get(2).getImaginaire());

			return val1_2.equals(val2_1) || val1_2.estConjugue(val2_1)  ;
			// cas matrice 3x3
		} else if (this.getTaille() == 3) {
			// Récupération des valeurs à comparer
			val1_2 = new Complexe(this.getValeurs().get(1).getReel()
					,this.getValeurs().get(1).getImaginaire());
			val1_3 = new Complexe(this.getValeurs().get(2).getReel()
					,this.getValeurs().get(2).getImaginaire());
			val2_1 = new Complexe(this.getValeurs().get(3).getReel()
					,this.getValeurs().get(3).getImaginaire());
			val2_3 = new Complexe(this.getValeurs().get(5).getReel()
					,this.getValeurs().get(5).getImaginaire());
			val3_1 = new Complexe(this.getValeurs().get(6).getReel()
					,this.getValeurs().get(6).getImaginaire());
			val3_2 = new Complexe(this.getValeurs().get(7).getReel()
					,this.getValeurs().get(7).getImaginaire());

			return (val1_2.equals(val2_1) || val1_2.estConjugue(val2_1))
					&& (val1_3.equals(val3_1) || val1_3.estConjugue(val3_1)) 
					&& (val2_3.equals(val3_2) || val2_3.estConjugue(val3_2));		
		}
		return false;
	}



	public Vecteur mutiplication(Vecteur x) {
		Complexe[] valeurVec3 = {new Complexe(0,0),new Complexe(0,0),new Complexe(0,0)};
		Complexe[] valeurVec2 = {new Complexe(0,0),new Complexe(0,0)};
		// si matrice et vecteur taille 2
		if(this.taille == 2 && x.getX().length == 2) {
			valeurVec2[0] = (this.getValeurs().get(0).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(1).multiplication(x.getX()[1]));
			//System.out.println("valeur : "+valeur[0]);

			valeurVec2[1] = (this.getValeurs().get(2).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(3).multiplication(x.getX()[1]));
			//	System.out.println("valeur : "+valeur[1]);
			// matrice taille 3
			return new Vecteur(valeurVec2);
		} else if(this.taille == 3 && x.getX().length == 3) {
			valeurVec3[0] = (this.getValeurs().get(0).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(1).multiplication(x.getX()[1]))
					.addition(this.getValeurs().get(2).multiplication(x.getX()[2]));
			//System.out.println("valeur : "+valeur[0]);

			valeurVec3[1] = (this.getValeurs().get(3).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(4).multiplication(x.getX()[1]))
					.addition(this.getValeurs().get(5).multiplication(x.getX()[2]));
			//System.out.println("valeur : "+valeur[1]);

			valeurVec3[2] = (this.getValeurs().get(6).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(7).multiplication(x.getX()[1]))
					.addition(this.getValeurs().get(8).multiplication(x.getX()[2]));;
					//	System.out.println("valeur : "+valeur[2]);
					return new Vecteur(valeurVec3);		
		}

		return new Vecteur();
	}

	/**
	 * Détermination de la plus grande valeur propre 
	 * via la méthode de la puissance
	 * @param vn vecteur initiale pour commencer l'agorithme
	 * @return la plus grande valeur propre
	 */
	public double methodePuissance(Vecteur vn) {
		double precision = 0.005;  // precision
		// Vecteur Vn-1
		Vecteur vn__1 = new Vecteur(); 
		// vecteur tampon pour multiplication
		Vecteur zn = new Vecteur();
	
		for(int i=0; i< 14; i++) {
			vn__1 = vn;
			zn = this.mutiplication(vn);
			vn = zn.divise(zn.calculNorme());
			
			// Affichage pour vérification
			System.out.println("boucle " + i);
			System.out.println("Matrice A");
			for(int j = 0 ; j < this.getValeurs().size(); j++ ) {
				if (j%3 == 0) {
					System.out.println(" ");
				}
				System.out.print(this.getValeurs().get(j) + " ");
			}
			System.out.println("\nVecteur Vn");
			System.out.println(vn__1.toString());
			System.out.printf("norme vecteur %.4f\n",vn__1.calculNorme());
			System.out.println("\nVecteur V"+i);
			System.out.println(vn.toString());
			System.out.printf("norme vecteur %.4f\n",vn.calculNorme());
			System.out.println("LAMBDA : " + zn.calculNorme() );
		}
		return zn.calculNorme();
	}

	/**
	 * Détermination de la plus petite valeur propre 
	 * via la méthode de la puissance Inverse
	 * @param xk vecteur initiale pour commencer l'agorithme
	 * @return la plus petite valeur propre
	 */
	public double methodePuissanceInverse(Vecteur xk) {
		double precision = 0.005;  // precision
		Vecteur yk_1 = new Vecteur();
		Vecteur xk_temp = new Vecteur();

		// on boucle pour calcul
		for(int i=0; i< 14; i++) {
			xk_temp = xk;
            // multiplication entre la matrice inverse et le vecteur xk
			// Ce qui donne yk+1
			yk_1 = this.mutiplication(xk);
			// division de yk+1 par sa norme --> nouveau vecteur xk
			xk = yk_1.divise(yk_1.calculNorme());

			// Affichage pour verification 
			System.out.println("\nboucle " + i);
			System.out.println("Matrice A-1");
			for(int j = 0 ; j < this.getValeurs().size(); j++ ) {
				if (j%3 == 0) {
					System.out.println(" ");
				}
				System.out.print(this.getValeurs().get(j) + " ");
			}
			System.out.println("\nVecteur Xk");
			System.out.println(xk_temp.toString());
			System.out.printf("norme vecteur %.4f\n",xk_temp.calculNorme());
			System.out.println("\nVecteur Yk"+i);
			System.out.println(yk_1.toString());
			System.out.printf("norme vecteur %.4f\n",yk_1.calculNorme());
			System.out.println("LAMBDA : " + 1/yk_1.calculNorme() );
		}
		return 1/yk_1.calculNorme();

	}

	/***************** GET ************************/


	public int getTaille(){
		return taille;
	}



	/**
	 * @return the valeurs
	 */
	public List<Complexe> getValeurs() {
		return valeurs;
	}


	/**
	 * @param valeurs the valeurs to set
	 */
	public void setValeurs(List<Complexe> valeurs) {
		this.valeurs = valeurs;
	}


	/***************** SET ************************/


	public void setTaille(int taille){
		this.taille = taille;
	}

}

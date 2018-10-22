package Model;

import Model.Vecteur;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import Model.Complexe;

/**
 * Gestion de matrice carr� 2x2 et 3x3
 * Afin de determiner leurs valeurs propre (plus grande et plus petites)
 * Matrice hermitienne et sym�trique g�r�e
 * @author QMS,Flo M, Multirob
 * @version 1.0
 */
public class Matrice {


	/** taille de la matrice carr� */
	private int taille; 
	/** Valeur de la matrice carr� 
	 * � chaque multiple de taille on passe � la ligne suivante de la matrice
	 */
	private List<Complexe> valeurs;

	/**
	 * Cr�ation d'une matrice en lui attribuant une taille et des valeurs
	 * @param taille la taille de la matrice
	 * @param valeurs liste des valeurs de la matrice
	 */
	public Matrice(int taille, List<Complexe> valeurs)
	{   
		this.taille = taille;
		// It�rator pour parcourir la liste de valeurs
		this.valeurs = valeurs; 
	}


	/**
	 * D�termine si une matrice est sym�trique (valeurs r�els)
	 * ou si ell est hermitienne (valeurs complexe)
	 * c'est � dire que les oppos�es par rapport � la diagonales sont �gaux 
	 * ou bien elles sont le conjugu�es l'une de l'autre
	 * @return true si matrice sym�trique/hermitienne false sinon 
	 */
	public boolean estHermitienne(){
		// variable temporaire de stockage
		Complexe val1_2, val1_3,val2_1 ,val2_3,val3_1,val3_2;

		// cas matrice 2x2 
		if (this.getTaille() == 2) {
			// R�cup�ration des valeurs � comparer
			val1_2 = new Complexe(this.getValeurs().get(1).getReel()
					,this.getValeurs().get(1).getImaginaire());
			val2_1 = new Complexe(this.getValeurs().get(2).getReel()
					,this.getValeurs().get(2).getImaginaire());

			return val1_2.equals(val2_1) || val1_2.estConjugue(val2_1)  ;
			// cas matrice 3x3
		} else if (this.getTaille() == 3) {
			// R�cup�ration des valeurs � comparer
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
		Complexe[] valeur = {new Complexe(0,0),new Complexe(0,0),new Complexe(0,0)};

		// si matrice et vecteur taille 2
		if(this.taille == 2 && x.getX().length == 2) {
			valeur[0] = (this.getValeurs().get(0).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(1).multiplication(x.getX()[1]));
			//System.out.println("valeur : "+valeur[0]);

			valeur[1] = (this.getValeurs().get(2).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(3).multiplication(x.getX()[1]));
			//	System.out.println("valeur : "+valeur[1]);
			// matrice taille 3
		} else if(this.taille == 3 && x.getX().length == 3) {
			valeur[0] = (this.getValeurs().get(0).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(1).multiplication(x.getX()[1]))
					.addition(this.getValeurs().get(2).multiplication(x.getX()[2]));
			//System.out.println("valeur : "+valeur[0]);

			valeur[1] = (this.getValeurs().get(3).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(4).multiplication(x.getX()[1]))
					.addition(this.getValeurs().get(5).multiplication(x.getX()[2]));
			//System.out.println("valeur : "+valeur[1]);

			valeur[2] = (this.getValeurs().get(6).multiplication(x.getX()[0]))
					.addition(this.getValeurs().get(7).multiplication(x.getX()[1]))
					.addition(this.getValeurs().get(8).multiplication(x.getX()[2]));;
			//	System.out.println("valeur : "+valeur[2]);
		}

		return new Vecteur(valeur);
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

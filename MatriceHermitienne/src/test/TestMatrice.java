/**
 * 
 */
package test;

import Model.Vecteur;

import java.util.ArrayList;
import java.util.List;

import Model.Matrice;
import Model.Complexe;

/**
 * @author Quentin MS
 *
 */
public class TestMatrice {


	/** 
	 * Test de la methode est symétrique (cas reel) 
	 */
	public static void testEstSymetrique() {
		// Création des valeurs complexes pour la matrice
		Complexe val1_1 = new Complexe(3.0,0), 
				val1_2 = new Complexe(0.0,1),
				val1_3 = new Complexe(0.0,-5),
				val2_1 = new Complexe(0.0,-1),
				val2_2 = new Complexe(2.0,0.0),
				val2_3 = new Complexe(5.0,0.0),
				val3_1 = new Complexe(0.0,-5.0),
				val3_2 = new Complexe(5.0,0),
				val3_3 = new Complexe(10.0,0);
		
		//  la liste pour creer la matrice
		List<Complexe> valeurMatrice2 = new ArrayList<Complexe>();
		List<Complexe> valeurMatrice3 = new ArrayList<Complexe>();
		
		// Matrice 2x2
		valeurMatrice2.add(val1_1);
		valeurMatrice2.add(val1_2);
		valeurMatrice2.add(val2_1);
		valeurMatrice2.add(val2_2);
		
		// Matrice 3x3
		valeurMatrice3.add(val1_1);
		valeurMatrice3.add(val1_2);
		valeurMatrice3.add(val1_3);
		valeurMatrice3.add(val2_1);
		valeurMatrice3.add(val2_2);
		valeurMatrice3.add(val2_3);
		valeurMatrice3.add(val3_1);
		valeurMatrice3.add(val3_2);
		valeurMatrice3.add(val3_3);
		
		Matrice m2x2 = new Matrice(2,valeurMatrice2);
		Matrice m3x3 = new Matrice(3,valeurMatrice3);
		
		String resultat2 = m2x2.estHermitienne() == true 
				          ?"matrice 2x2 symetrique/hermitienne"
				          :"matrice 2x2 symetrique/hermitienne";
		
		String resultat3 = m3x3.estHermitienne() == true 
		          ?"matrice 3x3 symetrique/hermitienne"
		          :"matrice 3x3 symetrique/hermitienne";

		System.out.println(resultat2+ "\n" + resultat3 );
	}
	
	
	/** 
	 * Test de la methode multiplication  
	 */
	public static void testMultiplication() {
		// Création des valeurs complexes pour la matrice
				Complexe val1_1 = new Complexe(3.0,0), 
						val1_2 = new Complexe(0.0,0),
						val1_3 = new Complexe(0.0,0),
						val2_1 = new Complexe(4.0,0.0),
						val2_2 = new Complexe(0,0.0),
						val2_3 = new Complexe(0.0,0.0),
						val3_1 = new Complexe(7.0,0.0),
						val3_2 = new Complexe(0,0),
						val3_3 = new Complexe(0,0);
				
				List<Complexe> valeurMatrice2 = new ArrayList<Complexe>();
				List<Complexe> valeurMatrice3 = new ArrayList<Complexe>();
				
				// Matrice 2x2
				valeurMatrice2.add(val1_1);
				valeurMatrice2.add(val1_2);
				valeurMatrice2.add(val2_1);
				valeurMatrice2.add(val2_2);
				
				// Matrice 3x3
				valeurMatrice3.add(val1_1);
				valeurMatrice3.add(val1_2);
				valeurMatrice3.add(val1_3);
				valeurMatrice3.add(val2_1);
				valeurMatrice3.add(val2_2);
				valeurMatrice3.add(val2_3);
				valeurMatrice3.add(val3_1);
				valeurMatrice3.add(val3_2);
				valeurMatrice3.add(val3_3);
				
				Matrice m2x2 = new Matrice(2,valeurMatrice2);
				Matrice m3x3 = new Matrice(3,valeurMatrice3);
				
				// création d'un vecteur
				Complexe[] x0 = {new Complexe(2.0,0.0), 
				new Complexe(0.0,0.0), new Complexe(0.0,0.0) };
				
				Complexe[] vx1 = {new Complexe(2.0,0.0), 
						new Complexe(0.0,0.0)};
				
				Vecteur x = new Vecteur(x0);
				Vecteur x1 = new Vecteur(vx1);
				
				Vecteur xk= m3x3.mutiplication(x);
				Vecteur xk2 = m2x2.mutiplication(x1);
				System.out.println(xk.toString());
				System.out.println(xk2.toString());
	}
	
	/** 
	 * Test de la methode multiplication  
	 */
	public static void testMethodePuissance() {
		// Création des valeurs complexes pour la matrice
		Complexe val1_1 = new Complexe(5.0/8,0.0), 
				val1_2 = new Complexe(-3.0/8,0.0),
				val1_3 = new Complexe(-1/6.0,0.0),
				val2_1 = new Complexe(-3.0/8,0.0),
				val2_2 = new Complexe(1.0/5,0.0),
				val2_3 = new Complexe(2/9.0,0.0),
				val3_1 = new Complexe(-1/6,1.0),
				val3_2 = new Complexe(2/9.0,0.0),
				val3_3 = new Complexe(0,0.0);
		
		List<Complexe> valeurMatrice2 = new ArrayList<Complexe>();
		List<Complexe> valeurMatrice3 = new ArrayList<Complexe>();
		
		// Matrice 2x2
		valeurMatrice2.add(val1_1);
		valeurMatrice2.add(val1_2);
		valeurMatrice2.add(val2_1);
		valeurMatrice2.add(val2_2);
		
		// Matrice 3x3
		valeurMatrice3.add(val1_1);
		valeurMatrice3.add(val1_2);
		valeurMatrice3.add(val1_3);
		valeurMatrice3.add(val2_1);
		valeurMatrice3.add(val2_2);
		valeurMatrice3.add(val2_3);
		valeurMatrice3.add(val3_1);
		valeurMatrice3.add(val3_2);
		valeurMatrice3.add(val3_3);
		
		Matrice m2x2 = new Matrice(2,valeurMatrice2);
		Matrice m3x3 = new Matrice(3,valeurMatrice3);
		
		// création d'un vecteur
		Complexe[] x0 = {new Complexe(1.0,0.0), 
		new Complexe(0.0,0.0), new Complexe(0.0,0.0) };
		
		Complexe[] vx1 = {new Complexe(1.0,0.0), 
				new Complexe(0.0,0.0) };
				
		
		Vecteur x = new Vecteur(x0);
		Vecteur x1 = new Vecteur(vx1);
		System.out.println(m3x3.methodePuissanceInverse(x));
		//System.out.println(m2x2.methodePuissance(x1));
		//m2x2.methodePuissance(x1);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//testEstSymetrique();
		//testMultiplication();
		testMethodePuissance();
	}

}

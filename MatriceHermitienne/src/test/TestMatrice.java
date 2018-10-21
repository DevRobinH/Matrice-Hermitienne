/**
 * 
 */
package test;

import Model.Vecteur;

import java.util.ArrayList;
import java.util.List;

import Model.Matrice;
/**
 * @author Quentin MS
 *
 */
public class TestMatrice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[] x0 = {2,0,0};
		// Création d'une liste de valeurs
				List<Long> lstValeurs = new ArrayList<Long>();
				// Récup des valeurs de la matrice 3x3
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				lstValeurs.add(1L);
				// Création d'une matrice 3x3
				Matrice matrice3x3 = new Matrice(3, lstValeurs);
				
				Vecteur x = new Vecteur(x0);
				
				Vecteur xk = matrice3x3.mutiplication(x);
				
				System.out.println(xk.toString());
				
				
				
		

	}

}

package Model;

import java.util.List;
import java.util.ListIterator;

public class Matrice {

	private long[][] matrice;	
	private int taille; // 1 seule variable car matrice carrée
	List<Long> valeurs;
	
	/**
	 * Constructeur paramétré
	 * @param taille : définit la taille de la matrice
	 */
	public Matrice(int taille, List<Long> valeurs)
	{
		// Création de la matrice de taille passée en paramètre
	    this.matrice = new long[taille][taille];
	    
	    this.taille = taille;

	    // Itérator pour parcourir la liste de valeurs
	    ListIterator<Long> it = valeurs.listIterator();
	    
	    // Pour chaque ligne
	    for(int i = 0; i < taille; i++)
	    {
	    	// Pour chaque colonne de la ligne
	        for(int j = 0; j < taille; j++)
	        {
        		matrice[i][j] = it.next();
        		System.out.println(matrice[i][j]);
	        }
	    }
	}
	
	/***************** GET ************************/
	
	public long[][]GetMatrice(){
		return matrice;
	}
	
	public int GetTaille(){
		return taille;
	}
	
	/***************** SET ************************/
	
	public void SetMatrice(long[][] matrice){
		this.matrice = matrice;
	}
	
	public void SetTaille(int taille){
		this.taille = taille;
	}
	
}

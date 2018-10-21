package Model;

import java.util.List;
import java.util.ListIterator;

public class Matrice {

	private long[][] matrice;	
	private int taille; // 1 seule variable car matrice carr�e
	List<Long> valeurs;
	
	/**
	 * Constructeur param�tr�
	 * @param taille : d�finit la taille de la matrice
	 */
	public Matrice(int taille, List<Long> valeurs)
	{
		// Cr�ation de la matrice de taille pass�e en param�tre
	    this.matrice = new long[taille][taille];
	    
	    this.taille = taille;

	    // It�rator pour parcourir la liste de valeurs
	    ListIterator<Long> it = valeurs.listIterator();
	    
	    // Pour chaque ligne
	    for(int i = 0; i < taille; i++)
	    {
	    	// Pour chaque colonne de la ligne
	        for(int j = 0; j < taille; j++)
	        {
	        	// Pour la 1�re case de la matrice
	        	if (i==0 && j==0){
		            matrice[i][j] = valeurs.get(0);
	        	}
	        	else{
	        		// La case re�oit le prochain �l�ment de l'it�rateur
	        		matrice[i][j] = it.next();
	        	}
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

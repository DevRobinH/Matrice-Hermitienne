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
	
	public boolean estSymetrique(long[][] matrice){
		
		Long val1_2=0L, val1_3=0L, val2_1=0L, val2_3=0L, val3_1=0L, val3_2=0L;
		
		// Pour chaque ligne
	    for(int i = 0; i < taille; i++)
	    {
	    	// Pour chaque colonne de la ligne
	        for(int j = 0; j < taille; j++)
	        {
	        	// Récupération des valeurs aux coordonnées appropriées
        		if (i==0 && j==1)
        			val1_2 = matrice[0][1];
        		if (i==1 && j==0)
        			val2_1 = matrice[1][0];
        		if (i==0 && j==2)
        			val1_3 = matrice[0][2];
        		if (i==2 && j==0)
        			val3_1 = matrice[2][0];
        		if (i==1 && j==2)
        			val2_3 = matrice[1][2];
        		if (i==2 && j==1)
        			val3_2 = matrice[2][1];
	        }
	    }
	    
	    //System.out.println("La matrice est-elle symétrique ?");
	    //System.out.println(val1_2);
	    //System.out.println(val2_1);
	    //System.out.println(val1_3);
	    //System.out.println(val3_1);
	    //System.out.println(val2_3);
	    //System.out.println(val3_2);
	    
	    // Si les valeurs correspondent
	    if(val1_2 == val2_1 && val1_3 == val3_1 && val2_3 == val3_2) {
			return true; // La matrice est symétrique
	    }
	    else{
	    	return false;
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

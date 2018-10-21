package test;
import Model.Vecteur;

/**
 * Test de la classe vecteur
 *@author QMS,Flo M, Multirob
 * @version 1.0
 */
public class TestVecteur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] valeurs = {1,2,2};
        Vecteur x0 = new Vecteur (valeurs,0);
        
        System.out.println(x0.calculNorme());
	}

}

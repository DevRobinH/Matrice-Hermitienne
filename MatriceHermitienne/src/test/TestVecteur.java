package test;
import Model.Complexe;
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
		Complexe[] valeurs = {new Complexe(1.0,0),new Complexe(2.0,0),new Complexe(2.0,0)};
        Vecteur x0 = new Vecteur (valeurs,0);
        
        System.out.println(x0.calculNorme());
	}

}

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
		Complexe[] valeursV3 = {new Complexe(1.0,0),new Complexe(2.0,0),new Complexe(2.0,0)};
		Complexe[] valeursV2 = {new Complexe(0.0,0),new Complexe(2.0,0)};
		
		Vecteur x0 = new Vecteur (valeursV3);
		Vecteur x1 = new Vecteur (valeursV2);
		
        System.out.println(x0.calculNorme());
        System.out.println(x1.calculNorme());
	}

}

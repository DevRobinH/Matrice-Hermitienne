package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Model.Complexe;
import Model.Matrice;
import Model.Vecteur;

public class MatriceHermitienneController {
	
	@FXML
	private TextField champMatrice1_1;	
	@FXML
	private TextField champMatrice1_2;	
	@FXML
	private TextField champMatrice1_3;
	@FXML
	private TextField champMatrice2_1;	
	@FXML
	private TextField champMatrice2_2;
	@FXML
	private TextField champMatrice2_3;
	@FXML
	private TextField champMatrice3_1;
	@FXML
	private TextField champMatrice3_2;
	@FXML
	private TextField champMatrice3_3;		
	
	@FXML
	private RadioButton choix2x2;	
	@FXML
	private RadioButton choix3x3;  
	@FXML
	private ToggleGroup choixMatrice;
	
	@FXML
	private Button btCalculer;

	// Bloc Sym�trie

	@FXML
	private Label lbTitreSymetrique;
	@FXML
	private Label lbMatSymetrique; // � l'int�rieur du bloc sym�trie
	@FXML
	private Rectangle rectSymetrie;

	// Bloc Puissance

	@FXML
	private Rectangle rectPuissance; // Contour
	@FXML
	private Label lbTitrePuissance; // Titre du bloc
	@FXML
	private Label lbMatPuissance; // Label A =
	@FXML
	private QuadCurve parentheseGPuissance;
	@FXML
	private QuadCurve parentheseDPuissance;
	@FXML
	private Button btCalculerPuissance;
	@FXML
	private Label lbVecteurPuissance; // Vecteur Xo
	@FXML
	private Label lbVecteur1_1; 	// Vecteur de transition bloc puissance
	@FXML
	private Label lbVecteur2_1;
	@FXML
	private Label lbVecteur3_1;
	@FXML
	private QuadCurve parentheseGVecteur;
	@FXML
	private QuadCurve parentheseDVecteur;
	
	@FXML
	private Label lbMatrice1_1;
	@FXML
	private Label lbMatrice1_2;
	@FXML
	private Label lbMatrice1_3;
	@FXML
	private Label lbMatrice2_1;
	@FXML
	private Label lbMatrice2_2;
	@FXML
	private Label lbMatrice2_3;
	@FXML
	private Label lbMatrice3_1;
	@FXML
	private Label lbMatrice3_2;
	@FXML
	private Label lbMatrice3_3;

	// Bloc Puissance Inverse
	
	@FXML
	private QuadCurve parentheseGPuissanceInv;
	@FXML
	private QuadCurve parentheseDPuissanceInv;
	@FXML
	private Rectangle rectPuissanceInverse;
	@FXML
	private Label lbMatPuissanceInv;
	@FXML
	private Label lbMatPuissanceInvExposant;
	@FXML
	private Label lbTitrePuissanceInverse;
	@FXML
	private Button btCalculerPuissanceInverse;
	
	@FXML
	private TextField champMatriceInv1_1; // Matrice inverse � saisir
	@FXML
	private TextField champMatriceInv1_2;	
	@FXML
	private TextField champMatriceInv1_3;
	@FXML
	private TextField champMatriceInv2_1;	
	@FXML
	private TextField champMatriceInv2_2;
	@FXML
	private TextField champMatriceInv2_3;
	@FXML
	private TextField champMatriceInv3_1;
	@FXML
	private TextField champMatriceInv3_2;
	@FXML
	private TextField champMatriceInv3_3;
	
	//Lambdas du bas
	
	@FXML
	private Label lbTitreLambdaMax;	
	@FXML
	private Label lbTitreLambdaMin;
	@FXML
	private Label txtLambdaMax;
	@FXML
	private Label txtLambdaMin;
	@FXML
	private Label lbLambdaMax;
	@FXML
	private Label lbLambdaMin;
	@FXML
	private Rectangle rectLambdaMax;
	@FXML
	private Rectangle rectLambdaMin;
	
	// R�initialiser
	@FXML
	private Button btReinitialiser;
	
	
	/*#######################  Actions/�v�nements  #########################*/
	
	
	// Appel� au lancement de l'application
	@FXML
	private void initialize(){
		
		masquerBloc();	
	}
	
	/**
	 * M�thode pour bloquer/d�bloquer les cases suite au choix de la matrice
	 * 
	 * @param Evenement au clic d'un radio bouton
	 */
	public void actionChoixMatrice(ActionEvent evt){
				
		// Si matrice 3x3 est coch�
		if(choix3x3.isSelected()){
			
			// On d�bloque les cases
			champMatrice1_3.setDisable(false);
			champMatrice2_3.setDisable(false);
			champMatrice3_1.setDisable(false);
			champMatrice3_2.setDisable(false);
			champMatrice3_3.setDisable(false);

			champMatriceInv1_3.setDisable(false);
			champMatriceInv2_3.setDisable(false);
			champMatriceInv3_1.setDisable(false);
			champMatriceInv3_2.setDisable(false);
			champMatriceInv3_3.setDisable(false);
			lbVecteur3_1.setText("0");

		}
		else if(choix2x2.isSelected()){
			
			// On vide les cases
			champMatrice1_3.setText("");
			champMatrice2_3.setText("");
			champMatrice3_1.setText("");
			champMatrice3_2.setText("");
			champMatrice3_3.setText("");
			
			// On bloque les case
			champMatrice1_3.setDisable(true);
			champMatrice2_3.setDisable(true);
			champMatrice3_1.setDisable(true);
			champMatrice3_2.setDisable(true);
			champMatrice3_3.setDisable(true);
			
			// Dans le bloc Puissance
			
			lbVecteur3_1.setVisible(false);
			lbMatrice1_3.setVisible(false);
			lbMatrice2_3.setVisible(false);
			lbMatrice3_1.setVisible(false);
			lbMatrice3_2.setVisible(false);
			lbMatrice3_3.setVisible(false);
			
			// De la matrice inverse �galement
			champMatriceInv1_3.setDisable(true);
			champMatriceInv2_3.setDisable(true);
			champMatriceInv3_1.setDisable(true);
			champMatriceInv3_2.setDisable(true);
			champMatriceInv3_3.setDisable(true);
		}
	}
	
	/**
	 * M�thode pour r�cup�rer les valeurs de la matrice saisie
	 * 
	 * @param Evenement au clic du bouton Calculer sous la matrice
	 */
	public void actionCalculer(ActionEvent evt){
		
		// Au clic de Calculer, on fait appara�tre les diff�rents blocs
		// Bloc Sym�trie
		lbTitreSymetrique.setVisible(true);
		lbMatSymetrique.setVisible(true);
		rectSymetrie.setVisible(true);

		// Les blocs Puissance et Puissance Inverse appara�ssent
		afficherBlocPuissance();
		
/******************* M�thode de la Puissance **************************/
		
		//  Cr�ation d'une liste des complexes
		List<Complexe> valeursMatrice = new ArrayList<Complexe>();
		
		// Si bouton radio 2x2 coch�
		if (choix2x2.isSelected()){
			
			// On reporte les valeurs dans la matrice de la puissance
			lbMatrice1_1.setText(champMatrice1_1.getText());
			lbMatrice1_2.setText(champMatrice1_2.getText());
			lbMatrice2_1.setText(champMatrice2_1.getText());
			lbMatrice2_2.setText(champMatrice2_2.getText());
			
			// Cr�ation des objets complexes � partir des inputs (en texte)
			Complexe z1_1 = extraireComplexe(champMatrice1_1.getText());
			Complexe z1_2 = extraireComplexe(champMatrice1_2.getText());
			Complexe z2_1 = extraireComplexe(champMatrice2_1.getText());
			Complexe z2_2 = extraireComplexe(champMatrice2_2.getText());
			
			// On ajoute le complexe cr�� � la liste
			valeursMatrice.add(z1_1);
			valeursMatrice.add(z1_2);
			valeursMatrice.add(z2_1);
			valeursMatrice.add(z2_2);
			
			// Affichage du tableau des complexes
			afficherArray(valeursMatrice);
			
			// Cr�ation de la matrice
			Matrice M = new Matrice(2,valeursMatrice);
			
			// On d�termine si elle est sym�trique
			String estSymetrique = M.estHermitienne() == true 
			          ?"La matrice est symetrique/hermitienne"
			          :"La matrice n'est pas symetrique/hermitienne";
			
			// Affichage dans le bloc
			lbMatSymetrique.setText(estSymetrique);
			
			// Calcul de la plus grande valeur propre
			CalculerPuissance(M);
						
		}			
		// Si bouton radio 3x3 coch�
		else if(choix3x3.isSelected()){
			
			// On reporte les valeurs dans la matrice de la puissance
			lbMatrice1_1.setText(champMatrice1_1.getText());
			lbMatrice1_2.setText(champMatrice1_2.getText());
			lbMatrice1_3.setText(champMatrice1_3.getText());
			lbMatrice2_1.setText(champMatrice2_1.getText());
			lbMatrice2_2.setText(champMatrice2_2.getText());
			lbMatrice2_3.setText(champMatrice2_3.getText());
			lbMatrice3_1.setText(champMatrice3_1.getText());
			lbMatrice3_2.setText(champMatrice3_2.getText());
			lbMatrice3_3.setText(champMatrice3_3.getText());
			
			lbVecteur3_1.setText("0");
			
			// Cr�ation des objets complexes � partir des inputs (en texte)
			Complexe z1_1 = extraireComplexe(champMatrice1_1.getText());
			Complexe z1_2 = extraireComplexe(champMatrice1_2.getText());
			Complexe z1_3 = extraireComplexe(champMatrice1_3.getText());
			Complexe z2_1 = extraireComplexe(champMatrice2_1.getText());
			Complexe z2_2 = extraireComplexe(champMatrice2_2.getText());
			Complexe z2_3 = extraireComplexe(champMatrice2_3.getText());
			Complexe z3_1 = extraireComplexe(champMatrice3_1.getText());
			Complexe z3_2 = extraireComplexe(champMatrice3_2.getText());
			Complexe z3_3 = extraireComplexe(champMatrice3_3.getText());
			
			// On ajoute le complexe cr�� � la liste
			valeursMatrice.add(z1_1);
			valeursMatrice.add(z1_2);
			valeursMatrice.add(z1_3);
			valeursMatrice.add(z2_1);
			valeursMatrice.add(z2_2);
			valeursMatrice.add(z2_3);
			valeursMatrice.add(z3_1);
			valeursMatrice.add(z3_2);
			valeursMatrice.add(z3_3);
			
			// Affichage du tableau des complexes
			afficherArray(valeursMatrice);
			
			// Cr�ation de la matrice
			Matrice M = new Matrice(3,valeursMatrice);
			
			// On d�termine si elle est sym�trique
			String estSymetrique = M.estHermitienne() == true 
			          ?"La matrice est symetrique/hermitienne"
			          :"La matrice n'est pas symetrique/hermitienne";
			
			// Affichage dans le bloc
			lbMatSymetrique.setText(estSymetrique);
			
			// Calcul de la plus grande valeur propre
			CalculerPuissance(M);
		}	
	}
	
	/**
	 * Au clic du bouton r�nitialiser
	 * @param evt
	 */
	public void actionReinitialiser(ActionEvent evt){
		
		lbMatrice1_1.setText("");
		lbMatrice1_2.setText("");
		lbMatrice1_3.setText("");
		lbMatrice2_1.setText("");
		lbMatrice2_2.setText("");
		lbMatrice2_3.setText("");
		lbMatrice3_1.setText("");
		lbMatrice3_2.setText("");
		lbMatrice3_3.setText("");
		
		champMatriceInv1_1.setText(null);
		champMatriceInv1_2.setText(null);
		champMatriceInv1_3.setText(null);
		champMatriceInv2_1.setText(null);
		champMatriceInv2_2.setText(null);
		champMatriceInv2_3.setText(null);
		champMatriceInv3_1.setText(null);
		champMatriceInv3_2.setText(null);
		champMatriceInv3_3.setText(null);
		
		masquerBloc();
	}
	
	/**
	 * M�thode pour calculer lamda max (m�thode de la puissance)
	 * 
	 * @param Evenement au clic du bouton Calculer du bloc puissance
	 */
	public void actionPuissance(ActionEvent evt){
		
		// Au clic, les blocs du bas sont rendus visibles
		lbTitreLambdaMax.setVisible(true);	
		lbLambdaMax.setVisible(true);	
		rectLambdaMax.setVisible(true);
		
		txtLambdaMax.setVisible(true);
		
	}
	
	/**
	 * M�thode pour calculer lamda min (m�thode de la puissance inverse)
	 * 
	 * @param Evenement au clic du bouton Calculer du bloc puissance inverse
	 */
	public void actionPuissanceInverse(ActionEvent evt){
		
		// Au clic, les blocs du bas sont rendus visibles
		lbTitreLambdaMin.setVisible(true);		
		lbLambdaMin.setVisible(true);	
		rectLambdaMin.setVisible(true);
		
		txtLambdaMin.setVisible(true);
		
		/******************* M�thode de la Puissance Inverse **************************/
		
		//  Cr�ation d'une liste des complexes
		List<Complexe> valeursMatriceInv = new ArrayList<Complexe>();
		
		// Si bouton radio 2x2 coch�
		if (choix2x2.isSelected()){

			// Cr�ation des objets complexes � partir des inputs (en texte)
			Complexe z1_1i = extraireComplexe(champMatriceInv1_1.getText());
			Complexe z1_2i = extraireComplexe(champMatriceInv1_2.getText());
			Complexe z2_1i = extraireComplexe(champMatriceInv2_1.getText());
			Complexe z2_2i = extraireComplexe(champMatriceInv2_2.getText());
			
			// On ajoute le complexe cr�� � la liste
			valeursMatriceInv.add(z1_1i);
			valeursMatriceInv.add(z1_2i);
			valeursMatriceInv.add(z2_1i);
			valeursMatriceInv.add(z2_2i);
			
			// Affichage du tableau des complexes
			afficherArray(valeursMatriceInv);
			
			// Cr�ation de la matrice
			Matrice M = new Matrice(2,valeursMatriceInv);
			
			// Calcul de la plus petite valeur propre
			CalculerPuissanceInv(M);
		}
		
		else if(choix3x3.isSelected()){
			
			// Cr�ation des objets complexes � partir des inputs (en texte)
			Complexe z1_1i = extraireComplexe(champMatriceInv1_1.getText());
			Complexe z1_2i = extraireComplexe(champMatriceInv1_2.getText());
			Complexe z1_3i = extraireComplexe(champMatriceInv1_3.getText());
			Complexe z2_1i = extraireComplexe(champMatriceInv2_1.getText());
			Complexe z2_2i = extraireComplexe(champMatriceInv2_2.getText());
			Complexe z2_3i = extraireComplexe(champMatriceInv2_3.getText());
			Complexe z3_1i = extraireComplexe(champMatriceInv3_1.getText());
			Complexe z3_2i = extraireComplexe(champMatriceInv3_2.getText());
			Complexe z3_3i = extraireComplexe(champMatriceInv3_3.getText());
			
			// On ajoute le complexe cr�� � la liste
			valeursMatriceInv.add(z1_1i);
			valeursMatriceInv.add(z1_2i);
			valeursMatriceInv.add(z1_3i);
			valeursMatriceInv.add(z2_1i);
			valeursMatriceInv.add(z2_2i);
			valeursMatriceInv.add(z2_3i);
			valeursMatriceInv.add(z3_1i);
			valeursMatriceInv.add(z3_2i);
			valeursMatriceInv.add(z3_3i);
			
			// Affichage du tableau des complexes
			afficherArray(valeursMatriceInv);
			
			// Cr�ation de la matrice
			Matrice M = new Matrice(3,valeursMatriceInv);
			
			// Calcul de la plus petite valeur propre
			CalculerPuissanceInv(M);
		}			
	}
	
	/**
	 * Ouvre une fen�tre affichant le cours
	 */
	public void rappelFenetre(ActionEvent evt){
		try{
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fenetreRappel.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setTitle("Rappel sur les vecteurs propres");
			
			// Logo 3iL
			stage.getIcons().setAll(new Image(getClass().getResource("3ilogo.png").toExternalForm()));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (Exception e){
			System.out.println("Chargement de la page impossible");
		}
	}
	
	/*#######################  Fonctionnel  #########################*/
	
	public Complexe extraireComplexe(String valCaseMatrice){
		
		double reel = 0.0;
		double imaginaire = 0.0;
		
		String valeurFormatee = valCaseMatrice.replaceAll("\\s","");

	    // Trouve des complexes complets 
	    // Ex: -3-2i
	    //Pattern expressionA = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)([-|+]+[0-9]+\\.?[0-9]?)[i$]+");
	    Pattern expressionA = Pattern.compile("([-]?[0-9]+\\.?[0-9]*)([-|+]+[0-9]+\\.?[0-9]*)[i$]+");
	    
	    // Trouve des r�els purs
	    // Ex: 3.145
	    //Pattern expressionB = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)$");
	    Pattern expressionB = Pattern.compile("([-]?[0-9]+\\.?[0-9]*)$");

	    // Trouve des imaginaires purs
	    // Ex: -10i
	    //Pattern expressionC = Pattern.compile("([-]?[0-9]+\\.?[0-9]?)[i$]");
	    Pattern expressionC = Pattern.compile("([-]?[0-9]+\\.?[0-9]*)[i$]");

	    Matcher matcherA = expressionA.matcher(valeurFormatee);
	    Matcher matcherB = expressionB.matcher(valeurFormatee);
	    Matcher matcherC = expressionC.matcher(valeurFormatee);

		if (matcherA.find()) {
			reel = Double.parseDouble(matcherA.group(1));
			imaginaire = Double.parseDouble(matcherA.group(2));
		} else if (matcherB.find()) {
			reel = Double.parseDouble(matcherB.group(1));
			imaginaire = 0;
		} else if (matcherC.find()) {
			reel = 0;
			imaginaire = Double.parseDouble(matcherC.group(1));
		} 
		
		Complexe unComplexe = new Complexe(reel, imaginaire);
		
		return unComplexe;
		
	}
	
	/**
	 * M�thode de calcul de la puissance avec un vecteur unit� fix�
	 * @param M: La matrice d�sign�e
	 */
	public void CalculerPuissance(Matrice M){

		if(choix2x2.isSelected()){
			
			// Cr�ation d'un complexe unit�
			Complexe[] z0 = {new Complexe(1,0.0), 
			new Complexe(0.0,0.0) };
			
			// Cr�ation du vecteur unit�: vecteur V=(1, 0)
			Vecteur x = new Vecteur(z0);
			
			// La plus grande valeur propre est plac�e dans le bloc resultat Puissance
			lbLambdaMax.setText(String.format("%.2f", M.methodePuissance(x)));
		}
		else if(choix3x3.isSelected()){
			// Cr�ation d'un complexe unit�
			Complexe[] z0 = {new Complexe(1,0.0), 
			new Complexe(0.0,0.0), new Complexe(0.0,0.0)};
			
			// Cr�ation du vecteur unit�: vecteur V=(1, 0, 0)
			Vecteur x = new Vecteur(z0);
			
			// La plus grande valeur propre est plac�e dans le bloc resultat Puissance
			
			lbLambdaMax.setText(String.format("%.2f", M.methodePuissance(x)));
		}
	}
	
	/**
	 * M�thode de calcul de la puissance inverse avec un vecteur unit� fix�
	 * @param M: La matrice d�sign�e
	 */
	public void CalculerPuissanceInv(Matrice M){

		if(choix2x2.isSelected()){
			
			// Cr�ation d'un complexe unit�
			Complexe[] z0i = {new Complexe(1,0.0), 
			new Complexe(0.0,0.0) };
			
			// Cr�ation du vecteur unit�: vecteur V=(1, 0)
			Vecteur xi = new Vecteur(z0i);
			
			// La plus grande valeur propre est plac�e dans le bloc resultat Puissance
			lbLambdaMin.setText(String.format("%.2f", M.methodePuissanceInverse(xi)));
		}
		else if(choix3x3.isSelected()){
			// Cr�ation d'un complexe unit�
			Complexe[] z0i = {new Complexe(1,0.0), 
			new Complexe(0.0,0.0), new Complexe(0.0,0.0)};
			
			// Cr�ation du vecteur unit�: vecteur V=(1, 0, 0)
			Vecteur xi = new Vecteur(z0i);
			
			// La plus grande valeur propre est plac�e dans le bloc resultat Puissance		
			lbLambdaMin.setText(String.format("%.2f", M.methodePuissanceInverse(xi)));
		}
	}
	
/*#######################  Affichage  #########################*/
	
	
	/**
	 * Parcourir un tableau d'objets (ex: List<Complexe>)
	 * @param unTableau
	 */
	public void afficherArray(List unTableau){
		// Un it�rateur est associ� au tableau
		Iterator i = unTableau.iterator();
		
		System.out.println();
		System.out.println("Contenu de la liste des complexes");
		
		// On parcours le tableau
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	/**
	 * Affiche les blocs Puissance et Puissane Inverse
	 */
	private void afficherBlocPuissance(){
		// Bloc Puissance
		rectPuissance.setVisible(true);
		lbTitrePuissance.setVisible(true);
		lbMatPuissance.setVisible(true);
		parentheseGPuissance.setVisible(true);
		parentheseDPuissance.setVisible(true);
		btCalculerPuissance.setVisible(true);
		lbVecteurPuissance.setVisible(true);
		lbVecteur1_1.setVisible(true);
		lbVecteur2_1.setVisible(true);
		
		if(choix3x3.isSelected())
			lbVecteur3_1.setVisible(true);
		
		parentheseGVecteur.setVisible(true);
		parentheseDVecteur.setVisible(true);
				
		lbMatrice1_1.setVisible(true);
		lbMatrice1_2.setVisible(true);
		lbMatrice1_3.setVisible(true);
		lbMatrice2_1.setVisible(true);
		lbMatrice2_2.setVisible(true);
		lbMatrice2_3.setVisible(true);
		lbMatrice3_1.setVisible(true);
		lbMatrice3_2.setVisible(true);
		lbMatrice3_3.setVisible(true);

		// Bloc Puissance Inverse
		parentheseGPuissanceInv.setVisible(true);
		parentheseDPuissanceInv.setVisible(true);
		rectPuissanceInverse.setVisible(true);
		lbMatPuissanceInv.setVisible(true);
		lbMatPuissanceInvExposant.setVisible(true);
		lbTitrePuissanceInverse.setVisible(true);
		btCalculerPuissanceInverse.setVisible(true);
		champMatriceInv1_1.setVisible(true);
		champMatriceInv1_2.setVisible(true);	
		champMatriceInv1_3.setVisible(true);
		champMatriceInv2_1.setVisible(true);	
		champMatriceInv2_2.setVisible(true);
		champMatriceInv2_3.setVisible(true);
		champMatriceInv3_1.setVisible(true);
		champMatriceInv3_2.setVisible(true);
		champMatriceInv3_3.setVisible(true);
	}
	
	/**
	 * Masque les �l�ments comme au lancement de l'appli
	 */
	private void masquerBloc(){
		
		// Bloc Sym�trie
		lbTitreSymetrique.setVisible(false);
		lbMatSymetrique.setVisible(false);
		rectSymetrie.setVisible(false);

		// Bloc Puissance
		rectPuissance.setVisible(false);
		lbTitrePuissance.setVisible(false);
		lbMatPuissance.setVisible(false);
		parentheseGPuissance.setVisible(false);
		parentheseDPuissance.setVisible(false);
		btCalculerPuissance.setVisible(false);
		lbVecteurPuissance.setVisible(false);
		lbVecteur1_1.setVisible(false);
		lbVecteur2_1.setVisible(false);
		lbVecteur3_1.setVisible(false);
		parentheseGVecteur.setVisible(false);
		parentheseDVecteur.setVisible(false);
				
		lbMatrice1_1.setVisible(false);
		lbMatrice1_2.setVisible(false);
		lbMatrice1_3.setVisible(false);
		lbMatrice2_1.setVisible(false);
		lbMatrice2_2.setVisible(false);
		lbMatrice2_3.setVisible(false);
		lbMatrice3_1.setVisible(false);
		lbMatrice3_2.setVisible(false);
		lbMatrice3_3.setVisible(false);

		// Bloc Puissance Inverse
		parentheseGPuissanceInv.setVisible(false);
		parentheseDPuissanceInv.setVisible(false);
		rectPuissanceInverse.setVisible(false);
		lbMatPuissanceInv.setVisible(false);
		lbMatPuissanceInvExposant.setVisible(false);
		lbTitrePuissanceInverse.setVisible(false);
		btCalculerPuissanceInverse.setVisible(false);
				
		champMatriceInv1_1.setVisible(false);
		champMatriceInv1_2.setVisible(false);	
		champMatriceInv1_3.setVisible(false);
		champMatriceInv2_1.setVisible(false);	
		champMatriceInv2_2.setVisible(false);
		champMatriceInv2_3.setVisible(false);
		champMatriceInv3_1.setVisible(false);
		champMatriceInv3_2.setVisible(false);
		champMatriceInv3_3.setVisible(false);
		
		//Lambdas du bas
		lbTitreLambdaMax.setVisible(false);	
		lbTitreLambdaMin.setVisible(false);
		lbLambdaMax.setVisible(false);
		lbLambdaMin.setVisible(false);
		rectLambdaMax.setVisible(false);
		rectLambdaMin.setVisible(false);
		txtLambdaMin.setVisible(false);
		txtLambdaMax.setVisible(false);
	}
}

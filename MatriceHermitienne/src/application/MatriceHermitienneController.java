package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Matrice;

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

	// Bloc Symétrie

	@FXML
	private Label lbTitreSymetrique;
	@FXML
	private Label lbMatSymetrique; // à l'intérieur du bloc symétrie
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
	private TextField champMatriceInv1_1; // Matrice inverse à saisir
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
	private Label lbLambdaMax;
	@FXML
	private Label lbLambdaMin;
	@FXML
	private Rectangle rectLambdaMax;
	@FXML
	private Rectangle rectLambdaMin;
	
	
	
	
	// Appelé au lancement de l'application
	@FXML
	private void initialize(){
		
		// Ce qui doit être caché au démarrage
		
		// Bloc Symétrie
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
		
	}
	
	/**
	 * Méthode pour bloquer/débloquer les cases suite au choix de la matrice
	 * 
	 * @param Evenement au clic d'un radio bouton
	 */
	public void actionChoixMatrice(ActionEvent evt){
				
		// Si matrice 3x3 est coché
		if(choix3x3.isSelected()){
			
			// On débloque les cases
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
			
			// De la matrice inverse également
			champMatriceInv1_3.setDisable(true);
			champMatriceInv2_3.setDisable(true);
			champMatriceInv3_1.setDisable(true);
			champMatriceInv3_2.setDisable(true);
			champMatriceInv3_3.setDisable(true);
		}
	}
	
	/**
	 * Méthode pour récupérer les valeurs de la matrice saisie
	 * 
	 * @param Evenement au clic du bouton Calculer sous la matrice
	 */
	public void actionCalculer(ActionEvent evt){
		
		// Affichage en console des valeurs
		//System.out.println(champMatrice1_1.getText());
		//System.out.println(champMatrice1_2.getText());
		//System.out.println(champMatrice1_3.getText());
		//System.out.println(champMatrice2_1.getText());
		//System.out.println(champMatrice2_2.getText());
		//System.out.println(champMatrice2_3.getText());
		//System.out.println(champMatrice3_1.getText());
		//System.out.println(champMatrice3_2.getText());
		//System.out.println(champMatrice3_3.getText());
		
		// Au clic de Calculer, on fait apparaître les différents blocs
		// Bloc Symétrie
		lbTitreSymetrique.setVisible(true);
		lbMatSymetrique.setVisible(true);
		rectSymetrie.setVisible(true);

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
		
		// Création d'une liste de valeurs
		List<Long> lstValeurs = new ArrayList<Long>();
		
		// Variable pour savoir si une matrice est symétrique
		boolean matSymetrique = false;
		
		// Si bouton radio 2x2 coché
		if(choix2x2.isSelected()){
			
			// Récup des valeurs de la matrice 2x2
			lstValeurs.add(0, Long.parseLong(champMatrice1_1.getText()));
			lstValeurs.add(1, Long.parseLong(champMatrice1_2.getText()));
			lstValeurs.add(2, Long.parseLong(champMatrice2_1.getText()));
			lstValeurs.add(3, Long.parseLong(champMatrice2_2.getText()));
			
			// On reporte les valeurs dans la matrice de la puissance
			lbMatrice1_1.setText(champMatrice1_1.getText());
			lbMatrice1_2.setText(champMatrice1_2.getText());
			lbMatrice2_1.setText(champMatrice2_1.getText());
			lbMatrice2_2.setText(champMatrice2_2.getText());

			// Création de la matrice via le constructeur paramétré
			Matrice matrice2x2 = new Matrice(2, lstValeurs);
			
			// La matrice est-elle symétrique ?
			matSymetrique = matrice2x2.estSymetrique(matrice2x2.getMatrice());
			
			if (matSymetrique)
				lbMatSymetrique.setText("La matrice 2x2 est symétrique");
			else{
				lbMatSymetrique.setText("La matrice 2x2 n'est pas symétrique");
			}
		}
		else if(choix3x3.isSelected()){
			
			// Récup des valeurs de la matrice 3x3
			lstValeurs.add(0, Long.parseLong(champMatrice1_1.getText()));
			lstValeurs.add(1, Long.parseLong(champMatrice1_2.getText()));
			lstValeurs.add(2, Long.parseLong(champMatrice1_3.getText()));
			lstValeurs.add(3, Long.parseLong(champMatrice2_1.getText()));
			lstValeurs.add(4, Long.parseLong(champMatrice2_2.getText()));
			lstValeurs.add(5, Long.parseLong(champMatrice2_3.getText()));
			lstValeurs.add(6, Long.parseLong(champMatrice3_1.getText()));
			lstValeurs.add(7, Long.parseLong(champMatrice3_2.getText()));
			lstValeurs.add(8, Long.parseLong(champMatrice3_3.getText()));
			
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
			
			// Création d'une matrice 3x3
			Matrice matrice3x3 = new Matrice(3, lstValeurs);
			
			// La matrice est-elle symétrique ?
			matSymetrique = matrice3x3.estSymetrique(matrice3x3.getMatrice());	
			
			if (matSymetrique)
				lbMatSymetrique.setText("La matrice 3x3 est symétrique");
			else{
				lbMatSymetrique.setText("La matrice 3x3 n'est pas symétrique");
			}
		}
	}
	
	/**
	 * Méthode pour calculer lamda max (méthode de la puissance)
	 * 
	 * @param Evenement au clic du bouton Calculer du bloc puissance
	 */
	public void actionPuissance(ActionEvent evt){
		
		// Au clic, les blocs du bas sont rendus visibles
		lbTitreLambdaMax.setVisible(true);	
		lbLambdaMax.setVisible(true);	
		rectLambdaMax.setVisible(true);
	}
	
	/**
	 * Méthode pour calculer lamda min (méthode de la puissance inverse)
	 * 
	 * @param Evenement au clic du bouton Calculer du bloc puissance inverse
	 */
	public void actionPuissanceInverse(ActionEvent evt){
		
		// Au clic, les blocs du bas sont rendus visibles
		lbTitreLambdaMin.setVisible(true);		
		lbLambdaMin.setVisible(true);	
		rectLambdaMin.setVisible(true);
	}
	
	/**
	 * Ouvre une fenêtre affichant le cour
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
	
}

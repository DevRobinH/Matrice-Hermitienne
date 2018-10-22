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
import javafx.scene.layout.VBox;
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
	@FXML
	private Button btCalculerPuissance;
	@FXML
	private Button btCalculerPuissanceInverse;

	@FXML
	private Label lbTitreSymetrique;
	@FXML
	private Label lbTitrePuissance;
	@FXML
	private Label lbTitrePuissanceInverse;
	@FXML
	private Label lbTitreLambdaMax;	
	@FXML
	private Label lbTitreLambdaMin;
	
	@FXML
	private Label lbMatSymetrique; // � l'int�rieur du bloc sym�trie
	@FXML
	private Label lbLambdaMax;
	@FXML
	private Label lbLambdaMin;
	
	@FXML
	private TextArea txtAreaPuissance;
	@FXML
	private TextArea txtAreaPuissanceInverse;
	
	@FXML
	private Rectangle rectSymetrie;
	@FXML
	private Rectangle rectPuissance;
	@FXML
	private Rectangle rectPuissanceInverse;
	@FXML
	private Rectangle rectLambdaMax;
	@FXML
	private Rectangle rectLambdaMin;
	
	// Appel� au lancement de l'application
	@FXML
	private void initialize(){
		
		// Ce qui doit �tre cach� au d�marrage
		btCalculerPuissance.setVisible(false);
		btCalculerPuissanceInverse.setVisible(false);
		lbTitreSymetrique.setVisible(false);
		lbTitrePuissance.setVisible(false);
		lbTitrePuissanceInverse.setVisible(false);
		lbTitreLambdaMax.setVisible(false);	
		lbTitreLambdaMin.setVisible(false);
		lbMatSymetrique.setVisible(false);
		lbLambdaMax.setVisible(false);
		lbLambdaMin.setVisible(false);
		txtAreaPuissance.setVisible(false);
		txtAreaPuissanceInverse.setVisible(false);
		rectSymetrie.setVisible(false);
		rectPuissance.setVisible(false);
		rectPuissanceInverse.setVisible(false);
		rectLambdaMax.setVisible(false);
		rectLambdaMin.setVisible(false);
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
		}
	}
	
	/**
	 * M�thode pour r�cup�rer les valeurs de la matrice saisie
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
		
		// Au clic de Calculer, on fait appara�tre les diff�rents blocs
		btCalculerPuissance.setVisible(true);
		btCalculerPuissanceInverse.setVisible(true);
		lbTitreSymetrique.setVisible(true);
		lbTitrePuissance.setVisible(true);
		lbTitrePuissanceInverse.setVisible(true);
		lbMatSymetrique.setVisible(true);
		txtAreaPuissance.setVisible(true);
		txtAreaPuissanceInverse.setVisible(true);
		rectSymetrie.setVisible(true);
		rectPuissance.setVisible(true);
		rectPuissanceInverse.setVisible(true);
		
		// Cr�ation d'une liste de valeurs
		List<Long> lstValeurs = new ArrayList<Long>();
		
		// Variable pour savoir si une matrice est sym�trique
		boolean matSymetrique = false;
		
		// Si bouton radio 2x2 coch�
		if(choix2x2.isSelected()){
			
			// R�cup des valeurs de la matrice 2x2
			lstValeurs.add(0, Long.parseLong(champMatrice1_1.getText()));
			lstValeurs.add(1, Long.parseLong(champMatrice1_2.getText()));
			lstValeurs.add(2, Long.parseLong(champMatrice2_1.getText()));
			lstValeurs.add(3, Long.parseLong(champMatrice2_2.getText()));

			// Cr�ation de la matrice via le constructeur param�tr�
			Matrice matrice2x2 = new Matrice(2, lstValeurs);
			
			// La matrice est-elle sym�trique ?
			matSymetrique = matrice2x2.estSymetrique(matrice2x2.getMatrice());
			
			if (matSymetrique)
				lbMatSymetrique.setText("La matrice 2x2 est sym�trique");
			else{
				lbMatSymetrique.setText("La matrice 2x2 n'est pas sym�trique");
			}
		}
		else if(choix3x3.isSelected()){
			
			// R�cup des valeurs de la matrice 3x3
			lstValeurs.add(0, Long.parseLong(champMatrice1_1.getText()));
			lstValeurs.add(1, Long.parseLong(champMatrice1_2.getText()));
			lstValeurs.add(2, Long.parseLong(champMatrice1_3.getText()));
			lstValeurs.add(3, Long.parseLong(champMatrice2_1.getText()));
			lstValeurs.add(4, Long.parseLong(champMatrice2_2.getText()));
			lstValeurs.add(5, Long.parseLong(champMatrice2_3.getText()));
			lstValeurs.add(6, Long.parseLong(champMatrice3_1.getText()));
			lstValeurs.add(7, Long.parseLong(champMatrice3_2.getText()));
			lstValeurs.add(8, Long.parseLong(champMatrice3_3.getText()));
			
			// Cr�ation d'une matrice 3x3
			Matrice matrice3x3 = new Matrice(3, lstValeurs);
			
			// La matrice est-elle sym�trique ?
			matSymetrique = matrice3x3.estSymetrique(matrice3x3.getMatrice());	
			
			if (matSymetrique)
				lbMatSymetrique.setText("La matrice 3x3 est sym�trique");
			else{
				lbMatSymetrique.setText("La matrice 3x3 n'est pas sym�trique");
			}
		}
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
	}
	
	/**
	 * Ouvre une fen�tre affichant le cour
	 * @throws IOException 
	 */
	public void rappelFenetre() throws IOException{
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClass().getResource("fenetreRappel.fxml"));
		//Parent root = (Parent) fxmlLoader.load();
		//Stage stage = new Stage();
		//stage.setTitle("Rappel sur les vecteurs propres");
		
	}
	
}

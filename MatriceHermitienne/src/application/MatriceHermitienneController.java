package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
	 * Méthode récupérer les valeurs de la matrice saisie
	 * 
	 * @param Evenement au clic du bouton Calculer
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
		
		// Création d'une liste de valeurs
		List<Long> lstValeurs = new ArrayList<Long>();
		
		// Récupération et ajout à la liste des vals de la matrice
		lstValeurs.add(0, Long.parseLong(champMatrice1_1.getText()));
		lstValeurs.add(1, Long.parseLong(champMatrice1_2.getText()));
		lstValeurs.add(2, Long.parseLong(champMatrice1_3.getText()));
		lstValeurs.add(3, Long.parseLong(champMatrice2_1.getText()));
		lstValeurs.add(4, Long.parseLong(champMatrice2_2.getText()));
		lstValeurs.add(5, Long.parseLong(champMatrice2_3.getText()));
		lstValeurs.add(6, Long.parseLong(champMatrice3_1.getText()));
		lstValeurs.add(7, Long.parseLong(champMatrice3_2.getText()));
		lstValeurs.add(8, Long.parseLong(champMatrice3_3.getText()));
		
		// Si bouton radio 2x2 coché
		if(choix2x2.isSelected()){
			// Création d'une matrice 2x2
			Matrice matrice2x2 = new Matrice(2, lstValeurs);
			
		}
		else if(choix3x3.isSelected()){
			// Création d'une matrice 2x2
			Matrice matrice3x3 = new Matrice(3, lstValeurs);
		}
	}
	
}

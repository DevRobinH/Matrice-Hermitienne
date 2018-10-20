package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
	
	public void actionChoixMatrice(ActionEvent evt){
				
		// Si matrice 3x3 est coché
		if(choix3x3.isSelected()){
			
			//On débloque les cases
			champMatrice1_3.setDisable(false);
			champMatrice2_3.setDisable(false);
			champMatrice3_1.setDisable(false);
			champMatrice3_2.setDisable(false);
			champMatrice3_3.setDisable(false);
		}
		else if(choix2x2.isSelected()){
			champMatrice1_3.setDisable(true);
			champMatrice2_3.setDisable(true);
			champMatrice3_1.setDisable(true);
			champMatrice3_2.setDisable(true);
			champMatrice3_3.setDisable(true);
		}
	}
	
	
	
}

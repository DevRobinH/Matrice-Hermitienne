package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MatriceHermitienneController {
	
	@FXML
	private Button BtTest;
	
	@FXML
	public void actionBtTest(ActionEvent evt){

		System.out.println("\nouai");
	}
	
	@FXML
	private void initialize(){
		System.out.println("En début");
	}
	
}

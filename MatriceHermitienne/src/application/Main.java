package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MatriceHermitienne.fxml"));
			Scene scene = new Scene(root,850,780);
			
			// Titre de la fen�tre
			primaryStage.setTitle("Valeurs propres d'une Matrice Hermitienne");
			
			// Logo 3iL
			primaryStage.getIcons().setAll(new Image(getClass().getResource("3ilogo.png").toExternalForm()));
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

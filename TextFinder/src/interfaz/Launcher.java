package interfaz;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Launcher extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Inicia el programa
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Screen.fxml"));
		
		primaryStage.setTitle("Text Finder");
		primaryStage.setScene(new Scene(root, 1024, 768));
		primaryStage.show();
	}
	


}

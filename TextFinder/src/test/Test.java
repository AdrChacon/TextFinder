package test;

import javafx.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Test extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Stage stage = new Stage();
		
		VBox vbox = new VBox();
		
		Label label1 = new Label();
		Label label2 = new Label();
		Label label3 = new Label();
		
		label1.setText("This is label 1: clicking should print 'Hello World' ");
		label2.setText("This is label 2: clicking should print the result of 2+2");
		label3.setText("This is label 3: This one should have no function");
		
		label1.setOnMouseClicked(e -> System.out.println("Hello World"));
		label2.setOnMouseClicked(e -> System.out.println(2+2));
		
		label1.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		label2.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		label3.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		vbox.getChildren().addAll(label1, label2, label3);
		
		Scene scene = new Scene(vbox);

		
		stage.setScene(scene);
		
		stage.show();
		
		
	}

}

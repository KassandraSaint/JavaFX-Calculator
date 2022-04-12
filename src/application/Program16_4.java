// Kseniia Salko
// SPC ID 2431072 

package application;

//Importing all the modules
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Program16_4 extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Creating two TextFields for miles and kilometers
		TextField tMl = new TextField();
		TextField tKm = new TextField();
		
		// Creating a GridPane, giving it spacings and center position
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
		gPane.setPadding(new Insets(10, 10, 10, 10));
		gPane.setHgap(10);
		gPane.setVgap(10);
		// Adding nodes of labels and TextFields to each column and row
		gPane.add(new Label("Mile"), 0, 0);
		gPane.add(tMl, 1, 0);
		gPane.add(new Label("Kilometer"), 0, 1);
		gPane.add(tKm, 1, 1);
		
		// Setting onAction for the Miles TextField
		tMl.setOnAction(e -> {
			// Getting a value entered in the TextField
			String milesS = tMl.getText();
			// Converting this value to double
			double miles = Double.parseDouble(milesS);
			// Calculating distance in kilometers
			double km = miles * 1.609;
			// Converting value in kilometers to a String
			String kmS = String.valueOf(km);
			// Setting value for the Kilometers TextField
			tKm.setText(kmS);
		});
		// Setting OnACtion for the Kilometers TextField
		tKm.setOnAction( e -> {
			// Getting a value entered in the TextField
			String kmS = tKm.getText();
			// Converting this value into double
			double km = Double.parseDouble(kmS);
			// Calculating distance in miles
			double miles = km / 1.609;
			// Converting value we got to String
			String milesS = String.valueOf(miles);
			// Setting value of miles in the Miles TextField
			tMl.setText(milesS);
		});
		
		// Creating a scene and placing it in the stage
		Scene scene = new Scene(gPane);
		primaryStage.setTitle("Distance Converter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	// Main method
	public static void main(String[] args) {
		launch(args);
	}
}

//I worked alone!
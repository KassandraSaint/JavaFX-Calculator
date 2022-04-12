// Kseniia Salko
// SPC ID 2431072 

package application;

//Importing all the modules
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Program16_2 extends Application {

	@Override
	public void start(Stage primaryStage) {
	
		// Creating white Circle, Rectangle, Ellipse with black border
		Circle circle = new Circle(80, 80, 40);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Rectangle rec = new Rectangle(50, 50, 70, 70);
		rec.setFill(Color.WHITE);
		rec.setStroke(Color.BLACK);
		Ellipse ellipse = new Ellipse(60, 60, 60, 30);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Color.BLACK);
		
		// Creating a StackPane and placing a circle on it
		StackPane pane = new StackPane();
		pane.getChildren().add(circle);
		
		// Creating 3 RadioButtons, setting Circle to be checked
		RadioButton rbCircle = new RadioButton("Circle");
		RadioButton rbRectangle = new RadioButton("Rectangle");
		RadioButton rbEllipse = new RadioButton("Ellipse");
		rbCircle.setSelected(true);
		
		// Grouping all RaioButtons together
		ToggleGroup group = new ToggleGroup();
		rbCircle.setToggleGroup(group);
		rbRectangle.setToggleGroup(group);
		rbEllipse.setToggleGroup(group);
		
		//Creating CheckBox
		CheckBox fill = new CheckBox("Fill");
		
		// Creating HBox with spacing and aligned in center, with a border 
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setStyle("-fx-border: 1px; -fx-border-color: #000;");
		// Adding all RadioButtons and CheckBox to HBox
		hBox.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, fill);
		
		//Creating a BorderPane with StackPane, putting HBox at the bottom
		BorderPane bPane = new BorderPane(pane);
		bPane.setBottom(hBox);
		
		// Setting OnAction for a Circle RadioButton
		rbCircle.setOnAction(e -> {
			shapeCheck(pane, rbCircle, circle);
		});
		// Setting OnAction for Rectangle RadioButton
		rbRectangle.setOnAction(e -> {
			shapeCheck(pane, rbRectangle, rec);
		});
		// Setting OnAction for Ellipse RadioButton
		rbEllipse.setOnAction(e -> {
			shapeCheck(pane, rbEllipse, ellipse);
		});
		
		// Setting event handler on a CheckBox and calling filler function
		EventHandler<ActionEvent> handler = e -> {
			filler(fill, circle);
			filler(fill, rec);
			filler(fill, ellipse);
		};
		
		fill.setOnAction(handler);
		
		// Creating a scene and placing it in the stage
		Scene scene = new Scene(bPane, 300, 150);
		primaryStage.setTitle("Geometrical Figures");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	// Creating shapeCheck method to check which shape is set and according to
	// that show the correct shape
	public static void shapeCheck(StackPane pane, RadioButton button, Shape shape) {
		if (button.isSelected()) {
			pane.getChildren().clear();
			pane.getChildren().add(shape);
		}
	}
	
	// Creating filler method to check if shape is filled and to fill it
	public static void filler(CheckBox box, Shape shape) {
		if (box.isSelected()) {
			shape.setFill(Color.YELLOW);
		}
		else {
			shape.setFill(Color.WHITE);
			
		}
	}
	// Main method
	public static void main(String[] args) {
		launch(args);
	}
}

//I worked alone!
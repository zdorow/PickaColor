package PickaColor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
Programmer: Zachary Dorow
Programming Project 9.9
Object Oriented Programming I
Text Color Picker Exercise 
 */
public class PickaColor extends Application
{
    private Text message;
    private TextField EnteredMessage;
    private ColorPicker colorPicker;
    @Override
    public void start(Stage primaryStage)
    {
        Button button = new Button("Show message in chosen color");
        button.setOnAction(this::processInput);
        
        EnteredMessage = new TextField();
        EnteredMessage.setOnAction(this::processInput);
        
        Label label1 = new Label("Please enter a message: ");
        
        colorPicker = new ColorPicker(Color.BLACK);

        message = new Text(EnteredMessage.getText());
        message.setFont(Font.font("Helvetica", FontWeight.BOLD,FontPosture.REGULAR, 24));
        
        HBox pickers = new HBox(label1, EnteredMessage, colorPicker, button);
        pickers.setSpacing(5);
        pickers.setAlignment(Pos.CENTER);
        
        VBox root = new VBox();
        root.setStyle("-fx-background-color: whitesmoke");
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pickers, message);
        
        Scene scene = new Scene(root, 650, 150);
        
        primaryStage.getIcons().add(new Image("file:Colors.jpg"));
        primaryStage.setTitle("Color Your Text!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //Sets the text to the entered message and changes to picked color
    public void processInput(ActionEvent event)
    {
        message.setText(EnteredMessage.getText());
        message.setFill(colorPicker.getValue());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

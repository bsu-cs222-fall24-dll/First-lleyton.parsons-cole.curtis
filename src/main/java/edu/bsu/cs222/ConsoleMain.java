package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsoleMain extends Application {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the wikipedia article you wish to access: ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            ErrorChecking.noInputError();
        }
        try {
            ErrorChecking.noArticleExists(userInput);
            FormatOutput.formatOutput(userInput);
        } catch (IOException ioException) {
            System.err.println("Network Connection Problem: " + ioException.getMessage());
        }
    }*/
    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wikipedia Article Revision Finder"));

        HBox urlArea = new HBox(new Label("Please enter name of the Wikipedia article you wish to access:"));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);

        Button button = new Button("Get Revisions");
        button.setOnAction(actionEvent -> System.out.println("I would access " + textField.getText() + " here"));
        parent.getChildren().add(button);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}

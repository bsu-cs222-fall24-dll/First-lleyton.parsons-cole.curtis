package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsoleMain extends Application{
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the wikipedia article you wish to access: ");
        String userInput = scanner.nextLine();
        if (userInput.isEmpty()) {
            System.err.println(ErrorChecking.noInputError());
        }
        try {
            System.err.println(ErrorChecking.noArticleExists(userInput));
            System.out.println(ErrorChecking.redirectPrintOut(userInput));
            ArrayList<String> revisions = new ArrayList<>(FormatOutput.formatOutput(userInput));
            for (String revision : revisions) {
                System.out.println(revision);
            }
        } catch (IOException ioException) {
            System.err.println("Network Connection Problem: " + ioException.getMessage());
        }
    }*/
    @Override
    public void start(Stage primaryStage){
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wikipedia Article Revision Finder"));

        HBox urlArea = new HBox(new Label("Please enter name of the Wikipedia article you wish to access:"));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);

        Button button = new Button("Get 15 Most Recent Revisions");
        button.setOnAction(actionEvent -> {

            try {
                String userInput = textField.getText();
                Label noArticle = new Label(ErrorChecking.noArticleExists(userInput));
                parent.getChildren().add(noArticle);
                Label redirect = new Label(ErrorChecking.redirectPrintOut(userInput));
                parent.getChildren().add(redirect);
                if(userInput.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText(null);
                    alert.setContentText(ErrorChecking.noInputError());
                    alert.showAndWait();
                }
                else{
                    ArrayList<String> revisions = new ArrayList<>(FormatOutput.formatOutput(userInput));
                    for (String revision : revisions) {
                        Label revisionLabel = (new Label(revision));
                        parent.getChildren().add(revisionLabel);
                    }
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Network Error");
                alert.setHeaderText(null);
                alert.setContentText("Network Connection Problem: " + e.getMessage());
                alert.showAndWait();
            }
        });
        parent.getChildren().add(button);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}

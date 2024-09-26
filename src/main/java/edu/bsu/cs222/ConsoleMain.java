package edu.bsu.cs222;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import javafx.application.Application;
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
    public void start(Stage primaryStage) throws IOException{
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wikipedia Article Revision Finder"));

        HBox urlArea = new HBox(new Label("Please enter name of the Wikipedia article you wish to access:"));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);

        HBox revisionOutput = new HBox();

        Button button = new Button("Get Revisions");
        button.setOnAction(actionEvent -> {
            try {
                revisionOutput.getChildren().clear();
                String userInput = textField.getText();
                Label noArticle = new Label(ErrorChecking.noArticleExists(userInput));
                revisionOutput.getChildren().add(noArticle);
                Label redirect = new Label(ErrorChecking.redirectPrintOut(userInput));
                revisionOutput.getChildren().add(redirect);
                ArrayList<String> revisions = new ArrayList<>(FormatOutput.formatOutput(userInput));
                for (String revision : revisions) {
                    Label revisionLabel = (new Label(revision));
                    revisionOutput.getChildren().add(revisionLabel);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        parent.getChildren().add(button);

        primaryStage.setScene(new Scene(parent));
        primaryStage.setScene(new Scene(revisionOutput));
        primaryStage.show();
    }
}

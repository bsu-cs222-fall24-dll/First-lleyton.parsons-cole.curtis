package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GUIMain extends Application {
    @Override
    public void start(Stage primaryStage){
        VBox parent = new VBox();
        parent.getChildren().add(new Label("Wikipedia Article Revision Finder"));

        HBox urlArea = new HBox(new Label("Please enter name of the Wikipedia article you wish to access:"));
        TextField textField = new TextField();
        urlArea.getChildren().add(textField);
        parent.getChildren().add(urlArea);
        Text noArticle = new Text();
        Text redirect = new Text();
        Text revisionLabel = new Text();

        Button button = new Button("Get 15 Most Recent Revisions");
        button.setOnAction(actionEvent -> {

            try {
                String userInput = textField.getText();

                noArticle.setText(ErrorChecking.noArticleExists(userInput));

                redirect.setText(ErrorChecking.redirectPrintOut(userInput));

                if(userInput.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Input Error");
                    alert.setHeaderText(null);
                    alert.setContentText(ErrorChecking.noInputError());
                    alert.showAndWait();
                }
                else{
                    ArrayList<String> revisions = new ArrayList<>(FormatOutput.formatOutput(userInput));
                    StringBuilder revisionOutput = new StringBuilder();
                    for (String revision : revisions) {
                        revisionOutput.append(revision);
                    }
                    revisionLabel.setText(revisionOutput.toString());
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
        parent.getChildren().add(noArticle);
        parent.getChildren().add(redirect);
        parent.getChildren().add(revisionLabel);

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}

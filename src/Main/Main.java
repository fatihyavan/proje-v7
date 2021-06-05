package Main;

import Chart.SetBarChart;
import Chart.SetLineChart;
import Sort.SortingFile;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;

import javafx.stage.FileChooser;

import java.io.FileInputStream;

public class Main extends Application {
    File file;
    SortingFile sortingFile;

    public File getFile() {
        return file;
    }

    public void start(Stage stage) {

        try {
            stage.setTitle("Animated Chart");
            Stage stage1 = new Stage();
            stage1.initModality(Modality.WINDOW_MODAL);
            stage1.initOwner(stage);
            stage.setX(50);
            stage.setY(50);

            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("text files  (*.txt)", "*.txt");
            FileChooser.ExtensionFilter extFilter2 =
                    new FileChooser.ExtensionFilter("xml files  (*.xml)", "*.xml");

            fileChooser.getExtensionFilters().addAll(extFilter, extFilter2);
            fileChooser.setTitle("Select File");

            FileInputStream inputstream = new FileInputStream(".idea\\logo.png");
            Image image = new Image(inputstream);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(270);
            imageView.setFitHeight(270);

            Label label = new Label("No Files Selected");
            label.setStyle("-fx-font-weight: bold;");
            label.setFont(Font.font(15));
            label.setTextFill(Color.BLACK);

            Button btn1 = new Button("Upload Data");
            btn1.setStyle("-fx-font-size:15");

            Button btn2 = new Button("Show Line Chart");
            btn2.setStyle("-fx-font-size:15");

            Button btn3 = new Button("Show Bar Chart");
            btn3.setStyle("-fx-font-size:15");

            VBox root = new VBox(30, label, btn1, imageView);
            HBox hBox = new HBox(btn2, btn3);
            hBox.setSpacing(70);
            root.setAlignment(Pos.TOP_CENTER);
            hBox.setAlignment(Pos.TOP_CENTER);
            root.getChildren().addAll(hBox);
            Scene scene = new Scene(root, 400, 500);
            stage.setScene(scene);
            stage.show();

            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {


                    file = fileChooser.showOpenDialog(stage);

                    if (file != null) {
                        label.setText(file.getAbsolutePath()
                                + "  selected");
                        label.setTextFill(Color.GREEN);
                        sortingFile = new SortingFile(file);
                    }
                }

            };

            btn1.setOnAction(event);

            EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    SetLineChart lineChartForChart = new SetLineChart(sortingFile);

                    if (file != null) {
                        try {
                            lineChartForChart.start(stage1);
                            stage1.show();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }

            };

            btn2.setOnAction(event2);

            EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    SetBarChart barChart = new SetBarChart(sortingFile);

                    if (file != null) {
                        try {
                            barChart.start(stage1);
                            stage1.show();
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }

            };
            btn3.setOnAction(event3);


        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }


    public static void main(String args[]) {

        launch(args);
    }
}



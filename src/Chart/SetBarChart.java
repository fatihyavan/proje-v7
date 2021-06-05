package Chart;

import Data.RecordFile;
import Sort.SortingFile;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class SetBarChart extends Application {
    final int WINDOW_SIZE = 10;
    SortingFile sorting;
    List<String> color = new ArrayList<>();
    List<String> category = new ArrayList<>();
    List<RecordFile> recordList = new ArrayList<>();
    private ScheduledExecutorService scheduledExecutorService;

    public SetBarChart(SortingFile sorting) {
        this.sorting = sorting;

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        recordList = sorting.getSortList();
        category = sorting.getCategory();

        primaryStage.setTitle("JavaFX Realtime Chart Demo");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        yAxis.setLabel("Value");
        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Realtime JavaFX Charts");
        barChart.setAnimated(false);


        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        XYChart.Series<String, Number> series3 = new XYChart.Series<>();
        XYChart.Series<String, Number> series4 = new XYChart.Series<>();
        XYChart.Series<String, Number> series5 = new XYChart.Series<>();
        XYChart.Series<String, Number> series6 = new XYChart.Series<>();
        XYChart.Series<String, Number> series7 = new XYChart.Series<>();
        XYChart.Series<String, Number> series8 = new XYChart.Series<>();
        XYChart.Series<String, Number> series9 = new XYChart.Series<>();
        XYChart.Series<String, Number> series10 = new XYChart.Series<>();

        barChart.getData().addAll(series1, series2, series3, series4, series5, series6, series7, series8, series9, series10);


        Button pause = new Button(" ⏸ ");
        pause.setStyle("-fx-font-size:20;");

        Button play = new Button(" ▶ ");
        play.setStyle("-fx-font-size:21");

        Button restart = new Button(" \uD83D\uDD04 ");
        restart.setStyle("-fx-font-size:20");

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setPrefHeight(100);

        BorderPane pane = new BorderPane();

        hBox.getChildren().addAll(pause, play, restart);
        pane.setCenter(barChart);
        pane.setBottom(hBox);
        hBox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


        final int[] i = {0}; //for index
        colorList();

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(400),
                e -> {
                    try {
                        xAxis.setLabel(String.valueOf(sorting.getSortList().get(i[0]).getYear()));
                        xAxis.setTickLabelRotation(90);
                        series1.setName(recordList.get(i[0]).getCategory() + " | " + recordList.get(i[0]).getName());
                        series2.setName(recordList.get(i[0] + 1).getCategory() + " | " + recordList.get(i[0] + 1).getName());
                        series3.setName(recordList.get(i[0] + 2).getCategory() + " | " + recordList.get(i[0] + 2).getName());
                        series4.setName(recordList.get(i[0] + 3).getCategory() + " | " + recordList.get(i[0] + 3).getName());
                        series5.setName(recordList.get(i[0] + 4).getCategory() + " | " + recordList.get(i[0] + 4).getName());
                        series6.setName(recordList.get(i[0] + 5).getCategory() + " | " + recordList.get(i[0] + 5).getName());
                        series7.setName(recordList.get(i[0] + 6).getCategory() + " | " + recordList.get(i[0] + 6).getName());
                        series8.setName(recordList.get(i[0] + 7).getCategory() + " | " + recordList.get(i[0] + 7).getName());
                        series9.setName(recordList.get(i[0] + 8).getCategory() + " | " + recordList.get(i[0] + 8).getName());
                        series10.setName(recordList.get(i[0] + 9).getCategory() + " | " + recordList.get(i[0] + 9).getName());

                        series1.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0]).getYear()), recordList.get(i[0]).getValue()));
                        series2.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 1).getYear()), recordList.get(i[0] + 1).getValue()));
                        series3.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 2).getYear()), recordList.get(i[0] + 2).getValue()));
                        series4.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 3).getYear()), recordList.get(i[0] + 3).getValue()));
                        series5.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 4).getYear()), recordList.get(i[0] + 4).getValue()));
                        series6.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 5).getYear()), recordList.get(i[0] + 5).getValue()));
                        series7.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 6).getYear()), recordList.get(i[0] + 6).getValue()));
                        series8.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 7).getYear()), recordList.get(i[0] + 7).getValue()));
                        series9.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 8).getYear()), recordList.get(i[0] + 8).getValue()));
                        series10.getData().add(new XYChart.Data<>(String.valueOf(recordList.get(i[0] + 9).getYear()), recordList.get(i[0] + 9).getValue()));
                        i[0] += 10;
                    } catch (Exception exceptione) {
                        exceptione.printStackTrace();
                    }

                    color(barChart);

                    if (series1.getData().size() > 1) {
                        series1.getData().remove(0);
                        series2.getData().remove(0);
                        series3.getData().remove(0);
                        series4.getData().remove(0);
                        series5.getData().remove(0);
                        series6.getData().remove(0);
                        series7.getData().remove(0);
                        series8.getData().remove(0);
                        series9.getData().remove(0);
                        series10.getData().remove(0);
                    }
                    if (i[0]+10>recordList.size()){
                        i[0]=0;
                    }

                }

        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();


        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                timeline.pause();
            }

        };
        pause.setOnAction(event);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                timeline.play();
            }

        };
        play.setOnAction(event1);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                i[0]=0;
                timeline.play();
            }

        };
        restart.setOnAction(event2);

    }


    @Override
    public void stop() throws Exception {
        super.stop();
    }


    private void color(BarChart<String, Number> barChart) {
        for (int j = 0; j < category.size(); j++) {
            for (XYChart.Series<String, Number> series : barChart.getData()) {
                if (series.getName().contains(category.get(j))) {
                    for (XYChart.Data data : series.getData()) {
                        data.getNode().setStyle("-fx-bar-fill:" + color.get(j));
                    }
                }
            }
            for (Node node : barChart.lookupAll("Label.chart-legend-item")) {
                Label tempLabel = (Label) node;
                if (tempLabel.getText().contains(category.get(j))) {
                    tempLabel.getGraphic().setStyle("-fx-bar-fill:" + color.get(j));
                }
            }

        }
    }


    public void colorList() {
        color.add("#a422b2");
        color.add("rgb(255,231,0)");
        color.add("#229079");
        color.add("#b2222e");
        color.add("#445361");
        color.add("#ff5900");
        color.add("#ffaa00");
        color.add("#ffef80");
        color.add("#738c43");
        color.add("#d49472");
        color.add("#cfd4f9");
        color.add("#36ff00");
        color.add("#829dff");
        color.add("#69c764");
        color.add("#7e6858");
        color.add("#27010e");
        color.add("#115a75");
        color.add("#adb115");
        color.add("#db6d4c");
        color.add("#301f01");
        color.add("#baa994");
        color.add("#0b3042");
        color.add("#00e9ff");
        color.add("#092121");
        color.add("#cd553d");
        color.add("#decaaf");

    }

}

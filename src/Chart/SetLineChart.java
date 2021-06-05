package Chart;


import Data.RecordFile;
import Sort.SortingFile;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class SetLineChart extends Application {

    final int WINDOW_SIZE = 10;
    private ScheduledExecutorService scheduledExecutorService;
    SortingFile sorting;
    List<RecordFile> recordList = new ArrayList<>();

    public SetLineChart(SortingFile sorting) {
        this.sorting = sorting;

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        recordList = sorting.getSortList();

        primaryStage.setTitle("JavaFX Realtime Chart Demo");


        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time/s");
        xAxis.setAnimated(false);
        yAxis.setLabel("Value");
        yAxis.setAnimated(false);


        final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Realtime JavaFX Charts");
        lineChart.setAnimated(false);

        Platform.runLater(() -> lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color: rgb(250,250,248);"));

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

        lineChart.setCreateSymbols(true);

        lineChart.getData().addAll(series1, series2, series3, series4, series5, series6, series7, series8, series9, series10);


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
        pane.setCenter(lineChart);
        pane.setBottom(hBox);
        hBox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();


        final int[] i = {0};

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(400),
                e -> {
                    try {
                        series1.setName(recordList.get(i[0]).getName());
                        series2.setName(recordList.get(i[0] + 1).getName());
                        series3.setName(recordList.get(i[0] + 2).getName());
                        series4.setName(recordList.get(i[0] + 3).getName());
                        series5.setName(recordList.get(i[0] + 4).getName());
                        series6.setName(recordList.get(i[0] + 5).getName());
                        series7.setName(recordList.get(i[0] + 6).getName());
                        series8.setName(recordList.get(i[0] + 7).getName());
                        series9.setName(recordList.get(i[0] + 8).getName());
                        series10.setName(recordList.get(i[0] + 9).getName());

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
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    if (series1.getData().size() > WINDOW_SIZE) {
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
                i[0] = 0;
            }

        };
        restart.setOnAction(event2);

    }

    @Override
    public void stop() throws Exception {
        super.stop();

    }
}


package Chart;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class renk extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button();
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #a422b2;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: rgb(255,231,0);"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #229079;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #b2222e;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #445361;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #ff5900;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #ffaa00;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #ffef80;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #738c43;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #d49472;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #cfd4f9;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #36ff00;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #829dff;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #69c764;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #7e6858;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #27010e;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #115a75;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #adb115;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #db6d4c;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #301f01;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #baa994;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #0b3042;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #00e9ff;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #092121;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #cd553d;"));
        Platform.runLater(() -> button.lookup(".chart-plot-background").setStyle("-fx-background-color: #decaaf;"));


    }
}

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureApp extends Application {
    public static void main(String[] args) {
        // System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        // System.out.println("Init method");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // System.out.println("start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app_layout.fxml"));
        VBox rootNode = loader.load();

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        // System.out.println("stop");
        super.stop();
    }
}

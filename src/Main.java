import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GameOfWarView.fxml"));

        Scene scene = new Scene(root);
        String css = this.getClass().getResource("./gameOfWarStyle.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setTitle("Game Of War");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

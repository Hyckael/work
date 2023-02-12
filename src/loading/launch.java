package loading;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class launch extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("SplashUi.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		Image image = new Image("/assets/icons8_connect_develop_512px.png");
		primaryStage.getIcons().add(image);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}

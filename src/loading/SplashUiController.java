package loading;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashUiController implements Initializable {

    @FXML
    private AnchorPane anchRoot;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FadeTransition.applyFadeTransition(anchRoot, Duration.seconds(4), (e) -> {
			try {
				anchRoot.getScene().getWindow().hide();
				Parent root = FXMLLoader.load(getClass().getResource("/interfaces/Main.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				Image image = new Image("/assets/icons8_rolls_royce_512px.png");
				stage.getIcons().add(image);
				new animatefx.animation.FadeInDown(root).play();
				stage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

}

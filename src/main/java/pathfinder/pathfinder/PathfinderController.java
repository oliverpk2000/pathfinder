package pathfinder.pathfinder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PathfinderController {
  @FXML
  private Label welcomeText;

  @FXML
  protected void onHelloButtonClick() {
    welcomeText.setText("Welcome to JavaFX Application!");
  }
}

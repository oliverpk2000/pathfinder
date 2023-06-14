package pathfinder.pathfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class PathfinderController {

  @FXML
  private RadioButton blockRadioButton;

  @FXML
  private RadioButton endRadioButton;

  @FXML
  private GridPane grid;

  @FXML
  private ToggleGroup points;

  @FXML
  private Button startButton;

  @FXML
  private RadioButton startRadioButton;

  @FXML
  void start(ActionEvent event) {

  }

}

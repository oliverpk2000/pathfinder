package pathfinder.pathfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class PathfinderController implements Initializable {

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

  private int gridRows;
  private int gridCols;

  @FXML
  void start(ActionEvent event) {
    System.out.println("start button works");
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    gridCols = 8;
    gridRows = 8;
    setUpGrid(grid, 600, 600, gridRows, gridCols);
    grid.setOnMouseClicked(mouseEvent -> {
      Rectangle rect = (Rectangle) mouseEvent.getTarget();
      Color color = (Color) rect.getFill();
      if (color == Color.RED) {
        rect.setFill((Color) rect.getUserData());
      } else {
        rect.setFill(Color.RED);
      }
    });

  }

  public void setUpGrid(GridPane gp, int length, int height, int row, int column) {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        Rectangle rectangle = new Rectangle(((double) length / row), ((double) height / column));
        if ((i + j) % 2 == 0) {
          rectangle.setFill(Color.WHITE);
          rectangle.setUserData(Color.WHITE);
        } else {
          rectangle.setFill(Color.GRAY);
          rectangle.setUserData(Color.GRAY);
        }
        gp.add(rectangle, i, j);
      }
    }
  }
}

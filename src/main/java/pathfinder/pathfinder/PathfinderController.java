package pathfinder.pathfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PathfinderController implements Initializable {
  @FXML
  public Label errorMsg;
  @FXML
  public Button resetButton;
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

  private Rectangle startPoint;

  private Rectangle endPoint;

  private ArrayList<Rectangle> blockPoints;
  private int gridRows;
  private int gridCols;

  @FXML
  void start(ActionEvent event) {
    if (readyToStart()) {
      errorMsg.setText("");
      System.out.println("insert pathfinding algorithm here");
    } else {
      errorMsg.setText("you need to set both a start and an end point.");
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    gridCols = 8;
    gridRows = 8;
    blockPoints = new ArrayList<>();
    setUpGrid(grid, 600, 600, gridRows, gridCols);
    grid.setOnMouseClicked(mouseEvent -> {
      Rectangle rect = (Rectangle) mouseEvent.getTarget();
      Color color = (Color) rect.getFill();
      Color selectedTypeColor = getPointType();
      if (color == selectedTypeColor) {
        removeSelectedPoint(rect);
        rect.setFill((Color) rect.getUserData());
      } else {
        rect.setFill(selectedTypeColor);
        saveSelectedPoint(rect);
      }
    });
    errorMsg.setWrapText(true);
    errorMsg.setTextAlignment(TextAlignment.JUSTIFY);
  }

  public void setUpGrid(GridPane gp, int length, int height, int row, int column) {
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        Rectangle rectangle = new Rectangle(((double) length / row), ((double) height / column));
        rectangle.setFill(Color.GRAY);
        rectangle.setUserData(Color.GRAY);
        gp.add(rectangle, i, j);
      }
    }
  }

  public Color getPointType() {
    if (startRadioButton.isSelected()) {
      return Color.GREEN;
    } else if (endRadioButton.isSelected()) {
      return Color.YELLOW;
    } else {
      return Color.BLACK;
    }
  }

  public void saveSelectedPoint(Rectangle clickedPoint) {
    Color clickedPointColor = getColorFromRectangle(clickedPoint);
    if (clickedPointColor == Color.BLACK) {
      blockPoints.add(clickedPoint);
    }
    if (clickedPointColor == Color.GREEN) {
      try {
        startPoint.setFill(Color.GRAY);
      } catch (NullPointerException ignored) {
      }
      startPoint = clickedPoint;
    }
    if (clickedPointColor == Color.YELLOW) {
      try {
        endPoint.setFill(Color.GRAY);
      } catch (NullPointerException ignored) {
      }
      endPoint = clickedPoint;
    }
  }

  public void removeSelectedPoint(Rectangle clickedPoint) {
    Color clickedPointColor = getColorFromRectangle(clickedPoint);
    if (clickedPointColor == Color.BLACK) {
      blockPoints.remove(clickedPoint);
    }
    if (clickedPointColor == Color.GREEN) {
      startPoint.setFill(Color.GRAY);
      startPoint = null;
    }
    if (clickedPointColor == Color.YELLOW) {
      endPoint.setFill(Color.GRAY);
      endPoint = null;
    }
  }

  private Color getColorFromRectangle(Rectangle rect){
    return (Color) rect.getFill();
  }

  boolean readyToStart() {
    return startPoint != null && endPoint != null;
  }

  public void reset(ActionEvent actionEvent) {
    setUpGrid(grid, 600, 600, gridRows, gridCols);
    startPoint = null;
    endPoint = null;
    blockPoints.removeAll(blockPoints);
  }
}

module pathfinder.pathfinder {
  requires javafx.controls;
  requires javafx.fxml;


  opens pathfinder.pathfinder to javafx.fxml;
  exports pathfinder.pathfinder;
}

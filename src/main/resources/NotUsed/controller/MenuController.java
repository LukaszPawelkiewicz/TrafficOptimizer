package NotUsed.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import NotUsed.Loader;
import mvc.model.road.common.EndPoint;
import mvc.model.road.common.Road;
import mvc.model.road.common.StartPoint;
import mvc.model.road.object.RoadObject;
import mvc.model.road.object.RoadObjectSimple;
import mvc.model.simulation.observer.common.RoadObjectObserver;


import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Button refreshButton;
    @FXML
    private TableView<RoadObjectSimple> roadObjectTableView;
    @FXML
    private TableColumn<RoadObjectSimple, String> nameColumn;
    @FXML
    private TableColumn<RoadObjectSimple, Integer> xColumn;
    @FXML
    private TableColumn<RoadObjectSimple, Integer> yColumn;
    @FXML
    private TableColumn<RoadObjectSimple, Long> lengthColumn;

    private final ObservableList<RoadObjectSimple> roadObjectsData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO to remove
        StartPoint startPoint = new StartPoint(1, 1, RoadObjectObserver.getInstance());
        EndPoint endPoint = new EndPoint(1, 3, RoadObjectObserver.getInstance());
        Road road = new Road(1, 3, 50, RoadObjectObserver.getInstance());
        Road road1 = new Road(2, 4, 100, RoadObjectObserver.getInstance());
    }

    private void setTableData() {
        for (RoadObject roadObject : RoadObjectObserver.getRoadObjects()) {
            roadObjectsData.add(new RoadObjectSimple(roadObject));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
            yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
            lengthColumn.setCellValueFactory(new PropertyValueFactory<>("length"));
        }
        roadObjectTableView.setItems(roadObjectsData);
    }

    public void refreshAction(ActionEvent actionEvent) {
        setTableData();
    }

    public void newObjectAction(ActionEvent actionEvent) {
        Parent root = Loader.getNewRoadObject();
        Stage stage = new Stage();
        stage.setX(stage.getX() + 100);
        stage.setY(stage.getY() + 100);
        stage.setTitle("New Road Object");
        stage.setScene(new Scene(root));
        stage.show();

    }
}


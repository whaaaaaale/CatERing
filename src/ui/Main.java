package ui;

import businesslogic.CatERing;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import ui.kitchenTask.KitchenTaskManagement;
import ui.menu.MenuManagement;

import java.io.IOException;

public class Main {

    @FXML
    AnchorPane paneContainer;

    @FXML
    GridPane startPane;

    @FXML
    Star startPaneController;

    BorderPane menuManagementPane;
    MenuManagement menuManagementPaneController;

    BorderPane kitchenTaskManagementPane;
    KitchenTaskManagement kitchenTaskManagementPaneController;

    public void initialize() {
        startPaneController.setParent(this);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu/menu-management.fxml"));
        try {
            menuManagementPane = loader.load();
            menuManagementPaneController = loader.getController();
            menuManagementPaneController.setMainPaneController(this);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        loader = new FXMLLoader(getClass().getResource("kitchenTask/kitchenTask-management.fxml"));
        try {
            kitchenTaskManagementPane = loader.load();
            kitchenTaskManagementPaneController = loader.getController();
            kitchenTaskManagementPaneController.setMainPaneController(this);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void startMenuManagement() {
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");

        menuManagementPaneController.initialize();
        paneContainer.getChildren().remove(startPane);
        paneContainer.getChildren().add(menuManagementPane);
        AnchorPane.setTopAnchor(menuManagementPane, 0.0);
        AnchorPane.setBottomAnchor(menuManagementPane, 0.0);
        AnchorPane.setLeftAnchor(menuManagementPane, 0.0);
        AnchorPane.setRightAnchor(menuManagementPane, 0.0);

    }

    public void startKitchenTaskManagement() {
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");

        kitchenTaskManagementPaneController.initialize();
        kitchenTaskManagementPaneController.setEventList();

        paneContainer.getChildren().remove(startPane);
        paneContainer.getChildren().add(kitchenTaskManagementPane);
        AnchorPane.setTopAnchor(kitchenTaskManagementPane, 0.0);
        AnchorPane.setBottomAnchor(kitchenTaskManagementPane, 0.0);
        AnchorPane.setLeftAnchor(kitchenTaskManagementPane, 0.0);
        AnchorPane.setRightAnchor(kitchenTaskManagementPane, 0.0);

    }

    public void showStartPane() {
        startPaneController.initialize();
        paneContainer.getChildren().remove(menuManagementPane);
        paneContainer.getChildren().remove(kitchenTaskManagementPane);
        paneContainer.getChildren().add(startPane);
    }


}

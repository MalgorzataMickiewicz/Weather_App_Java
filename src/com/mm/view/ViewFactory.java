package com.mm.view;

import com.mm.controller.AbstractController;
import com.mm.controller.ApiConnection;
import com.mm.controller.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ArrayList<Stage> activeStages;

    public ViewFactory() {
        activeStages = new ArrayList<Stage>();
    }

    public void showMainWindow() {
        AbstractController controller = new MainWindowController(this, "MainWindow.fxml");
        initializeStage(controller);
    }

    private void initializeStage(AbstractController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void updateStyles() {
        for(Stage stage: activeStages) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
        }
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }
}


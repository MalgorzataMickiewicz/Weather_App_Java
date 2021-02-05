package com.mm.view;

import com.mm.controller.AbstractController;
import com.mm.controller.MainWindowController;
import com.mm.controller.OptionsWindowController;
import com.mm.controller.ApiConntection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;
    private ArrayList<Stage> activeStages;

    public ViewFactory() {
        activeStages = new ArrayList<Stage>();
    }

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showMainWindow() {
        AbstractController controller = new MainWindowController(this, "MainWindow.fxml");
        initializeStage(controller);
    }

    public void showOptionsWindow() {
        AbstractController controller = new OptionsWindowController(this, "OptionsWindow.fxml");
        initializeStage(controller);
    }

    public void showApiResult() throws IOException {
        ApiConntection api = new ApiConntection();
        api.sendGET();
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
            scene.getStylesheets().add(getClass().getResource(colorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }

    public void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }
}


package com.mm.controller;

import com.mm.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class MainWindowController extends AbstractController {

    @FXML
    private ChoiceBox<?> FirstCountry;

    @FXML
    private ChoiceBox<?> SecondCountry;

    @FXML
    private ChoiceBox<?> FirstCity;

    @FXML
    private ChoiceBox<?> SecondCity;

    @FXML
    private Label LabelFirstCountry;

    @FXML
    private Label LabelSecondCountry;

    @FXML
    private Label LabelFirstCity;

    @FXML
    private Label LabelSecondCity;

    @FXML
    private Label LabelFirstCountry1;

    @FXML
    void optionsAction() {
        viewFactory.showOptionsWindow();
    }

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }
}

package com.mm.controller;

import com.mm.view.ColorTheme;
import com.mm.view.ViewFactory;
import com.mm.view.FontSize;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends AbstractController implements Initializable {

    public OptionsWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Slider fontSizerPicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    @FXML
    void applyButtonAction() {
        viewFactory.setColorTheme(themePicker.getValue());
        viewFactory.setFontSize(FontSize.values()[(int)(fontSizerPicker.getValue())]);
        viewFactory.updateStyles();
    }

    @FXML
    void cancelButtonAction() {
        Stage stage = (Stage) fontSizerPicker.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUpThemePicker();
        setUpSizePicker();
    }

    private void setUpThemePicker() {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(viewFactory.getColorTheme());
    }

    private void setUpSizePicker() {
        fontSizerPicker.setMin(0);
        fontSizerPicker.setMax(FontSize.values().length - 1);
        fontSizerPicker.setValue(viewFactory.getFontSize().ordinal());
        fontSizerPicker.setMajorTickUnit(1);
        fontSizerPicker.setMinorTickCount(0);
        fontSizerPicker.setBlockIncrement(1);
        fontSizerPicker.setSnapToTicks(true);
        fontSizerPicker.setShowTickMarks(true);
        fontSizerPicker.setShowTickLabels(true);

        fontSizerPicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String string) {
                return null;
            }
        });
        fontSizerPicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            fontSizerPicker.setValue(newVal.intValue());
        });
    }
}



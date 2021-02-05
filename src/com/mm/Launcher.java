package com.mm;

import com.mm.view.ViewFactory;
import javafx.application.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javafx.stage.Stage;

public class Launcher<parameters, inputLine> extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showMainWindow();
        viewFactory.updateStyles();
        viewFactory.showApiResult();
    }

}

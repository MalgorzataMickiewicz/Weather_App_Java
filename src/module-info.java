module JavaWeatherApp {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    requires activation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens com.mm;
    opens com.mm.view;
    opens com.mm.controller;
    opens com.mm.model;
}
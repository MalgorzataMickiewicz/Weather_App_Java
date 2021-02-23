package com.mm.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.view.ViewFactory;
import com.mm.Config;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;

public class MainWindowController extends AbstractController implements Initializable {

    private String city = "";
    private String queryFirstCity = "";
    private String querySecondCity = "";
    private String firstCityAdd = "";
    private String secondCityAdd = "";
    private String cityKey = "";
    private String result = "";
    private String tableOfIcons [] = new String [40];

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Text temperatureFirst1;

    @FXML
    private Text descriptionFirst1;

    @FXML
    private TextField firstCityField;

    @FXML
    private Text temperatureFirst2;

    @FXML
    private Text descriptionFirst2;

    @FXML
    private Text temperatureFirst3;

    @FXML
    private Text descriptionFirst3;

    @FXML
    private Text temperatureFirst4;

    @FXML
    private Text descriptionFirst4;

    @FXML
    private Text temperatureFirst5;

    @FXML
    private Text descriptionFirst5;

    @FXML
    private Text temperatureFirst12;

    @FXML
    private Text temperatureFirst22;

    @FXML
    private Text temperatureFirst32;

    @FXML
    private Text temperatureFirst42;

    @FXML
    private Text temperatureFirst52;

    @FXML
    private Text descriptionFirst12;

    @FXML
    private Text descriptionFirst52;

    @FXML
    private Text descriptionFirst22;

    @FXML
    private Text descriptionFirst32;

    @FXML
    private Text descriptionFirst42;

    @FXML
    private TextField secondCityField;

    @FXML
    private Label imageFirst1;

    @FXML
    private Label imageFirst12;

    @FXML
    private Label imageFirst2;

    @FXML
    private Label imageFirst22;

    @FXML
    private Label imageFirst3;

    @FXML
    private Label imageFirst32;

    @FXML
    private Label imageFirst4;

    @FXML
    private Label imageFirst42;

    @FXML
    private Label imageFirst5;

    @FXML
    private Label imageFirst52;

    @FXML
    private Text temperatureSecond1;

    @FXML
    private Text temperatureSecond2;

    @FXML
    private Text temperatureSecond3;

    @FXML
    private Text temperatureSecond4;

    @FXML
    private Text temperatureSecond5;

    @FXML
    private Text descriptionSecond1;

    @FXML
    private Text descriptionSecond2;

    @FXML
    private Text descriptionSecond3;

    @FXML
    private Text descriptionSecond4;

    @FXML
    private Text descriptionSecond5;

    @FXML
    private Text temperatureSecond12;

    @FXML
    private Text temperatureSecond22;

    @FXML
    private Text temperatureSecond32;

    @FXML
    private Text temperatureSecond42;

    @FXML
    private Text temperatureSecond52;

    @FXML
    private Text descriptionSecond12;

    @FXML
    private Text descriptionSecond22;

    @FXML
    private Text descriptionSecond32;

    @FXML
    private Text descriptionSecond42;

    @FXML
    private Text descriptionSecond52;

    @FXML
    private Label imageSecond1;

    @FXML
    private Label imageSecond12;

    @FXML
    private Label imageSecond2;

    @FXML
    private Label imageSecond22;

    @FXML
    private Label imageSecond3;

    @FXML
    private Label imageSecond32;

    @FXML
    private Label imageSecond4;

    @FXML
    private Label imageSecond42;

    @FXML
    private Label imageSecond5;

    @FXML
    private Label imageSecond52;

    @FXML
    private Button Button;

    @FXML
    private Label commentFirstCity;

    @FXML
    private Label commentSecondCity;

    @FXML
    private Label flagFirstCity;

    @FXML
    private Label flagSecondCity;

    @FXML
    void firstCitySearch() throws IOException {
        queryFirstCity = firstCityField.getText();
        querySecondCity = secondCityField.getText();
        city = "First";
        // clear fields
        commentFirstCity.setText("");
        clearDataFromMainWindow(city);

        if(!queryFirstCity.equals("")) {
            result = showAllData(queryFirstCity);
            if(result == "GET request not worked") {
                commentFirstCity.setText("Wyczerpałeś limit wyszukań");
            }
            else if(result == "[]") {
                commentFirstCity.setText("Nie znaleziono miasta");
            }
            else {
                editApiResult(result, city);
                flagFirstCity.setText(queryFirstCity);
                try {
                    String path = "src/com/mm/model/cities";
                    FileWriter fileWriter = new FileWriter(path, false);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(flagFirstCity.getText());
                    bufferedWriter.newLine();
                    if(flagSecondCity.getText().equals("")){
                        bufferedWriter.write("1");
                    }
                    else {
                        bufferedWriter.write(flagSecondCity.getText());
                    }
                    bufferedWriter.close();
                } catch ( IOException e) {
                }
            }
        }
    }

    @FXML
    void secondCitySearch() throws IOException {
        queryFirstCity = firstCityField.getText();
        querySecondCity = secondCityField.getText();
        city = "Second";
        commentSecondCity.setText("");
        clearDataFromMainWindow(city);

        if(!querySecondCity.equals("")) {
            result = showAllData(querySecondCity);
            if(result == "GET request not worked") {
                commentSecondCity.setText("Wyczerpałeś limit wyszukań");
            }
            else if(result == "[]") {
                commentSecondCity.setText("Nie znaleziono miasta");
            }
            else {
                editApiResult(result, city);
                flagSecondCity.setText(querySecondCity);
                try {
                    String path = "src/com/mm/model/cities";
                    FileWriter fileWriter = new FileWriter(path, false);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    if(flagFirstCity.getText().equals("")){
                        bufferedWriter.write("1");
                    }
                    else {
                        bufferedWriter.write(flagFirstCity.getText());
                    }
                    bufferedWriter.newLine();
                    bufferedWriter.write(flagSecondCity.getText());
                    bufferedWriter.close();
                } catch ( IOException e) {
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // run addCitiesToMainWindow method
        Button.fire();
    }

    public void addCitiesToMainWindow() {
        try {
            File file = new File("src/com/mm/model/cities");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int counter = 0;
            while((line = bufferedReader.readLine()) != null) {
                if(line.contains("1")){
                    counter++;
                    if(counter == 1){
                        firstCityAdd = "";
                    }
                    else {
                        secondCityAdd = "";
                    }
                }
                else {
                    counter++;
                    if(counter == 1){
                        firstCityAdd = line;
                    }
                    else {
                        secondCityAdd = line;
                    }
                }
            }
            counter = 0;
            firstCityField.setText(firstCityAdd);
            secondCityField.setText(secondCityAdd);
            if(firstCityAdd != "1") {
                firstCitySearch();
            }
            if(secondCityAdd != "1") {
                secondCitySearch();
            }
        } catch (IOException e) { e.printStackTrace();}
    }

    private String showAllData(String query) throws IOException {
        String queryEncoding = URLEncoder.encode(query, "UTF-8");
        ApiConnection api = new ApiConnection();
        Config config = new Config();
        String apiKey = config.getApiKey();
        cityKey = api.sendGET("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=" + apiKey + "=" + queryEncoding + "&language=pl-PL&details=Key");
        return api.sendGET("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + cityKey + "?apikey=" + apiKey + "&language=pl-PL");
    }

    private void clearDataFromMainWindow(String city) {
        if(city.equals("First")) {
            clearTemperatureFirstCity();
            clearDescriptionFirstCity();
            clearImageIconsFirstCity();
        }
        else if(city.equals("Second")) {
            clearTemperatureSecondCity();
            clearDescriptionSecondCity();
            clearImageIconsSecondCity();
        }
    }

    private void clearImageIconsSecondCity() {
        ImageView imageView;
        imageView = new ImageView(getClass().getResource("weathericons/0.png").toExternalForm());
        imageSecond1.setGraphic(imageView);
        imageSecond2.setGraphic(imageView);
        imageSecond3.setGraphic(imageView);
        imageSecond4.setGraphic(imageView);
        imageSecond5.setGraphic(imageView);
        imageSecond12.setGraphic(imageView);
        imageSecond22.setGraphic(imageView);
        imageSecond32.setGraphic(imageView);
        imageSecond42.setGraphic(imageView);
        imageSecond52.setGraphic(imageView);
    }

    private void clearDescriptionSecondCity() {
        descriptionSecond1.setText("");
        descriptionSecond2.setText("");
        descriptionSecond3.setText("");
        descriptionSecond4.setText("");
        descriptionSecond5.setText("");
        descriptionSecond12.setText("");
        descriptionSecond22.setText("");
        descriptionSecond32.setText("");
        descriptionSecond42.setText("");
        descriptionSecond52.setText("");
    }

    private void clearTemperatureSecondCity() {
        temperatureSecond1.setText("");
        temperatureSecond2.setText("");
        temperatureSecond3.setText("");
        temperatureSecond4.setText("");
        temperatureSecond5.setText("");
        temperatureSecond12.setText("");
        temperatureSecond22.setText("");
        temperatureSecond32.setText("");
        temperatureSecond42.setText("");
        temperatureSecond52.setText("");
    }

    private void clearImageIconsFirstCity() {
        ImageView imageView;
        imageView = new ImageView(getClass().getResource("weathericons/0.png").toExternalForm());
        imageFirst1.setGraphic(imageView);
        imageFirst2.setGraphic(imageView);
        imageFirst3.setGraphic(imageView);
        imageFirst4.setGraphic(imageView);
        imageFirst5.setGraphic(imageView);
        imageFirst12.setGraphic(imageView);
        imageFirst22.setGraphic(imageView);
        imageFirst32.setGraphic(imageView);
        imageFirst42.setGraphic(imageView);
        imageFirst52.setGraphic(imageView);
    }

    private void clearDescriptionFirstCity() {
        descriptionFirst1.setText("");
        descriptionFirst2.setText("");
        descriptionFirst3.setText("");
        descriptionFirst4.setText("");
        descriptionFirst5.setText("");
        descriptionFirst12.setText("");
        descriptionFirst22.setText("");
        descriptionFirst32.setText("");
        descriptionFirst42.setText("");
        descriptionFirst52.setText("");
    }

    private void clearTemperatureFirstCity() {
        temperatureFirst1.setText("");
        temperatureFirst2.setText("");
        temperatureFirst3.setText("");
        temperatureFirst4.setText("");
        temperatureFirst5.setText("");
        temperatureFirst12.setText("");
        temperatureFirst22.setText("");
        temperatureFirst32.setText("");
        temperatureFirst42.setText("");
        temperatureFirst52.setText("");
    }



    private void editApiResult(String result, String city) {
        addValuesToTableOfIcons();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String tableTemperatureMinimum [] = new String[5];
            String tableTemperatureMaximum [] = new String[5];
            String tableDescriptionDay [] = new String[5];
            String tableDescriptionNight [] = new String[5];
            String tableIconNight [] = new String[5];
            String tableIconDay [] = new String[5];

            JsonNode jsonNode = objectMapper.readValue(result, JsonNode.class);
            JsonNode object = jsonNode.get("DailyForecasts");
            for(int i = 0; i < 5; i++) {
                JsonNode array = object.get(i);
                JsonNode temperature = array.get("Temperature");
                JsonNode temperatureMinimumObject = temperature.get("Minimum");
                JsonNode temperatureMinimumNode = temperatureMinimumObject.get("Value");
                String temperatureMinimumString = temperatureMinimumNode.toString();
                float temperatureMinimumFloat = (float) ((Float.valueOf(temperatureMinimumString))-32/1.8);
                int temperatureMinimumFloatRound = Math.round(temperatureMinimumFloat);
                tableTemperatureMinimum[i] = String.valueOf(temperatureMinimumFloatRound);
                JsonNode temperatureMaximumObject = temperature.get("Maximum");
                JsonNode temperatureMaximumNode = temperatureMaximumObject.get("Value");
                String temperatureMaximumString = temperatureMaximumNode.toString();
                float temperatureMaximumFloat = (float) ((Float.valueOf(temperatureMaximumString))-32/1.8);
                int temperatureMaximumFloatRound = Math.round(temperatureMaximumFloat);
                tableTemperatureMaximum[i] = String.valueOf(temperatureMaximumFloatRound);
                JsonNode day = array.get("Day");
                JsonNode dayDescriptionObject = day.get("IconPhrase");
                String dayDescriptionString = (dayDescriptionObject.toString()).replace("\"", "");
                tableDescriptionDay[i] = dayDescriptionString;
                JsonNode dayIconObject = day.get("Icon");
                String dayIconString = dayIconObject.toString();
                tableIconDay[i] = dayIconString;
                JsonNode night = array.get("Night");
                JsonNode nightDescriptionObject = night.get("IconPhrase");
                String nightDescriptionString = (nightDescriptionObject.toString()).replace("\"", "");
                tableDescriptionNight[i] = nightDescriptionString;
                JsonNode nightIconObject = night.get("Icon");
                String nightIconString = nightIconObject.toString();
                tableIconNight[i] = nightIconString;
            }
            String tableOfIconReusltDay [] = new String[5];
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 40; k++){
                    if(tableIconDay[j].equals(tableOfIcons[k])) {
                        tableOfIconReusltDay[j] = tableOfIcons[k];
                        break;
                    }
                }
            }
            String tableOfIconReusltNight [] = new String[5];
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 40; k++){
                    if(tableIconNight[j].equals(tableOfIcons[k])) {
                        tableOfIconReusltNight[j] = tableOfIcons[k];
                        break;
                    }
                }
            }
            if(city.equals("First")) {
                addTemperaturesToFirstCity(tableTemperatureMaximum, tableTemperatureMinimum);
                addDescriptionsToFirstCity(tableDescriptionDay, tableDescriptionNight);
                addIconsToFirstCity(tableOfIconReusltDay, tableOfIconReusltNight);
            }
            else if(city.equals("Second")){
                addTemperaturesToSecondCity(tableTemperatureMaximum, tableTemperatureMinimum);
                addDescriptionsToSecondCity(tableDescriptionDay, tableDescriptionNight);
                addIconsToSecondCity(tableOfIconReusltDay, tableOfIconReusltNight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addValuesToTableOfIcons() {
        tableOfIcons[0] = "1";
        tableOfIcons[1] = "2";
        tableOfIcons[2] = "3";
        tableOfIcons[3] = "4";
        tableOfIcons[4] = "5";
        tableOfIcons[5] = "6";
        tableOfIcons[6] = "7";
        tableOfIcons[7] = "8";
        tableOfIcons[8] = "11";
        tableOfIcons[9] = "12";
        tableOfIcons[10] = "13";
        tableOfIcons[11] = "14";
        tableOfIcons[12] = "15";
        tableOfIcons[13] = "16";
        tableOfIcons[14] = "17";
        tableOfIcons[15] = "18";
        tableOfIcons[16] = "19";
        tableOfIcons[17] = "20";
        tableOfIcons[18] = "21";
        tableOfIcons[19] = "22";
        tableOfIcons[20] = "23";
        tableOfIcons[21] = "24";
        tableOfIcons[22] = "25";
        tableOfIcons[23] = "26";
        tableOfIcons[24] = "29";
        tableOfIcons[25] = "30";
        tableOfIcons[26] = "31";
        tableOfIcons[27] = "32";
        tableOfIcons[28] = "33";
        tableOfIcons[29] = "34";
        tableOfIcons[30] = "35";
        tableOfIcons[31] = "36";
        tableOfIcons[32] = "37";
        tableOfIcons[33] = "38";
        tableOfIcons[34] = "39";
        tableOfIcons[35] = "40";
        tableOfIcons[36] = "41";
        tableOfIcons[37] = "42";
        tableOfIcons[38] = "43";
        tableOfIcons[39] = "44";
    }

    private void addTemperaturesToFirstCity(String[] tableTemperatureMaximum, String[] tableTemperatureMinimum) {
        temperatureFirst1.setText(tableTemperatureMaximum[0] + "°C");
        temperatureFirst2.setText(tableTemperatureMaximum[1] + "°C");
        temperatureFirst3.setText(tableTemperatureMaximum[2] + "°C");
        temperatureFirst4.setText(tableTemperatureMaximum[3] + "°C");
        temperatureFirst5.setText(tableTemperatureMaximum[4] + "°C");
        temperatureFirst12.setText(tableTemperatureMinimum[0] + "°C");
        temperatureFirst22.setText(tableTemperatureMinimum[1] + "°C");
        temperatureFirst32.setText(tableTemperatureMinimum[2] + "°C");
        temperatureFirst42.setText(tableTemperatureMinimum[3] + "°C");
        temperatureFirst52.setText(tableTemperatureMinimum[4] + "°C");
    }

    private void addTemperaturesToSecondCity(String[] tableTemperatureMaximum, String[] tableTemperatureMinimum) {
        temperatureSecond1.setText(tableTemperatureMaximum[0] + "°C");
        temperatureSecond2.setText(tableTemperatureMaximum[1] + "°C");
        temperatureSecond3.setText(tableTemperatureMaximum[2] + "°C");
        temperatureSecond4.setText(tableTemperatureMaximum[3] + "°C");
        temperatureSecond5.setText(tableTemperatureMaximum[4] + "°C");
        temperatureSecond12.setText(tableTemperatureMinimum[0] + "°C");
        temperatureSecond22.setText(tableTemperatureMinimum[1] + "°C");
        temperatureSecond32.setText(tableTemperatureMinimum[2] + "°C");
        temperatureSecond42.setText(tableTemperatureMinimum[3] + "°C");
        temperatureSecond52.setText(tableTemperatureMinimum[4] + "°C");
    }

    private void addDescriptionsToFirstCity(String[] tableDescriptionDay, String[] tableDescriptionNight) {
        descriptionFirst1.setText(tableDescriptionDay[0]);
        descriptionFirst2.setText(tableDescriptionDay[1]);
        descriptionFirst3.setText(tableDescriptionDay[2]);
        descriptionFirst4.setText(tableDescriptionDay[3]);
        descriptionFirst5.setText(tableDescriptionDay[4]);
        descriptionFirst12.setText(tableDescriptionNight[0]);
        descriptionFirst22.setText(tableDescriptionNight[1]);
        descriptionFirst32.setText(tableDescriptionNight[2]);
        descriptionFirst42.setText(tableDescriptionNight[3]);
        descriptionFirst52.setText(tableDescriptionNight[4]);
    }

    private void addDescriptionsToSecondCity(String[] tableDescriptionDay, String[] tableDescriptionNight) {
        descriptionSecond1.setText(tableDescriptionDay[0]);
        descriptionSecond2.setText(tableDescriptionDay[1]);
        descriptionSecond3.setText(tableDescriptionDay[2]);
        descriptionSecond4.setText(tableDescriptionDay[3]);
        descriptionSecond5.setText(tableDescriptionDay[4]);
        descriptionSecond12.setText(tableDescriptionNight[0]);
        descriptionSecond22.setText(tableDescriptionNight[1]);
        descriptionSecond32.setText(tableDescriptionNight[2]);
        descriptionSecond42.setText(tableDescriptionNight[3]);
        descriptionSecond52.setText(tableDescriptionNight[4]);
    }

    private void addIconsToFirstCity(String[] tableOfIconReusltDay, String[] tableOfIconReusltNight) {
        ImageView imageView;
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[0] + ".png").toExternalForm());
        imageFirst1.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[1] + ".png").toExternalForm());
        imageFirst2.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[2] + ".png").toExternalForm());
        imageFirst3.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[3] + ".png").toExternalForm());
        imageFirst4.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[4] + ".png").toExternalForm());
        imageFirst5.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[0] + ".png").toExternalForm());
        imageFirst12.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[1] + ".png").toExternalForm());
        imageFirst22.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[2] + ".png").toExternalForm());
        imageFirst32.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[3] + ".png").toExternalForm());
        imageFirst42.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[4] + ".png").toExternalForm());
        imageFirst52.setGraphic(imageView);
    }

    private void addIconsToSecondCity(String[] tableOfIconReusltDay, String[] tableOfIconReusltNight) {
        ImageView imageView;
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[0] + ".png").toExternalForm());
        imageSecond1.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[1] + ".png").toExternalForm());
        imageSecond2.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[2] + ".png").toExternalForm());
        imageSecond3.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[3] + ".png").toExternalForm());
        imageSecond4.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltDay[4] + ".png").toExternalForm());
        imageSecond5.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[0] + ".png").toExternalForm());
        imageSecond12.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[1] + ".png").toExternalForm());
        imageSecond22.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[2] + ".png").toExternalForm());
        imageSecond32.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[3] + ".png").toExternalForm());
        imageSecond42.setGraphic(imageView);
        imageView = new ImageView(getClass().getResource("weathericons/" + tableOfIconReusltNight[4] + ".png").toExternalForm());
        imageSecond52.setGraphic(imageView);
    }
}

package com.mm.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.view.ViewFactory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainWindowController extends AbstractController implements Initializable {

    private String city;
    private String queryFirstCity;
    private String querySecondCity;
    private String firstCityAdd = "";
    private String secondCityAdd = "";

    String result = "{\n" +
            "  \"Headline\": {\n" +
            "    \"EffectiveDate\": \"2021-02-05T19:00:00+01:00\",\n" +
            "    \"EffectiveEpochDate\": 1612548000,\n" +
            "    \"Severity\": 3,\n" +
            "    \"Text\": \"Opad śniegu od: piątek wieczór do: sobota wieczór, ilość: cienka warstwa do jednego cala\",\n" +
            "    \"Category\": \"snow\",\n" +
            "    \"EndDate\": \"2021-02-07T01:00:00+01:00\",\n" +
            "    \"EndEpochDate\": 1612656000,\n" +
            "    \"MobileLink\": \"http://m.accuweather.com/pl/pl/krakow/274455/extended-weather-forecast/274455\",\n" +
            "    \"Link\": \"http://www.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455\"\n" +
            "  },\n" +
            "  \"DailyForecasts\": [\n" +
            "    {\n" +
            "      \"Date\": \"2021-02-04T07:00:00+01:00\",\n" +
            "      \"EpochDate\": 1612418400,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 29,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 45,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 18,\n" +
            "        \"IconPhrase\": \"Deszcz\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Rain\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 19,\n" +
            "        \"IconPhrase\": \"Opady topniejącego śniegu\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Snow\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=1\",\n" +
            "      \"Link\": \"http://www.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=1\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2021-02-05T07:00:00+01:00\",\n" +
            "      \"EpochDate\": 1612504800,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 23,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 35,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 6,\n" +
            "        \"IconPhrase\": \"Zachmurzenie duże\",\n" +
            "         \"PrecipitationType\": \"Snow\",\n" +
            "        \"HasPrecipitation\": false\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 19,\n" +
            "        \"IconPhrase\": \"Opady topniejącego śniegu\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Snow\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=2\",\n" +
            "      \"Link\": \"http://www.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=2\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2021-02-06T07:00:00+01:00\",\n" +
            "      \"EpochDate\": 1612591200,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 19,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 30,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 19,\n" +
            "        \"IconPhrase\": \"Opady topniejącego śniegu\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Snow\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 24,\n" +
            "        \"IconPhrase\": \"Lód\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Ice\",\n" +
            "        \"PrecipitationIntensity\": \"Moderate\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=3\",\n" +
            "      \"Link\": \"http://www.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=3\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2021-02-07T07:00:00+01:00\",\n" +
            "      \"EpochDate\": 1612677600,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 19,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 25,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 19,\n" +
            "        \"IconPhrase\": \"Opady topniejącego śniegu\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Snow\",\n" +
            "        \"PrecipitationIntensity\": \"Light\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 24,\n" +
            "        \"IconPhrase\": \"Lód\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Ice\",\n" +
            "        \"PrecipitationIntensity\": \"Moderate\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=4\",\n" +
            "      \"Link\": \"http://www.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=4\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Date\": \"2021-02-08T07:00:00+01:00\",\n" +
            "      \"EpochDate\": 1612764000,\n" +
            "      \"Temperature\": {\n" +
            "        \"Minimum\": {\n" +
            "          \"Value\": 15,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        },\n" +
            "        \"Maximum\": {\n" +
            "          \"Value\": 25,\n" +
            "          \"Unit\": \"F\",\n" +
            "          \"UnitType\": 18\n" +
            "        }\n" +
            "      },\n" +
            "      \"Day\": {\n" +
            "        \"Icon\": 22,\n" +
            "        \"IconPhrase\": \"Śnieg\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Snow\",\n" +
            "        \"PrecipitationIntensity\": \"Moderate\"\n" +
            "      },\n" +
            "      \"Night\": {\n" +
            "        \"Icon\": 22,\n" +
            "        \"IconPhrase\": \"Śnieg\",\n" +
            "        \"HasPrecipitation\": true,\n" +
            "        \"PrecipitationType\": \"Mixed\",\n" +
            "        \"PrecipitationIntensity\": \"Moderate\"\n" +
            "      },\n" +
            "      \"Sources\": [\n" +
            "        \"AccuWeather\"\n" +
            "      ],\n" +
            "      \"MobileLink\": \"http://m.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=5\",\n" +
            "      \"Link\": \"http://www.accuweather.com/pl/pl/krakow/274455/daily-weather-forecast/274455?day=5\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

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
    void firstCitySearch() throws IOException {
        queryFirstCity = firstCityField.getText();
        querySecondCity = secondCityField.getText();
        city = "First";

        try {
            String path = "src/com/mm/model/cities";
            FileWriter fileWriter = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            if(queryFirstCity.equals("")){
                bufferedWriter.write("1");
                bufferedWriter.newLine();
            }
            else {
                bufferedWriter.write(queryFirstCity);
                bufferedWriter.newLine();
            }
            if(querySecondCity.equals("")){
                bufferedWriter.write("1");
                bufferedWriter.newLine();
            }
            else {
                bufferedWriter.write(querySecondCity);
            }
            bufferedWriter.close();
        } catch ( IOException e) {
            System.out.println("Błąd");
        }
        //ApiConnection api = new ApiConnection();
        //api.sendGET(querySecondCity);
        editApiResult(result, city);
    }

    @FXML
    private Button Button;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    private String showAllData(String query) throws IOException {
        ApiConnection api = new ApiConnection();
        return api.sendGET(query);
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
                       // firstCitySearch();
                    }
                    else {
                        secondCityAdd = line;
                       // secondCitySearch();
                    }
                }
            }
            counter = 0;
            firstCityField.setText(firstCityAdd);
            secondCityField.setText(secondCityAdd);
            // ApiConnection api = new ApiConnection();
            // api.sendGET(querySecondCity);
        } catch (IOException e) { e.printStackTrace();}
    }

    @FXML
    void secondCitySearch() throws IOException {
        queryFirstCity = firstCityField.getText();
        querySecondCity = secondCityField.getText();
        city = "Second";

        try {
            String path = "src/com/mm/model/cities";
            FileWriter fileWriter = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(queryFirstCity);
            bufferedWriter.newLine();
            bufferedWriter.write(querySecondCity);

            bufferedWriter.close();
        } catch ( IOException e) {
            System.out.println("Błąd");
        }
        //ApiConnection api = new ApiConnection();
        //api.sendGET(querySecondCity);
        editApiResult(result, city);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button.fire();
    }

    private void editApiResult(String result, String city) {

        String tableOfIcons [] = new String [40];
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

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String tableTemperatureMinimum [] = new String[5];
            String tableTemperatureMaximum [] = new String[5];
            String tableDescriptionDay [] = new String[5];
            String tableDescriptionNight [] = new String[5];
            String tableIconNight [] = new String[5];
            String tableIconDay [] = new String[5];

            JsonNode jsonNode = objectMapper.readValue(result, JsonNode.class);
            // Object
            JsonNode object = jsonNode.get("DailyForecasts");
            // Object in nestObject: Temperature
            for(int i = 0; i < 5; i++) {
                JsonNode array = object.get(i);
                // Value of object
                JsonNode temperature = array.get("Temperature");
                // Temperature minimum
                JsonNode temperatureMinimumObject = temperature.get("Minimum");
                JsonNode temperatureMinimumNode = temperatureMinimumObject.get("Value");
                String temperatureMinimumString = temperatureMinimumNode.toString();
                float temperatureMinimumFloat = (float) ((Float.valueOf(temperatureMinimumString))-32/1.8);
                int temperatureMinimumFloatRound = Math.round(temperatureMinimumFloat);
                tableTemperatureMinimum[i] = String.valueOf(temperatureMinimumFloatRound);
                //Temperature maximum
                JsonNode temperatureMaximumObject = temperature.get("Maximum");
                JsonNode temperatureMaximumNode = temperatureMaximumObject.get("Value");
                String temperatureMaximumString = temperatureMaximumNode.toString();
                float temperatureMaximumFloat = (float) ((Float.valueOf(temperatureMaximumString))-32/1.8);
                int temperatureMaximumFloatRound = Math.round(temperatureMaximumFloat);
                tableTemperatureMaximum[i] = String.valueOf(temperatureMaximumFloatRound);
                // Day description
                // Value of object
                JsonNode day = array.get("Day");
                JsonNode dayDescriptionObject = day.get("IconPhrase");
                String dayDescriptionString = (dayDescriptionObject.toString()).replace("\"", "");
                tableDescriptionDay[i] = dayDescriptionString;
                // Icon number
                JsonNode dayIconObject = day.get("Icon");
                String dayIconString = dayIconObject.toString();
                tableIconDay[i] = dayIconString;
                // Night description
                // Value of object
                JsonNode night = array.get("Night");
                JsonNode nightDescriptionObject = night.get("IconPhrase");
                String nightDescriptionString = (nightDescriptionObject.toString()).replace("\"", "");
                tableDescriptionNight[i] = nightDescriptionString;
                // Icon number
                JsonNode nightIconObject = night.get("Icon");
                String nightIconString = nightIconObject.toString();
                tableIconNight[i] = nightIconString;
            }
            // Day Icon
            String tableOfIconReusltDay [] = new String[5];
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 40; k++){
                    if(tableIconDay[j].equals(tableOfIcons[k])) {
                        tableOfIconReusltDay[j] = tableOfIcons[k];
                        break;
                    }
                }
            }
            // Night Icon
            String tableOfIconReusltNight [] = new String[5];
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 40; k++){
                    if(tableIconNight[j].equals(tableOfIcons[k])) {
                        tableOfIconReusltNight[j] = tableOfIcons[k];
                        break;
                    }
                }
            }
            // add values to fields
            if(city.equals("First")) {
                // Maximum temperature
                temperatureFirst1.setText(tableTemperatureMaximum[0] + "°C");
                temperatureFirst2.setText(tableTemperatureMaximum[1] + "°C");
                temperatureFirst3.setText(tableTemperatureMaximum[2] + "°C");
                temperatureFirst4.setText(tableTemperatureMaximum[3] + "°C");
                temperatureFirst5.setText(tableTemperatureMaximum[4] + "°C");
                // Minimum temperature
                temperatureFirst12.setText(tableTemperatureMinimum[0] + "°C");
                temperatureFirst22.setText(tableTemperatureMinimum[1] + "°C");
                temperatureFirst32.setText(tableTemperatureMinimum[2] + "°C");
                temperatureFirst42.setText(tableTemperatureMinimum[3] + "°C");
                temperatureFirst52.setText(tableTemperatureMinimum[4] + "°C");
                // Day description
                descriptionFirst1.setText(tableDescriptionDay[0]);
                descriptionFirst2.setText(tableDescriptionDay[1]);
                descriptionFirst3.setText(tableDescriptionDay[2]);
                descriptionFirst4.setText(tableDescriptionDay[3]);
                descriptionFirst5.setText(tableDescriptionDay[4]);
                // Night description
                descriptionFirst12.setText(tableDescriptionNight[0]);
                descriptionFirst22.setText(tableDescriptionNight[1]);
                descriptionFirst32.setText(tableDescriptionNight[2]);
                descriptionFirst42.setText(tableDescriptionNight[3]);
                descriptionFirst52.setText(tableDescriptionNight[4]);

                ImageView imageView;
                // Day Icon
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
                // Night Icon
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
            else if(city.equals("Second")){
                // Maximum temperature
                temperatureSecond1.setText(tableTemperatureMaximum[0] + "°C");
                temperatureSecond2.setText(tableTemperatureMaximum[1] + "°C");
                temperatureSecond3.setText(tableTemperatureMaximum[2] + "°C");
                temperatureSecond4.setText(tableTemperatureMaximum[3] + "°C");
                temperatureSecond5.setText(tableTemperatureMaximum[4] + "°C");
                // Minimum temperature
                temperatureSecond12.setText(tableTemperatureMinimum[0] + "°C");
                temperatureSecond22.setText(tableTemperatureMinimum[1] + "°C");
                temperatureSecond32.setText(tableTemperatureMinimum[2] + "°C");
                temperatureSecond42.setText(tableTemperatureMinimum[3] + "°C");
                temperatureSecond52.setText(tableTemperatureMinimum[4] + "°C");
                // Day description
                descriptionSecond1.setText(tableDescriptionDay[0]);
                descriptionSecond2.setText(tableDescriptionDay[1]);
                descriptionSecond3.setText(tableDescriptionDay[2]);
                descriptionSecond4.setText(tableDescriptionDay[3]);
                descriptionSecond5.setText(tableDescriptionDay[4]);
                // Night description
                descriptionSecond12.setText(tableDescriptionNight[0]);
                descriptionSecond22.setText(tableDescriptionNight[1]);
                descriptionSecond32.setText(tableDescriptionNight[2]);
                descriptionSecond42.setText(tableDescriptionNight[3]);
                descriptionSecond52.setText(tableDescriptionNight[4]);

                ImageView imageView;
                // Day Icon
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
                // Night Icon
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

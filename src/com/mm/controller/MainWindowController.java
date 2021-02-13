package com.mm.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mm.view.ViewFactory;

import com.mm.view.WeatherIcon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends AbstractController implements Initializable {

    private String query;
    private WeatherIcon weatherIcon = WeatherIcon.DEFAULT;

    public WeatherIcon getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(WeatherIcon weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    @FXML
    private Label image1;

    @FXML
    private Label image12;

    @FXML
    private Label LabelFirstCountry1;

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
    private Text temperatureSecond1;

    @FXML
    private Text descriptionSecond1;

    @FXML
    private Text temperatureSecond2;

    @FXML
    private Text descriptionSecond2;

    @FXML
    private Text temperatureSecond3;

    @FXML
    private Text descriptionSecond3;

    @FXML
    private Text temperatureSecond4;

    @FXML
    private Text descriptionSecond4;

    @FXML
    private Text temperatureSecond5;

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
    private Text descriptionSecond52;

    @FXML
    private Text descriptionSecond22;

    @FXML
    private Text descriptionSecond32;

    @FXML
    private Text descriptionSecond42;


    @FXML
    void firstCitySearch() throws IOException {
        query = firstCityField.getText();
        /*
        String GET_URL = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=MKl30gDCP4lhvUBSSGvGJq3EL4LkuZwI&q=" + query + "&language=pl-PL&details=Key";
        String key = showAllData(GET_URL);
        String query = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + key + "?apikey=MKl30gDCP4lhvUBSSGvGJq3EL4LkuZwI&language=pl-PL";
        String result = showAllData(query);
        editApiResult(result);
        testLabel.setText(result);
         */
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
        editApiResult(result);
    }

    @FXML
    void optionsAction() {
        viewFactory.showOptionsWindow();
    }

    @FXML
    void secondCitySearch() {

    }

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    private String showAllData(String query) throws IOException {
        ApiConnection api = new ApiConnection();
        return api.sendGET(query);
    }

    private void editApiResult(String result) {
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
                String dayDescriptionString = dayDescriptionObject.toString();
                tableDescriptionDay[i] = dayDescriptionString;
                // Icon
                JsonNode dayIconObject = day.get("PrecipitationType");
                String dayIconString = dayIconObject.toString();
                tableIconDay[i] = dayIconString;
                // Night description
                // Value of object
                JsonNode night = array.get("Night");
                JsonNode nightDescriptionObject = night.get("IconPhrase");
                String nightDescriptionString = nightDescriptionObject.toString();
                tableDescriptionNight[i] = nightDescriptionString;
                // Icon
                JsonNode nightIconObject = night.get("PrecipitationType");
                String nightIconString = nightIconObject.toString();
                String nightIconStringWithoutQuote = nightIconString.replace("\"", "");
                tableIconNight[i] = nightIconStringWithoutQuote;
            }
            // add values to fields
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
            // Day Icon

            // Night Icon
            ImageView imageView;
            String tabletest [] = new String [1];
            tabletest[0] = "Snow";
            String tableOfIcons [] = new String [13];
            tableOfIcons[0] = "";
            for(int j = 0; j < 5; j++) {
                if(tableIconNight[0].equals(tabletest[0])) {
                    imageView = new ImageView(getClass().getResource("weathericons/SNOW.png").toExternalForm());
                    image1.setGraphic(imageView);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

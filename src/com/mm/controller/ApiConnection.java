package com.mm.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {

    public String sendGET(String GET_URL) throws IOException {
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        StringBuffer response = new StringBuffer();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } else {
            System.out.println("GET request not worked");
        }
        String cityKey = "";

        if(GET_URL.contains("Key")) {
            for(int i = 21; i < 27; i++) {
                cityKey += response.toString().charAt(i);
            }
            return cityKey;
        }

        return response.toString();
    }
}

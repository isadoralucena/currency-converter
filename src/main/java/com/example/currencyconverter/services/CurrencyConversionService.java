package main.java.com.example.currencyconverter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.java.com.example.currencyconverter.dtos.CurrencyDTO;
import main.java.com.example.currencyconverter.models.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConversionService {
    private final String apiKey;

    public CurrencyConversionService(String apiKey) {
        this.apiKey = apiKey;
    }

    public String connectConversionRateAPI(String initialAcronym) throws IOException, InterruptedException {
        String address = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, initialAcronym);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(address)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public double conversion(String initialAcronym, String finalAcronym, double value) throws IOException, InterruptedException {

        String json = connectConversionRateAPI(initialAcronym);
        Currency currency = jsonForCurrencyObject(json);
        Double conversionRate = getConversionRate(currency, finalAcronym);

        if (conversionRate == null) {
            throw new IllegalArgumentException("Taxa de conversão não encontrada para a moeda: " + finalAcronym);
        }

        currency.setValue(value * conversionRate);
        return currency.getValue();
    }

    public Currency jsonForCurrencyObject(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        CurrencyDTO currencyDTO = gson.fromJson(json, CurrencyDTO.class);
        return new Currency(currencyDTO);
    }

    public Double getConversionRate(Currency currency, String finalAcronym){
        return currency.getConversionsRate().get(finalAcronym);
    }
}

package main.java.com.example.currencyconverter;

import main.java.com.example.currencyconverter.services.CurrencyConversionService;
import main.java.com.example.currencyconverter.utils.ConfigLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String apiKey = ConfigLoader.loadApiKey();
        if (apiKey == null) {
            System.out.println("Não foi possível carregar a chave da API. Verifique o arquivo de configuração.");
            return;
        }

        CurrencyConversionService service = new CurrencyConversionService(apiKey);
        Menu menu = new Menu(service);
        menu.displayMenu();
    }
}
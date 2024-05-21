package main.java.com.example.currencyconverter.models;

import main.java.com.example.currencyconverter.dtos.CurrencyDTO;

import java.util.Map;

public class Currency {
    private String acronym;
    private double value;
    private Map <String, Double> conversionsRate;

    public Currency(CurrencyDTO currencyDTO) {
        this.acronym = currencyDTO.base_code();
        this.conversionsRate = currencyDTO.conversion_rates();
    }

    public Map<String, Double> getConversionsRate() {
        return conversionsRate;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}

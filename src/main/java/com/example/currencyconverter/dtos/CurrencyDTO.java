package main.java.com.example.currencyconverter.dtos;

import java.util.Map;

public record CurrencyDTO(String base_code, Map<String, Double> conversion_rates) {
}

package main.java.com.example.currencyconverter;

import main.java.com.example.currencyconverter.enums.MenuOption;
import main.java.com.example.currencyconverter.services.CurrencyConversionService;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private final CurrencyConversionService service;

    public Menu(CurrencyConversionService service) {
        this.service = service;
    }

    public void displayMenu() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        MenuOption option = null;

        while (option != MenuOption.EXIT) {
            System.out.println("\n***********************");
            System.out.println("$ Conversor de Moedas $");
            System.out.println("***********************");

            System.out.println("\nEscolha uma opção válida:");

            for (MenuOption menuOption : MenuOption.values()) {
                System.out.println(menuOption.getOption() + ") " + menuOption.getDescription());
            }

            int userInput = sc.nextInt();
            option = MenuOption.fromOption(userInput);

            if (option == null) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                continue;
            }

            if (option == MenuOption.EXIT) {
                break;
            }

            System.out.println("Informe o valor da moeda que deseja converter: ");
            double value = sc.nextDouble();

            try {
                double convertedValue = handleConversion(option, value);
                System.out.println("Valor convertido: " + convertedValue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
        System.out.println("\n*******************************************");
        System.out.println("$ Obrigado por usar o Conversor de Moedas $");
        System.out.println("*******************************************");
    }

    private double handleConversion(MenuOption option, double value) throws IOException, InterruptedException {
        switch (option) {
            case USD_TO_ARS:
                return service.conversion("USD", "ARS", value);
            case ARS_TO_USD:
                return service.conversion("ARS", "USD", value);
            case USD_TO_BRL:
                return service.conversion("USD", "BRL", value);
            case BRL_TO_USD:
                return service.conversion("BRL", "USD", value);
            case USD_TO_COP:
                return service.conversion("USD", "COP", value);
            case COP_TO_USD:
                return service.conversion("COP", "USD", value);
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }
}

package main.java.com.example.currencyconverter.enums;

public enum MenuOption {
    USD_TO_ARS(1, "Dólar => Peso argentino"),
    ARS_TO_USD(2, "Peso argentino => Dólar"),
    USD_TO_BRL(3, "Dólar => Real brasileiro"),
    BRL_TO_USD(4, "Real brasileiro => Dólar"),
    USD_TO_COP(5, "Dólar => Peso colombiano"),
    COP_TO_USD(6, "Peso colombiano => Dólar"),
    EXIT(7, "Sair");

    private final int option;
    private final String description;

    MenuOption(int option, String description) {
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public static MenuOption fromOption(int option) {
        for (MenuOption menuOption : values()) {
            if (menuOption.option == option) {
                return menuOption;
            }
        }
        return null;
    }
}


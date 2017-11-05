package com.example.abeeb.alc.utilities;

import java.util.Currency;

/**
 * Created by ABEEB on 11/5/2017.
 */

public class CurrencySymbol {

    public static String getSymbol(String currency_code) {
        Currency currency = Currency.getInstance(currency_code);
        return currency.getSymbol();
    }
}

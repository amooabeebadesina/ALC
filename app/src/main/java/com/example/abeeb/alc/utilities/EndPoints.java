package com.example.abeeb.alc.utilities;

import com.example.abeeb.alc.entities.Currency;
import java.util.List;

/**
 * Created by ABEEB on 11/5/2017.
 */

public class EndPoints {



    private static String BASE_URL = "https://min-api.cryptocompare.com/data/price";

    public EndPoints() {

    }

    public static String getCurrenciesURL() {
        String url = BASE_URL + "?fsym=BTC&tsyms=";
        List<Currency> currencies = CurrencyList.getCurrencies();
        for (Currency currency: currencies) {
            url += currency.getCode() + ",";
        }
        return url;
    }

    public static String getSingleCurrency(String code) {
        String url = BASE_URL + "?fsym=BTC&tsyms=";
        url += code;
        return url;
    }
}

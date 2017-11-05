package com.example.abeeb.alc.utilities;

import com.example.abeeb.alc.entities.Currency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABEEB on 11/5/2017.
 */

public class CurrencyList {

    private static List<Currency> currencyList = new ArrayList<>();

    public CurrencyList() {

    }

    public static List<Currency> getCurrencies() {
        currencyList.add(new Currency("Australian Dollar", CurrencySymbol.getSymbol("AUD"), "AUD"));
        currencyList.add(new Currency("Pounds", CurrencySymbol.getSymbol("GBP"), "GBP"));
        currencyList.add(new Currency("Euro",  CurrencySymbol.getSymbol("EUR"), "EUR"));
        currencyList.add(new Currency("Naira", CurrencySymbol.getSymbol("NGN"), "NGN"));
        currencyList.add(new Currency("Japan Yen", CurrencySymbol.getSymbol("JPY"), "JPY"));
        currencyList.add(new Currency("Canadian Dollar", CurrencySymbol.getSymbol("CAD"), "CAD"));
        currencyList.add(new Currency("US Dollar", CurrencySymbol.getSymbol("USD"), "USD"));
        currencyList.add(new Currency("Egpyt Pound",  CurrencySymbol.getSymbol("EGP"), "EGP"));
        currencyList.add(new Currency("Cedi",  CurrencySymbol.getSymbol("GHS"), "GHS"));
        currencyList.add(new Currency("Rupee", CurrencySymbol.getSymbol("INR"), "INR"));
        currencyList.add(new Currency("Riyal", CurrencySymbol.getSymbol("SAR"), "SAR"));
        currencyList.add(new Currency("Franc", CurrencySymbol.getSymbol("CHF"), "CHF"));
        currencyList.add(new Currency("Dirham", CurrencySymbol.getSymbol("AED"), "AED"));
        currencyList.add(new Currency("Real", CurrencySymbol.getSymbol("BRL"), "BRL"));
        currencyList.add(new Currency("Pula", CurrencySymbol.getSymbol("BWP"), "BWP"));

        return currencyList;
    }
}

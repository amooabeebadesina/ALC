package com.example.abeeb.alc.utilities;

import com.example.abeeb.alc.entities.Currency;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by ABEEB on 11/5/2017.
 */

public class JSONParser {

    private String json;

    public JSONParser(String json) {
        this.json = json;
    }

    public List<Currency> parseCurrencies() {
        List<Currency> currencies = CurrencyList.getCurrencies();
        try {
            JSONObject json_object = new JSONObject(this.json);
            for (Currency currency: currencies) {
                currency.setValue(json_object.getDouble(currency.getCode()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return currencies;
    }

    public double parseCurrency(String code) {
        double value = 1.0;
        try {
            JSONObject json_object = new JSONObject(this.json);
            value = json_object.getDouble(code);
        } catch(JSONException e) {

        }
        return value;
    }

}

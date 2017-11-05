package com.example.abeeb.alc.entities;

/**
 * Created by ABEEB on 11/4/2017.
 */

import java.util.*;

public class Currency {

    private String name;
    private double value;
    private String symbol;
    private String code;

    public Currency(String name, String symbol, String code) {
        this.name = name;
        this.symbol = symbol;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public double getValue() {
        return this.value;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setValue(double value) {
        this.value = value;
    }

}

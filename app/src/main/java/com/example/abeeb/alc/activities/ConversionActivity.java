package com.example.abeeb.alc.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.abeeb.alc.R;
import com.example.abeeb.alc.adapters.CurrencyAdapter;
import com.example.abeeb.alc.entities.Currency;
import com.example.abeeb.alc.utilities.CurrencyList;
import com.example.abeeb.alc.utilities.EndPoints;
import com.example.abeeb.alc.utilities.JSONParser;

import java.util.List;

public class ConversionActivity extends AppCompatActivity {

    Spinner list;
    List<Currency> currencies;
    ArrayAdapter<String> adapter;
    String [] currency_codes;
    String selected_currency;
    Button btn;
    ProgressDialog progress_dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        list = (Spinner) findViewById(R.id.list);
        btn = (Button) findViewById(R.id.btn);
        currencies = CurrencyList.getCurrencies();
        currency_codes = new String[currencies.size()];
        for (int i =0; i<currencies.size(); i++) {
            currency_codes[i] = currencies.get(i).getCode();
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currency_codes);
        list.setAdapter(adapter);

        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                btn.setEnabled(true);
                selected_currency = list.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                btn.setEnabled(false);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        StringRequest request = new StringRequest(EndPoints.getSingleCurrency(selected_currency),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONParser parser = new JSONParser(response);
                        double value = parser.parseCurrency(selected_currency);
                        double to_btc = 1.0/value;
                        String answer = "Value of currency is " + to_btc + "BTC!";
                        Toast.makeText(ConversionActivity.this,answer,Toast.LENGTH_LONG).show();
                        progress_dialog.dismiss();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progress_dialog.dismiss();
                        Toast.makeText(ConversionActivity.this,"Unable to make Network Call",Toast.LENGTH_LONG).show();
                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
        progress_dialog = new ProgressDialog(this);
        progress_dialog.setMessage("Loading....");
        progress_dialog.show();
    }
}

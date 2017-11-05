package com.example.abeeb.alc.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    CurrencyAdapter currency_adapter;
    ProgressDialog progress_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        makeRequest();
    }

    private void makeRequest() {
        StringRequest request = new StringRequest(EndPoints.getCurrenciesURL(),
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONParser parser = new JSONParser(response);
                            List<Currency> currencies = parser.parseCurrencies();
                            currency_adapter = new CurrencyAdapter(MainActivity.this, currencies);
                            recycler_view.setAdapter(currency_adapter);
                            progress_dialog.dismiss();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            currency_adapter = new CurrencyAdapter(MainActivity.this, CurrencyList.getCurrencies());
                            recycler_view.setAdapter(currency_adapter);
                            progress_dialog.dismiss();
                            Toast.makeText(MainActivity.this,"Unable to make Network Call",Toast.LENGTH_LONG).show();
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

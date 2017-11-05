package com.example.abeeb.alc.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abeeb.alc.R;
import com.example.abeeb.alc.activities.ConversionActivity;
import com.example.abeeb.alc.entities.Currency;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ABEEB on 11/5/2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Currency> currencyList;


    public CurrencyAdapter(Context mContext, List<Currency> currencyList) {
        this.currencyList = currencyList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.featured_currency, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Currency currency = currencyList.get(position);
        holder.name.setText(currency.getName());
        holder.symbol.setText(currency.getSymbol());
        holder.value.setText(String.valueOf(currency.getValue()));
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, value, symbol;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.currency_name);
            symbol = (TextView) view.findViewById(R.id.currency_symbol);
            value = (TextView) view.findViewById(R.id.currency_value);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ConversionActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}

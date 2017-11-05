package com.example.abeeb.alc.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.abeeb.alc.entities.Currency;
import java.util.List;


/**
 * Created by ABEEB on 11/5/2017.
 */

public class CustomLoader  extends AsyncTaskLoader<List<Currency>> {

    public CustomLoader(Context context) {
        super(context);
    }

    @Override
    public List<Currency> loadInBackground() {
        return null;
    }
}

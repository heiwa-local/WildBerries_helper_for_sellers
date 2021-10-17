package com.example.WildBeries4.Presentation.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.WildBeries4.Presentation.Repository.Retrofit.RetrofitBuilder;
import com.example.WildBeries4.Presentation.Repository.Retrofit.RetrofitInterface;
import com.example.WildBeries4.R;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConverterActivity extends AppCompatActivity {

    Button button;
    EditText currencyToBeConverted;
    TextView currencyConverted;
    Spinner convertToDropdown;
    Spinner convertFromDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        currencyConverted = (TextView) findViewById(R.id.currency_converted);
        currencyToBeConverted = (EditText) findViewById(R.id.currency_to_be_converted);
        convertToDropdown = (Spinner) findViewById(R.id.convert_to);
        convertFromDropdown = (Spinner) findViewById(R.id.convert_from);
        button = (Button) findViewById(R.id.button);


        String[] dropDownList = {"USD", "RUB","EUR"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        convertToDropdown.setAdapter(adapter);
        convertFromDropdown.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitInterface retrofitInterface = RetrofitBuilder.getRetrofitInstance().create(RetrofitInterface.class);
                Call<JsonObject> call = retrofitInterface.getExchangeCurrency(convertFromDropdown.getSelectedItem().toString());
                call.enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        JsonObject res = response.body();
                        JsonObject rates = res.getAsJsonObject("rates");
                        double currency = Double.valueOf(currencyToBeConverted.getText().toString());
                        double multiplier = Double.valueOf(rates.get(convertToDropdown.getSelectedItem().toString()).toString());
                        double result = currency * multiplier;
                        currencyConverted.setText(String.valueOf(result));
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                    }
                });
            }
        });

    }
}
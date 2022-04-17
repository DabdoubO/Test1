package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test1.model.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView LSTDrinks;
    private Spinner spin;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
        setSpinner();
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int item = spin.getSelectedItemPosition();
                String toShow = spin.getAdapter().getItem(item).toString();
                Toast.makeText(getApplicationContext(), toShow, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void setSpinner() {
        DrinksMockUp database = new DrinksMockUp();
        String[] cats = database.getCategories();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, cats);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


    }

    private void setView() {
        LSTDrinks = findViewById(R.id.LSTDrinks);
        spin = findViewById(R.id.spin);
    }

    public void BTNSubmit_onClick(View view) {
        String cat = spin.getSelectedItem().toString();

        DrinksMockUp database = new DrinksMockUp();

        ArrayList<Drinks> result = database.getDrinks(cat);

        ArrayAdapter<Drinks> LSTAdapter = new ArrayAdapter<Drinks>(this,
                android.R.layout.simple_list_item_1, result);
        LSTDrinks.setAdapter(LSTAdapter);
    }
}
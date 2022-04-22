package com.example.test1;

import static android.R.layout.simple_list_item_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.android.material.snackbar.Snackbar;

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
        showList();
        toToast();

    }
    private void toToast() {
        // to toast the selected category from the spinner
//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                int item = spin.getSelectedItemPosition();
//                String toShow = spin.getAdapter().getItem(item).toString();
//                Toast.makeText(getApplicationContext(), toShow, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        // to toast the checked item from the list
        LSTDrinks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(), LSTDrinks.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
                Snackbar snack = Snackbar.make(view, LSTDrinks.getItemAtPosition(i).toString(), Snackbar.LENGTH_SHORT);
                snack.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Do smt", Toast.LENGTH_SHORT).show();
                    }
                });
                snack.show();

            }
        });
    }
    private void setSpinner() {
        DrinksMockUp database = new DrinksMockUp();
        String[] cats = database.getCategories();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
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

    private void showList(){
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                BTNSubmit_onClick(view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void email(View view){
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_SUBJECT, "Drinks List");
        String emailBody = "";
        for (int i = 0; i < LSTDrinks.getCount(); i++){
            emailBody+= LSTDrinks.getItemAtPosition(i).toString() + "\n";
        }
        email.putExtra(Intent.EXTRA_TEXT, emailBody);

        email.setType("text/plain");

        startActivity(Intent.createChooser(email, "Choose an Email Client!"));
    }
}
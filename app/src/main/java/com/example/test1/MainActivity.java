package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private EditText res;
    private Spinner spin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
    }

    private void setView() {
        res = findViewById(R.id.res);
        spin = findViewById(R.id.spin);
    }

    public void BTNSubmit_onClick(View view) {
        String drink = spin.getSelectedItem().toString();
        res.setText(drink);
    }
}
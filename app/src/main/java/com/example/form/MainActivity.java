package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
//https://open.spotify.com/track/0tyR7Bu9P086aWBFZ4QJoo?si=wBQAm4MERACmdfljDJ5_bw
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    EditText title1 = (EditText) findViewById(R.id.title1);
    EditText subtitle1 = (EditText) findViewById(R.id.subtitle1);
    EditText writer1 = (EditText) findViewById(R.id.writer1);
    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    String type1 = String.valueOf(spinner.getSelectedItemPosition());
}

package com.example.form;

import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText title_input;

    TextInputEditText sub_title_input;

    TextInputEditText author_input;

    Spinner type_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_input = findViewById(R.id.title);

        sub_title_input = findViewById(R.id.sub_title);

        author_input = findViewById(R.id.author);

        type_spinner = findViewById(R.id.spinner);
        String type1 = String.valueOf(type_spinner.getSelectedItemPosition()); // Хуйня. Значение возмётся 1 раз при запуске активити, а там по умолчанию будет 0. Нужен onSelectedItemListener()
    }
}

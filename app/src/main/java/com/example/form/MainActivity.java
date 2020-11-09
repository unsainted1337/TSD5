package com.example.form;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextInputLayout title_input_layout;
    TextInputEditText title_input;

    TextInputEditText sub_title_input;

    TextInputEditText author_input;

    TextInputEditText image_url_input;

    ImageView image_preview;

    MaterialButton send_button;

    Spinner type_spinner;

    long type_id;

    /**
     * Слушатель поля image_url. После изменения текста подзагружает превью картинки.
     * Всех слушателей полек реализовывать через TextWatcher
     */
    TextWatcher imageUrlListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (!editable.toString().isEmpty())
                loadImagePreview(editable.toString());
        }
    };

    View.OnClickListener sendButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (title_input.getText().toString().isEmpty()) {
                title_input_layout.setError("Поле не должно быть пустым");
                title_input_layout.setErrorEnabled(true);
                return;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_input_layout = findViewById(R.id.title_layout);

        title_input = findViewById(R.id.title);

        sub_title_input = findViewById(R.id.sub_title);

        author_input = findViewById(R.id.author);

        type_spinner = findViewById(R.id.spinner);

        image_preview = findViewById(R.id.image_preview);

        image_url_input = findViewById(R.id.image_url);

        send_button = findViewById(R.id.bSend);
        send_button.setOnClickListener(sendButtonListener);

        image_url_input.addTextChangedListener(imageUrlListener);


        OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] type1 = getResources().getStringArray(R.array.type);
                type_id = id + 1;
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ваш выбор: " + type1[position] + ". Позиция:" + position + ". ID:" + type_id, Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        type_spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    private void loadImagePreview(String url) {
        Picasso.get()
                .load(url)
                .into(image_preview);
    }
}

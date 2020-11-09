package com.example.form;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    TextInputEditText title_input;

    TextInputEditText sub_title_input;

    TextInputEditText author_input;

    TextInputEditText image_url_input;

    ImageView image_preview;

    Spinner type_spinner;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title_input = findViewById(R.id.title);

        sub_title_input = findViewById(R.id.sub_title);

        author_input = findViewById(R.id.author);

        type_spinner = findViewById(R.id.spinner);

        image_preview = findViewById(R.id.image_preview);

        image_url_input = findViewById(R.id.image_url);

        image_url_input.addTextChangedListener(imageUrlListener);

//        new PreLoadImageTask(image_preview).execute("https://avatars.mds.yandex.net/get-zen_doc/1586206/pub_5d990c062beb4900adf5c374_5d990e9b3642b600ad3ee190/scale_1200");


        String type1 = String.valueOf(type_spinner.getSelectedItemPosition()); // Хуйня. Значение возмётся 1 раз при запуске активити, а там по умолчанию будет 0. Нужен onSelectedItemListener()
    }

    private void loadImagePreview(String url) {
        Picasso.get()
                .load(url)
                .into(image_preview);
    }

}

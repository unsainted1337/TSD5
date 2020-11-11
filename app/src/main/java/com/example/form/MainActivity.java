package com.example.form;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.title_layout)
    TextInputLayout title_input_layout;

    @BindView(R.id.title)
    TextInputEditText title_input;

    @BindView(R.id.sub_title_layout)
    TextInputLayout sub_title_input_layout;

    @BindView(R.id.sub_title)
    TextInputEditText sub_title_input;

    @BindView(R.id.author_layout)
    TextInputLayout author_input_layout;

    @BindView(R.id.author)
    TextInputEditText author_input;

    @BindView(R.id.image_url_layout)
    TextInputLayout image_url_layout;

    @BindView(R.id.image_url)
    TextInputEditText image_url_input;

    @BindView(R.id.image_frame)
    MaterialCardView image_frame;

    @BindView(R.id.image_preview)
    ImageView image_preview;

    @BindView(R.id.bSend)
    MaterialButton send_button;

    @BindView(R.id.spinner)
    Spinner type_spinner;

    long type_id;

    String imageURL;

    String subTitle;

    String auThor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        image_url_input.addTextChangedListener(imageUrlListener);

        send_button.setOnClickListener(sendButtonListener);

        type_spinner.setOnItemSelectedListener(itemSelectedListener);

        title_input.addTextChangedListener(titleTextWatcher);
        //добавил слушателя к подзаголовку
        sub_title_input.addTextChangedListener(subtitleTextWatcher);

        author_input.addTextChangedListener(authorTextWatcher);
    }

    private void loadImagePreview(String url) {
        Picasso.get()
                .load(url)
                .into(image_preview, new Callback() {
                    @Override
                    public void onSuccess() {
                        image_frame.setVisibility(View.VISIBLE);
                        image_url_layout.setErrorEnabled(false);
                    }

                    @Override
                    public void onError(Exception e) {
                        image_frame.setVisibility(View.GONE);
                        image_url_layout.setError("Не удалось загрузить картинку");
                        image_url_layout.setErrorEnabled(true);
                    }
                });
    }

    //TODO Хуйня какая то. Сделать получше...
    TextWatcher titleTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.toString().isEmpty()) {
                title_input_layout.setError("Поле должно быть заполнено");
                title_input_layout.setErrorEnabled(true);
            }
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            title_input_layout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

            if (editable.toString().isEmpty()) {
                title_input_layout.setError("Поле должно быть заполнено");
                title_input_layout.setErrorEnabled(true);
            }
        }
    };
    // Слушатель для подзаголовка
    TextWatcher subtitleTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (s.toString().isEmpty()){
                sub_title_input_layout.setError("Поле должно быть заполнено");
                sub_title_input_layout.setErrorEnabled(true);
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            sub_title_input_layout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().isEmpty()){
                sub_title_input_layout.setError("Поле должно быть заполнено");
                sub_title_input_layout.setErrorEnabled(true);
            }
            subTitle = sub_title_input.getText().toString();
        }
    };
    //слушатель для автора
    TextWatcher authorTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (s.toString().isEmpty()){
                author_input_layout.setError("Поле должно быть заполнено");
                author_input_layout.setErrorEnabled(true);
            }

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            author_input_layout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().isEmpty()){
                author_input_layout.setError("Поле должно быть заполнено");
                author_input_layout.setErrorEnabled(true);
            }
            auThor = author_input.getText().toString();
        }
    };

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
            if (!editable.toString().isEmpty()) {
                loadImagePreview(editable.toString());
            }
            image_url_layout.setErrorEnabled(false);
            //добавление ссылки в переменную
            imageURL = image_url_input.getText().toString();
        }
    };

    OnItemSelectedListener itemSelectedListener = new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String[] type1 = getResources().getStringArray(R.array.type);
            type_id = id + 1;
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "Ваш выбор: " + type1[position] + ". Позиция:" + position + ". ID:" + type_id, Toast.LENGTH_SHORT);
//            toast.show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    View.OnClickListener sendButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

}

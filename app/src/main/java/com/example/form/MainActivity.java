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
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

import static com.example.form.MainActivity.TextInputs.IMAGE_URL;
import static com.example.form.MainActivity.TextInputs.TITLE;

public class MainActivity extends AppCompatActivity {


    @BindViews({R.id.title_layout, R.id.sub_title_layout, R.id.author_layout, R.id.image_url_layout})
    List<TextInputLayout> inputLayouts;

    @BindViews({R.id.title, R.id.sub_title, R.id.author, R.id.image_url})
    List<TextInputEditText> editTexts;

//    TextInputLayout title_input_layout;
//    TextInputEditText title_input;
//
//    TextInputLayout sub_title_input_layout;
//    TextInputEditText sub_title_input;
//
//    TextInputLayout author_input_layout;
//    TextInputEditText author_input;
//
//    TextInputLayout image_url_layout;
//    TextInputEditText image_url_input;

    @BindView(R.id.image_frame)
    MaterialCardView image_frame;

    @BindView(R.id.image_preview)
    ImageView image_preview;

    @BindView(R.id.bSend)
    MaterialButton send_button;

    @BindView(R.id.spinner)
    Spinner type_spinner;

    long type_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        editTexts.get(IMAGE_URL.ordinal()).addTextChangedListener(imageUrlListener);

        send_button.setOnClickListener(sendButtonListener);

        type_spinner.setOnItemSelectedListener(itemSelectedListener);

        editTexts.get(TITLE.ordinal()).addTextChangedListener(titleTextWatcher);

    }

    private void loadImagePreview(String url) {
        Picasso.get()
                .load(url)
                .into(image_preview, new Callback() {
                    @Override
                    public void onSuccess() {
                        image_frame.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(Exception e) {
                    }
                });
    }

    //TODO Хуйня какая то. Сделать получше...
    TextWatcher titleTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            TextInputLayout title_layout = inputLayouts.get(TextInputLayouts.TITLE_LAYOUT.ordinal());

            if (charSequence.toString().isEmpty()) {
                title_layout.setError("Поле должно быть заполнено");
                title_layout.setErrorEnabled(true);
            }
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            TextInputLayout title_layout = inputLayouts.get(TextInputLayouts.TITLE_LAYOUT.ordinal());

            title_layout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

            TextInputLayout title_layout = inputLayouts.get(TextInputLayouts.TITLE_LAYOUT.ordinal());

            if (editable.toString().isEmpty()) {
                title_layout.setError("Поле должно быть заполнено");
                title_layout.setErrorEnabled(true);
            }
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
            if (!editable.toString().isEmpty())
                loadImagePreview(editable.toString());
        }
    };

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

    View.OnClickListener sendButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    protected enum TextInputLayouts {
        TITLE_LAYOUT,
        SUB_TITLE_LAYOUT,
        AUTHOR_LAYOUT,
        IMAGE_URL_LAYOUT
    }

    protected enum TextInputs {
        TITLE,
        SUB_TITLE,
        AUTHOR,
        IMAGE_URL
    }
}

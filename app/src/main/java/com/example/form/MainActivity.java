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


    @BindView(R.id.login_layout)
    TextInputLayout login_input_layout;

    @BindView(R.id.login)
    TextInputEditText login_input;

    @BindView(R.id.password_layout)
    TextInputLayout password_input_layout;

    @BindView(R.id.password)
    TextInputEditText password_input;

    @BindView(R.id.sign_in)
    MaterialButton sign_button;



    long type_id;



    String login;

    String auThor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        sign_button.setOnClickListener(sendButtonListener);

        login_input.addTextChangedListener(loginTextWatcher);
        password_input.addTextChangedListener(passwordTextWatcher);


    }


    //TODO Хуйня какая то. Сделать получше...
    TextWatcher loginTextWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.toString().isEmpty()) {
                login_input_layout.setError("Поле должно быть заполнено");
                login_input_layout.setErrorEnabled(true);
            }
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            login_input_layout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

            if (editable.toString().isEmpty()) {
                login_input_layout.setError("Поле должно быть заполнено");
                login_input_layout.setErrorEnabled(true);
            }
        }
    };

    TextWatcher passwordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (s.toString().isEmpty()){
                password_input_layout.setError("Поле должно быть заполнено");
                password_input_layout.setErrorEnabled(true);
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            password_input_layout.setErrorEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().isEmpty()){
                password_input_layout.setError("Поле должно быть заполнено");
                password_input_layout.setErrorEnabled(true);
            }

        }
    };


    View.OnClickListener sendButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

}

package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailEDT = findViewById(R.id.emailEDTV);
        EditText passwordEDT = findViewById(R.id.passwordEDTV);
        Button logInBT = findViewById(R.id.logInBT);
        TextView manualTV = findViewById(R.id.manualTV);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);
        LinearLayout linearLayout3 = findViewById(R.id.linearLayout3);

        logInBT.setOnClickListener(view -> {
            String enteredEmail = emailEDT.getText().toString();
            String enteredPassword = passwordEDT.getText().toString();

            if (enteredEmail.equals("admin") && enteredPassword.equals("admin")) {
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались",
                        Toast.LENGTH_SHORT).show();
                manualTV.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                linearLayout3.setVisibility(View.GONE);

            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин или пароль",
                        Toast.LENGTH_SHORT).show();
            }
        });

        emailEDT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 || passwordEDT.getText().length() > 0) {
                    logInBT.setBackgroundResource(R.color.orange);
                } else {
                    logInBT.setBackgroundResource(R.color.grey);
                }
            }
        });

        passwordEDT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0 || emailEDT.getText().length() > 0) {
                    logInBT.setBackgroundResource(R.color.orange);
                } else {
                    logInBT.setBackgroundResource(R.color.grey);
                }
            }
        });

    }
}
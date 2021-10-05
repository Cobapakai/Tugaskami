package com.example.tugaskami;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText loginUsername , loginPassword;
    Button Buttonlogin;
    String Username , Password;
    TextView tvDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);

        Buttonlogin = findViewById(R.id.ButtonLogin);
        Buttonlogin.setOnClickListener(this);

        tvDaftar = findViewById(R.id.tvDaftar);
        tvDaftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ButtonLogin:
                Username = loginUsername.getText().toString();
                Password = loginPassword.getText().toString();
                login(Username, Password);
                Toast.makeText(Login.this, "Selamat Datang", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvDaftar:
                Intent intent = new Intent(this, Sign_Up.class);
                startActivity(intent);
                break;
        }

//        Toast.makeText(Login.this, "Selamat Datang", Toast.LENGTH_SHORT).show();

    }

    private void login(String username, String password) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
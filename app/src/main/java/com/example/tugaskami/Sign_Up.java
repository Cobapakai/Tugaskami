package com.example.tugaskami;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_Up extends AppCompatActivity implements View.OnClickListener {

    EditText etTambahNama, etTambahUsername, etTambahPassword, etTambahEmail;
    Button buttondaftar;
    TextView tvLogin;
    String Name, Username, Password, Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etTambahNama = findViewById(R.id.etTambahNama);
        etTambahUsername = findViewById(R.id.etTambahUsername);
        etTambahEmail = findViewById(R.id.etTambahEmail);
        etTambahPassword = findViewById(R.id.etTambahPassword);

        buttondaftar = findViewById(R.id.buttondaftar);
        buttondaftar.setOnClickListener(this);

        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttondaftar:
                Name = etTambahNama.getText().toString();
                Username = etTambahUsername.getText().toString();
                Email = etTambahEmail.getText().toString();
                Password = etTambahPassword.getText().toString();
                daftar(Name, Username, Password, Email);
                Toast.makeText(Sign_Up.this, "Selamat Anda Sudah Mendaftar, Silahkan Login Kembali", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvLogin:
                Intent intent = new Intent(this,Login.class);
                startActivity(intent);

        }

//       Toast.makeText(Sign_Up.this, "Selamat Anda Sudah Mendaftar, Silahkan Login Kembali", Toast.LENGTH_SHORT).show();

    }

    private void daftar(String name, String username, String password, String email) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
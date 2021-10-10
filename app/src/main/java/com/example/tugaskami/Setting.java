package com.example.tugaskami;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Setting extends AppCompatActivity implements View.OnClickListener {
    ImageButton kembali;
    TextView account, help, about, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        kembali = findViewById(R.id.kembali);
        kembali.setOnClickListener(this);

        account = findViewById(R.id.account);
        account.setOnClickListener(this);

        help = findViewById(R.id.help);
        help.setOnClickListener(this);

        about = findViewById(R.id.about);
        about.setOnClickListener(this);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.kembali) {
            Intent kembali = new Intent(this, Menu.class);
            startActivity(kembali);
        }

    }

}
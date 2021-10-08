package com.example.tugaskami;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    ImageView profil, pengaturan, map, pesan, history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        profil = findViewById(R.id.profil);
        profil.setOnClickListener(this);

        pengaturan = findViewById(R.id.pengaturan);
        pengaturan.setOnClickListener(this);

        map = findViewById(R.id.map);
        map.setOnClickListener(this);

        pesan = findViewById(R.id.pesan);
        pesan.setOnClickListener(this);

        history = findViewById(R.id.history);
        history.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.profil:
                Intent intent = new Intent(this, Me.class);
                startActivity(intent);
                break;

            case R.id.pengaturan:
                Intent pengaturan = new Intent(this, Setting.class);
                startActivity(pengaturan);
                break;

            case R.id.map:
                Intent map = new Intent(this, Me.class);
                startActivity(map);
                break;

            case R.id.pesan:
                Intent pesan = new Intent(this, Me.class);
                startActivity(pesan);
                break;

            case R.id.history:
                Intent history = new Intent(this, Me.class);
                startActivity(history);
                break;
        }

    }
}

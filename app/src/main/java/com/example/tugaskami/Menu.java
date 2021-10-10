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
        int id = view.getId();
        if (id == R.id.profil) {
            Intent intent = new Intent(this, Me.class);
            startActivity(intent);
        } else if (id == R.id.pengaturan) {
            Intent pengaturan = new Intent(this, Setting.class);
            startActivity(pengaturan);
        } else if (id == R.id.map) {
            Intent map = new Intent(this, Me.class);
            startActivity(map);
        } else if (id == R.id.pesan) {
            Intent pesan = new Intent(this, Message.class);
            startActivity(pesan);
        } else if (id == R.id.history) {
            Intent history = new Intent(this, Me.class);
            startActivity(history);
        }

    }
}

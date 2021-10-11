package com.example.tugaskami;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Me extends AppCompatActivity implements View.OnClickListener {
    ImageButton kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        kembali = findViewById(R.id.kembali);
        kembali.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.kembali) {
            Intent kembali = new Intent(this, Menu.class);
            startActivity(kembali);}
    }
}
package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void sendNow(View view){
        Toast.makeText(this, "Sending data from app", Toast.LENGTH_SHORT).show();
    }

    public void receiveNow(View view){
        Toast.makeText(this, "Receiving data from BINOD", Toast.LENGTH_SHORT).show();
    }
    public void delete(View view){
        Toast.makeText(this, "Abe saale kuch hai hi nai kya delete krega : BINOD", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
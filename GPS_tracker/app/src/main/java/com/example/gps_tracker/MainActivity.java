package com.example.gps_tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttongetloc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        buttongetloc = (Button)findViewById(R.id.button_getloc);

        buttongetloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if(l!= null){
                    double lat = l.getLatitude();
                    double lon = l.getLongitude();
                    Toast.makeText(getApplicationContext(),"LAT : "+lat+"\nLON : "+lon,Toast.LENGTH_LONG).show();
                    

                }
            }
        });
    }
}
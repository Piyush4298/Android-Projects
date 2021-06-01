package com.example.storagerw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText inputField;
    Button writeButton;
    TextView displayText;
    Button readbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.editText);
        writeButton = findViewById(R.id.saveButton);
        displayText = findViewById(R.id.diplayText);
        readbutton = findViewById(R.id.readButton);

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeFile();
            }
        });

        readbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readFile();
            }
        });

    }
    public void writeFile(){
        String texttosave = inputField.getText().toString();

        try{
            FileOutputStream fileOutputStream = openFileOutput("SDL File.txt", MODE_PRIVATE);
            fileOutputStream.write(texttosave.getBytes());
            fileOutputStream.close();

            Toast.makeText(getApplicationContext(), "Text saved successfully", Toast.LENGTH_SHORT).show();
            inputField.setText("");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readFile(){
        try {
            FileInputStream fileInputStream = openFileInput("SDL File.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String Lines;
            while((Lines = bufferedReader.readLine()) !=null){
                stringBuffer.append(Lines+"\n");
            }
            displayText.setText(stringBuffer.toString());

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
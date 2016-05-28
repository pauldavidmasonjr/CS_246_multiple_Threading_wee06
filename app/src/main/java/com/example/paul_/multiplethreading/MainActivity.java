package com.example.paul_.multiplethreading;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    String FileName = "numbers.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void createButtonCLick(View view){
        //do something with the click button.
        Button createButton = (Button) view;
        //((Button) view).setText("File Created");

        EditText textToFile = (EditText)findViewById(R.id.editText1);

        //create file in the internal storage area
        try{
            //String FileName = "numbers.txt";
            FileOutputStream fileout = openFileOutput("numbers.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(textToFile.getText().toString());
            outputWriter.close();

            Thread.sleep(1000);

            //display file saved message
            Toast.makeText(getBaseContext(), "File Saved success",
                    Toast.LENGTH_SHORT).show();
        }
        catch(Exception e) {
        }
    }

    public void loadButtonCLick(View view){
        Button loadButton = (Button) view;
        //((Button) view).setText("loading contents of file");

        String ret ="";
        //read from the numbers.txt
        try{
            FileInputStream fileIn = openFileInput("numbers.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[100];
            String s = "";
            int charRead;

            while((charRead = InputRead.read(inputBuffer)) > 0){
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                s += readstring;
            }

            Thread.sleep(10001234);

            InputRead.close();
            Toast.makeText(getBaseContext(),s,Toast.LENGTH_SHORT).show();
        }
        catch(Exception e) {
        }
    }

    public void clearButtonCLick(View view){
        Button loadButton = (Button) view;

        String blankString = "";

        //clear the file
        try{
            FileOutputStream fileout = openFileOutput("numbers.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
            outputWriter.write(blankString);
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File Cleared",
                    Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){

        }
    }
}

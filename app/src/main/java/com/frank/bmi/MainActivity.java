package com.frank.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edweight;
    private EditText edheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edweight = findViewById(R.id.ed_weight);
        edheight = findViewById(R.id.ed_height);
    }

    public void bmi(View view){
        Log.d("MainActivity" ,"bmi");
        String w = edweight.getText().toString();
        String h = edheight.getText().toString();

        Log.d("MainActivity",w+"/"+h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);

        Log.d("MainActivity",bmi+"");
        Toast.makeText(this,"your bmi is"+bmi,Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)
                .setMessage("Your BMI is"+bmi)
                .setTitle("BMI Coculate")
                .setPositiveButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edheight.setText("");
                        edweight.setText("");
                    }
                })
                .show();


    }

    public void help(View view){
        Log.d("MainActivity","help");
        Toast.makeText(this,"Weight(kg)",Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)
                .setTitle("Help").setMessage("Weight(kg)"+"\n"+"Height(m)")
                //.setMessage("Height(m)")
                .setPositiveButton("back", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edheight.setText("");
                                edweight.setText("");
                            }
                        }
                )
                .show();

    }
}

package com.frank.bmi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edweight;
    private EditText edheight;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edweight = findViewById(R.id.ed_weight);
        edheight = findViewById(R.id.ed_height);
        help = findViewById(R.id.bt_help);
        findview();
    }

    public void findview(){
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.helpTittle)
                        .setMessage(R.string.helpMessage)
                        .setPositiveButton(R.string.helpBack, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                }
                        )
                        .show();
            }
        });
    }

    public void bmi(View view){
        Log.d("MainActivity" ,"bmi");
        String w = edweight.getText().toString();
        String h = edheight.getText().toString();

        Log.d("MainActivity",w+"/"+h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);

        Intent intent = new Intent(this,ResultActiyity.class);
        intent.putExtra("BMI",bmi);
        startActivity(intent);

        /*Log.d("MainActivity",bmi+"");
        Toast.makeText(this,"your bmi is"+bmi,Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.submitMessage)+bmi)
                .setTitle(R.string.submitTittle)
                .setPositiveButton(R.string.submitBack, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edheight.setText("");
                        edweight.setText("");
                    }
                })
                .show();*/


    }

    public void support(View view){
        Log.d("MainActivity","support");
        Toast.makeText(this,"Weight(kg)",Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this)
                .setTitle(R.string.supportTittle).setMessage("Weight(kg)"+"\n"+"Height(m)")
                .setPositiveButton(R.string.supportBack, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edheight.setText("");
                                edweight.setText("");
                            }
                        }
                )
                .show();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d("MainActivity","onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }
}

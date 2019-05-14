package com.example.fern.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activityhello extends AppCompatActivity implements View.OnClickListener{
     TextView out;
     EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        out = (TextView)findViewById(R.id.txtout);
        edit = (EditText)findViewById(R.id.inp);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("main","onClick msg....");
        String str = edit.getText().toString();
        int a =Integer.valueOf(str).intValue();
        double b =a*33.8;
        String str2 =String.valueOf(b);
        out.setText("华氏度为"+str2);
    }
}

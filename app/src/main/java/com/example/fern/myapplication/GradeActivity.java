package com.example.fern.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GradeActivity extends AppCompatActivity implements View.OnClickListener{
    TextView out;
    EditText edit;
    Button btn0,btn1,btn2,btn3;
    private final String TAG ="second";
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Log.i(TAG, "onCreate: ");

        out = (TextView)findViewById(R.id.txtout);
        edit = (EditText)findViewById(R.id.inp);

        Button btn0 = (Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        Button btn1A = (Button)findViewById(R.id.btn1A);
        btn1.setOnClickListener(this);

        Button btn2A = (Button)findViewById(R.id.btn2A);
        btn2.setOnClickListener(this);

        Button btn3A = (Button)findViewById(R.id.btn3A);
        btn3.setOnClickListener(this);

        Button btn1B = (Button)findViewById(R.id.btn1B);
        btn1.setOnClickListener(this);

        Button btn2B = (Button)findViewById(R.id.btn2B);
        btn2.setOnClickListener(this);

        Button btn3B = (Button)findViewById(R.id.btn3B);
        btn3.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String scorea = (String) ((TextView)findViewById(R.id.btn2A)).getText().toString();
        String scoreb = (String) ((TextView)findViewById(R.id.btn2B)).getText().toString();
        Log.i(TAG, "onSaveInstanceState: ");
        outState.putFloat("teama_score", Float.parseFloat(scorea));
        outState.putFloat("teamb_score", Float.parseFloat(scoreb));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: ");
        String scorea = savedInstanceState.getString("teama_score");
        String scoreb = savedInstanceState.getString("teamb_score");
    }

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }


    @Override
    public void onClick(View v) {
        Log.i("main","onClick msg....");
        String str = edit.getText().toString();
        int a =Integer.valueOf(str).intValue();
        if (v.getId()==R.id.btn0){
            int b0 =0;
            String str1 =String.valueOf(b0);
            out.setText(b0);}
        else if (v.getId()==R.id.btn1A  ) {
            int b1 = a + 1;
            String str1 = String.valueOf(b1);
            out.setText(b1);}
        else if(v.getId()==R.id.btn2A){//按钮2
                int b2 =a+3;
                String str2 =String.valueOf(b2);
                out.setText(b2);}
        else if (v.getId()==R.id.btn3A){//按钮2
            int b3 =a+3;
            String str3 =String.valueOf(b3);
            out.setText(b3);}

        else if (v.getId()==R.id.btn1B  ) {
            int b1 = a + 1;
            String str1 = String.valueOf(b1);
            out.setText(b1);}
        else if(v.getId()==R.id.btn2B){//按钮2
            int b2 =a+3;
            String str2 =String.valueOf(b2);
            out.setText(b2);}
        else if (v.getId()==R.id.btn3B){//按钮2
            int b3 =a+3;
            String str3 =String.valueOf(b3);
            out.setText(b3);}
    }
}

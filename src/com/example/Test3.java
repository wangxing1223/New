package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 13-8-9.
 */
public class Test3 extends Activity {


//    private double weight;
//    private double height;
    private double bmi;
    private int n = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3);
        getBmi(Double.parseDouble(getIntent().getStringExtra("weight")),Double.parseDouble(getIntent().getStringExtra("height")));
        isNormal(bmi);
        switch (n){
            case -1:
                Toast.makeText(Test3.this, " 超轻 ", Toast.LENGTH_LONG).show();
                break;
            case 0:
                Toast.makeText(Test3.this," 正常 ",Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(Test3.this," 超重 ",Toast.LENGTH_LONG).show();
                break;
        }
    }




    private double getBmi(double weight,double height)
    {

        bmi = weight/(height*2);
        return bmi;
    }

    private int isNormal(double bmi){
        if ((bmi >= 18.5)&&(bmi <= 23.9)){
            n = 0;
        }else if (bmi < 18.5){
            n = -1;
        }else {
            n = 1;
        }
        return  n;
    }
}
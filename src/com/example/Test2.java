package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 13-8-9.
 */
public class Test2 extends Activity {

    private double weight;
    private double height;
    private double bmi;
    private int n = 0;
    private EditText weight1;
    private EditText height1;
    private Button next;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);

        init();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Test2.this,Test2.class);
//                intent.putExtra("weight",weight1.getText().toString());
//                intent.putExtra("height",height1.getText().toString());
                  getBmi(Double.parseDouble(weight1.getText().toString()),Double.parseDouble(weight1.getText().toString()));
//                startActivity(intent);
                  isNormal(bmi);
                  switch (n){
                    case -1:
                        Toast.makeText(Test2.this, " 超轻 ", Toast.LENGTH_LONG).show();
                        break;
                    case 0:
                        Toast.makeText(Test2.this," 正常 ",Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(Test2.this," 超重 ",Toast.LENGTH_LONG).show();
                        break;
                  }
            }
        });



    }

    private void init() {
        height1 = (EditText) findViewById(R.id.height);
        weight1 = (EditText) findViewById(R.id.weight);
        next = (Button) findViewById(R.id.next);
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

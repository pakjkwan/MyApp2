package com.hanbit.user.myapp2.calc;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp2.R;

public class CalcActivity extends Activity implements View.OnClickListener{

    EditText input01,input02;
    Button btnPlus,btnMinus,btnMulti,btnDivi,btnRest;
    TextView textResult;
    int num1,num2,result;
    CalcService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        service = new CalcServiceImpl();
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnDivi = (Button) findViewById(R.id.btnDivi);
        btnRest = (Button) findViewById(R.id.btnRest);
        textResult = (TextView) findViewById(R.id.textResult);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDivi.setOnClickListener(this);
        btnRest.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        input01 = (EditText) findViewById(R.id.input01);
        num1 = Integer.parseInt(input01.toString());
        input02 = (EditText) findViewById(R.id.input02);
        num2 = Integer.parseInt(input02.toString());
        switch (v.getId()){
            case R.id.btnPlus : service.plus(num1,num2); break;
            case R.id.btnMinus : service.minus(num1,num2); break;
            case R.id.btnMulti : service.multi(num1,num2); break;
            case R.id.btnDivi : service.divide(num1,num2); break;
            case R.id.btnRest : service.nmg(num1,num2); break;
        }
    }
}

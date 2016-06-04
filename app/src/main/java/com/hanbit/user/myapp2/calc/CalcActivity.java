package com.hanbit.user.myapp2.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.main.MainActivity;

public class CalcActivity extends Activity implements View.OnClickListener{

    EditText input01,input02;
    TextView textResult;
    int num1,num2,result;
    CalcService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        service = new CalcServiceImpl();
        textResult = (TextView) findViewById(R.id.textResult);
        ((Button) findViewById(R.id.btnPlus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMinus)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnMulti)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnDivi)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnRest)).setOnClickListener(this);
        ((Button) findViewById(R.id.returnMain)).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.returnMain){
            Toast tMsg = Toast.makeText(CalcActivity.this,"뒤로가기버튼클릭",Toast.LENGTH_LONG);
            startActivity(new Intent(this, MainActivity.class));
        }else{
            input01 = (EditText) findViewById(R.id.input01);
            num1 = Integer.parseInt(input01.getText().toString());
            input02 = (EditText) findViewById(R.id.input02);
            num2 = Integer.parseInt(input02.getText().toString());
            int result = 0;
            switch (v.getId()){
                case R.id.btnPlus :
                    result = service.plus(num1,num2); break;
                case R.id.btnMinus :
                    result = service.minus(num1,num2); break;
                case R.id.btnMulti :
                    result = service.multi(num1,num2); break;
                case R.id.btnDivi :
                    result = service.divide(num1,num2); break;
                case R.id.btnRest :
                    result = service.nmg(num1,num2); break;
            }
            textResult.setText("계산 결과 : "+result);
        }

    }
}

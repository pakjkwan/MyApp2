package com.hanbit.user.myapp2.kaup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp2.R;

public class KaupActivity extends Activity implements View.OnClickListener{
    EditText etName,etWeight,etHeight;
    TextView resultCalc;
    String name,result;
    Button btnCalc;
    //  double weight,height;
    int weight,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaup);
        etName = (EditText) findViewById(R.id.name);
        etWeight = (EditText) findViewById(R.id.weight);
        etHeight = (EditText) findViewById(R.id.height);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        name = etName.getText().toString();
       /* weight = Double.parseDouble(etWeight.getText().toString());
        height = Double.parseDouble(etHeight.getText().toString());*/
        resultCalc = (TextView) findViewById(R.id.resultCalc);
        height = Integer.parseInt(etHeight.getText().toString());
        weight = Integer.parseInt(etWeight.getText().toString());
        KaupService service = new KaupServiceImpl();
        result = service.getKaup(weight,height);

        resultCalc.setText(name+"님의 계산결과: " + result);
    }
}

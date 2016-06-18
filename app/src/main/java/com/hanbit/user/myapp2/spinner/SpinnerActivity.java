package com.hanbit.user.myapp2.spinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.hanbit.user.myapp2.R;

public class SpinnerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        setTitle("스피너 테스트");
        String[] movie = {"쿵푸팬더","짱구","아저씨","아바타","대부","국가대표"
                         ,"토이","암탉","죽은시인","서유기"};
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, movie);
        spinner.setAdapter(adapter);
    }
}

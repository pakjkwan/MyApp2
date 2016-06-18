package com.hanbit.user.myapp2.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.api.GoogleApiClient;
import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.group.GroupActivity;
import com.hanbit.user.myapp2.kaup.KaupActivity;
import com.hanbit.user.myapp2.login.Login2Activity;
import com.hanbit.user.myapp2.signup.SignupActivity;

public class MainActivity extends Activity implements View.OnClickListener {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.btKaup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btCalc)).setOnClickListener(this);
        ((Button) findViewById(R.id.btLogin)).setOnClickListener(this);
        ((Button) findViewById(R.id.btSignup)).setOnClickListener(this);
        ((Button) findViewById(R.id.btGroup)).setOnClickListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btKaup:
                startActivity(new Intent(this, KaupActivity.class));
                break;
            case R.id.btCalc:

                break;
            case R.id.btLogin:
                startActivity(new Intent(this, Login2Activity.class));
                break;
            case R.id.btSignup:
                startActivity(new Intent(this, SignupActivity.class));
                break;
            case R.id.btGroup:
                startActivity(new Intent(this, GroupActivity.class));
                break;
        }
    }

}

package com.hanbit.user.myapp2.signup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hanbit.user.myapp2.R;
import com.hanbit.user.myapp2.member.MemberBean;
import com.hanbit.user.myapp2.member.MemberDAO;
import com.hanbit.user.myapp2.member.MemberServiceImpl;
import com.hanbit.user.myapp2.member.MemberService;

import java.lang.reflect.Member;

public class SignupActivity extends Activity implements View.OnClickListener{
    EditText etID,etPW,etName,etEmail;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etName = (EditText) findViewById(R.id.etName);
        etID = (EditText) findViewById(R.id.etID);
        etPW = (EditText) findViewById(R.id.etPW);
        etEmail = (EditText) findViewById(R.id.etEmail);
        textResult = (TextView) findViewById(R.id.textResult);
        ((Button)findViewById(R.id.btSignup)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String id = etID.getText().toString();
        String pw = etPW.getText().toString();
        String email = etEmail.getText().toString();
        MemberBean member = new MemberBean();
        MemberService service = new MemberServiceImpl();
        MemberDAO dao = new MemberDAO(this.getApplicationContext());
        member.setId(id);
        member.setPw(pw);
        member.setName(name);
        member.setEmail(email);
        String msg = dao.signup(member);
        textResult.setText("회원가입 결과 : "+msg);
    }
}

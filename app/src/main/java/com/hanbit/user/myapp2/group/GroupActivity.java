package com.hanbit.user.myapp2.group;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hanbit.user.myapp2.R;

public class GroupActivity extends Activity implements View.OnClickListener{
    GroupDBHelper  groupHelper;
    SQLiteDatabase db;
    EditText etName,etNum,etResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etNum = (EditText) findViewById(R.id.etNum);
        EditText etResult = (EditText) findViewById(R.id.etResult);
        ((Button)findViewById(R.id.btInit)).setOnClickListener(this);
        ((Button)findViewById(R.id.btInsert)).setOnClickListener(this);
        ((Button)findViewById(R.id.btFind)).setOnClickListener(this);
        ((Button)findViewById(R.id.btUpdate)).setOnClickListener(this);
        ((Button)findViewById(R.id.btDelete)).setOnClickListener(this);
        ((Button)findViewById(R.id.btList)).setOnClickListener(this);
        ((Button)findViewById(R.id.btCount)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btInit : // 초기화버튼
                db = groupHelper.getWritableDatabase();
                groupHelper.onUpgrade(db,1,2);
                db.close();
                break;
            case R.id.btInsert : // 등록
                db = groupHelper.getWritableDatabase();
                db.execSQL("INSERT INTO group(name,num) VALUES('IOI',20)");
                db.close();
                Toast.makeText(getApplicationContext(),"입력성공", Toast.LENGTH_LONG).show();
                break;
            case R.id.btFind : // 조회

                break;
            case R.id.btUpdate : // 수정

                break;
            case R.id.btDelete : // 삭제

                break;
            case R.id.btList : // 삭제
                db = groupHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery("SELECT * FROM group;",null);
                String name = "그룹이름"+"\r\n"+"-------------"+"\r\n";
                String num = "멤버수"+"\r\n"+"--------------"+"\r\n";

                break;
            case R.id.btCount : // 삭제

                break;
        }

    }
}










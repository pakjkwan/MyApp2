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
        Cursor cursor = null;
        String id=null,name=null,num=null;
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
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT *FROM group WHERE _id = 1;",null);
                id = String.valueOf(cursor.getInt(0));
                name = cursor.getString(1);
                num = String.valueOf(cursor.getInt(2));
                etResult.setText("NO."+id);
                etResult.setText("그룹명 : "+name);
                etResult.setText("멤버수 : "+num);
                break;
            case R.id.btUpdate : // 수정
                db = groupHelper.getWritableDatabase();
                db.execSQL("UPDATE TABLE group SET num = 30 WHERE _id = 1;");
                etResult.setText("수정 완료");
                db.close();
                break;
            case R.id.btDelete : // 삭제
                db = groupHelper.getWritableDatabase();
                db.execSQL("DELETE FROM group WHERE _id = 1");
                etResult.setText("삭제 완료");
                db.close();
                break;
            case R.id.btList : // 목록
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM group;",null);
                id = "NO"+"\r\n"+"-------------"+"\r\n";
                name = "그룹이름"+"\r\n"+"-------------"+"\r\n";
                num = "멤버수"+"\r\n"+"--------------"+"\r\n";
                while (cursor.moveToNext()){
                    id += cursor.getInt(0) + "\r\n";
                    name += cursor.getString(1) + "\r\n";
                    num += cursor.getInt(2) + "\r\n";
                }

                etResult.setText(id);
                etResult.setText(name);
                etResult.setText(num);
                cursor.close();
                db.close();
                break;
            case R.id.btCount : // 삭제
                db = groupHelper.getReadableDatabase();
                cursor = db.rawQuery("SELECT * FROM group;",null);
                int count = cursor.getCount();
                cursor.close();
                etResult.setText("DB에 저장된 값의 갯수 : "+ count);
                db.close();
                break;
        }

    }
}









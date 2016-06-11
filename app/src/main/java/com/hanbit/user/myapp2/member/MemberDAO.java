package com.hanbit.user.myapp2.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by USER on 2016-06-11.
 */
public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context) {
        super(context, "hanbitDB", null, 1);
        // DB_NAME, null, DB_VERSION
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String signup(MemberBean member) {
        String name = member.getName();
        String id = member.getId();
        String pw = member.getPw();
        String email = member.getEmail();

        Log.i("name",name);
        Log.i("id",id);
        Log.i("pw",pw);
        Log.i("email",email);

        return "회원가입을 축하합니다";
    }

    public MemberBean login(MemberBean member) {
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor =
        db.rawQuery("select id,pw,name,email from member where id = '"+member.getId()
                +"' and pw = '"+member.getPw()+"'",null);
        String cid = "";
        String cpw = "";
        String cName = "";
        String cEmail = "";
        while (cursor.moveToNext()){
            cid = cursor.getString(0);
            cpw = cursor.getString(1);
            cName = cursor.getString(2);
            cEmail = cursor.getString(3);
        }
        MemberBean mem = new MemberBean();
        mem.setId(cid);
        mem.setName(cName);
        mem.setPw(cpw);
        mem.setEmail(cEmail);
        Log.i("id",cid);
        Log.i("pw",cpw);
        Log.i("name",cName);
        Log.i("email",cEmail);
        cursor.close();
        db.close();
        return mem;
    }

    public MemberBean update(MemberBean member) {
        MemberBean mem = new MemberBean();
        return mem;
    }

    public String delete(MemberBean member) {
        return "삭제완료";
    }


}

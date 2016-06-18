package com.hanbit.user.myapp2.movie;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.hanbit.user.myapp2.R;

public class MovieActivity extends Activity {
    GridView gv;
    MovieGridAdapter adapter;
    Integer[] posterID = {
            R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,
            R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,
            R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,
            R.drawable.mov10
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setTitle("그리드 뷰 영화 포스터");
        gv = (GridView) findViewById(R.id.gv);
        adapter = new MovieGridAdapter(this);
        gv.setAdapter(adapter);
    }
    public int getCount(){
        return posterID.length;
    }
    public View getView(int pos, View view, ViewGroup vg){
        ImageView iv = new ImageView(MovieActivity.this);
        iv.setLayoutParams(new GridView.LayoutParams(100,150));
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);

        iv.setImageResource(posterID[pos]);
        return iv;
    }
}

package com.hanbit.user.myapp2.movie;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.hanbit.user.myapp2.R;

public class MovieActivity extends Activity {
    GridView gv;
    MovieGridAdapter adapter;
    // final int pos;
    Integer[] posterID = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        setTitle("그리드 뷰 영화 포스터");
        gv = (GridView) findViewById(R.id.gv);
        adapter = new MovieGridAdapter(this);
        gv.setAdapter(adapter);

    }

    public int getCount() {
        return posterID.length;
    }

    public View getView(int position, View view, ViewGroup vg) {
        ImageView iv = new ImageView(MovieActivity.this);
        iv.setLayoutParams(new GridView.LayoutParams(100, 150));
        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
        iv.setPadding(5, 5, 5, 5);
        final int pos = position;
        iv.setImageResource(posterID[pos]);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = View.inflate(MovieActivity.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MovieActivity.this);
                ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                ivPoster.setImageResource(posterID[pos]);
                dlg.setTitle("큰포스터");
                // dlg.setIcon(R.drawable.ic)
                dlg.setView(dialogView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

        return iv;
    }

}














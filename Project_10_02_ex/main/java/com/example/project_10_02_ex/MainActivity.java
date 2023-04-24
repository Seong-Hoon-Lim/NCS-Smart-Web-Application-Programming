package com.example.project_10_02_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gridView = (GridView) findViewById(R.id.gridView);
        MyGridAdapter gridAdapter = new MyGridAdapter(this);
        gridView.setAdapter(gridAdapter);

    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        Integer[] posterId = {
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov11, R.drawable.mov12, R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
                R.drawable.mov16, R.drawable.mov17, R.drawable.mov18, R.drawable.mov19, R.drawable.mov20,
                R.drawable.mov21, R.drawable.mov22, R.drawable.mov23, R.drawable.mov24, R.drawable.mov25,
                R.drawable.mov26, R.drawable.mov27, R.drawable.mov28, R.drawable.mov29, R.drawable.mov30,
                R.drawable.mov31, R.drawable.mov32, R.drawable.mov33, R.drawable.mov34, R.drawable.mov35,
                R.drawable.mov36, R.drawable.mov37, R.drawable.mov38, R.drawable.mov39, R.drawable.mov40,
                R.drawable.mov41, R.drawable.mov42, R.drawable.mov43, R.drawable.mov44, R.drawable.mov45,
                R.drawable.mov46, R.drawable.mov47, R.drawable.mov48, R.drawable.mov49, R.drawable.mov50,
                R.drawable.mov51, R.drawable.mov52, R.drawable.mov53, R.drawable.mov54, R.drawable.mov55,
                R.drawable.mov56, R.drawable.mov57, R.drawable.mov58, R.drawable.mov59, R.drawable.mov60,
                R.drawable.mov61, R.drawable.mov62, R.drawable.mov63, R.drawable.mov64, R.drawable.mov65,
                R.drawable.mov66, R.drawable.mov67, R.drawable.mov68, R.drawable.mov69, R.drawable.mov70,
                R.drawable.mov71, R.drawable.mov72, R.drawable.mov73, R.drawable.mov74, R.drawable.mov75,
                R.drawable.mov76, R.drawable.mov77, R.drawable.mov78, R.drawable.mov79, R.drawable.mov80,
        };

        public MyGridAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        /*
         영화 포스터의 개수만큼 반복.
         영화 포스터를 그리드뷰 한개 씩 넣어줌
         */
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterId[i]);

            final int pos = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    ImageView imageView = (ImageView) dialogView.findViewById(R.id.imageViewPoster);
                    imageView.setImageResource(posterId[pos]);
                    builder.setTitle("큰 포스터");
                    builder.setIcon(R.drawable.movie_icon);
                    builder.setView(dialogView);
                    builder.setNegativeButton("닫기", null);
                    builder.show();
                }
            });
            return imageView;
        }
    }
}

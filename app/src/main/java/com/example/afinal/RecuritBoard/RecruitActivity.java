// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.RecuritBoard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinal.ApplyBoard.Features.ShowPostList.ApplyPostListActivity;
import com.example.afinal.R;
import com.example.afinal.hamburger;
import com.example.afinal.menuActivity2;

import androidx.appcompat.app.AppCompatActivity;

public class RecruitActivity extends AppCompatActivity {
    private ImageView imageView01, imageView02, imageView03, imageView04;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recurit_post_list);
        findViewById(R.id.projectgh).setOnClickListener(onClickListener);
        findViewById(R.id.fab).setOnClickListener(onClickListener);

    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.projectgh:
                    myStartActivity(boardActivity.class);
                    break;
                case R.id.fab:
                    myStartActivity(RecruitPostActivity.class);
                    break;
            }
        }
    };

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}

// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.ShowPostList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.afinal.R;
import com.example.afinal.hamburger;

import androidx.appcompat.app.AppCompatActivity;

public class ApplyBimActivity extends AppCompatActivity {

    private String phoneNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_click2);

        phoneNum = "01012345677";

        findViewById(R.id.call).setOnClickListener(onClickListener);
        findViewById(R.id.message).setOnClickListener(onClickListener);
    }

/*
작성자: 2015023025 배나영
역할: 메시지 전송, 전화 걸기 기능
*/

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.call:
                    startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phoneNum)));
                    break;
                case R.id.message:
                    Uri n = Uri.parse("smsto: " + phoneNum);
                    Intent intent = new Intent(Intent.ACTION_SENDTO, n);
                    startActivity(intent);
                    break;
            }
        }
    };
}
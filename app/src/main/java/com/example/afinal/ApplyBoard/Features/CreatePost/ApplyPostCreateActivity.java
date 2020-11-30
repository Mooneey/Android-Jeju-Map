// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.CreatePost;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.ApplyBoard.Features.ShowPostList.ApplyPostListActivity;
import com.example.afinal.ApplyBoard.Features.ShowPostList.ApplyPostListAfterActivity;
import com.example.afinal.R;
import com.example.afinal.hamburger;
import com.example.afinal.menuActivity2;

import androidx.appcompat.app.AppCompatActivity;

public class ApplyPostCreateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_post_create);

        final TextView moodBtn=findViewById(R.id.atmTextView);
        final TextView periodBtn=findViewById(R.id.periodTextView);

        ImageButton imagebutton2=(ImageButton)findViewById(R.id.imageButton2);//햄버거메뉴
        imagebutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent0=new Intent(ApplyPostCreateActivity.this, hamburger.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent0);
            }
        });

        moodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 클릭시 팝업 메뉴가 나오게 하기
                // PopupMenu 는 API 11 레벨부터 제공한다
                PopupMenu p = new PopupMenu(
                        getApplicationContext(), // 현재 화면의 제어권자
                        v); // anchor : 팝업을 띄울 기준될 위젯
                getMenuInflater().inflate(R.menu.mood_main, p.getMenu());
                // 이벤트 처리
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch(item.getItemId()){
                            case R.id.Option1:
                                moodBtn.setText("깨끗한");
                                break;
                            case R.id.Option2:
                                moodBtn.setText("아늑한");
                                break;
                            case R.id.Option3:
                                moodBtn.setText("신나는");
                                break;
                            case R.id.Option4:
                                moodBtn.setText("엄근진");
                                break;
                            case R.id.Option5:
                                moodBtn.setText("포스 철철");
                                break;
                            case R.id.Option6:
                                moodBtn.setText("트월킹");
                                break;
                        }
                        return false;
                    }
                });
                p.show(); // 메뉴를 띄우기
            }
        });

        periodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼 클릭시 팝업 메뉴가 나오게 하기
                // PopupMenu 는 API 11 레벨부터 제공한다
                PopupMenu p = new PopupMenu(
                        getApplicationContext(), // 현재 화면의 제어권자
                        v); // anchor : 팝업을 띄울 기준될 위젯
                getMenuInflater().inflate(R.menu.period_main, p.getMenu());
                // 이벤트 처리
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.option_2to4_week:
                                periodBtn.setText("2주 ~ 4주");
                                break;
                            case R.id.option_1month:
                                periodBtn.setText("1개월");
                                break;
                            case R.id.option_2month:
                                periodBtn.setText("2개월");
                                break;
                            case R.id.option_3to6month:
                                periodBtn.setText("3개월 ~ 6개월");
                                break;
                            case R.id.option_6toYear:
                                periodBtn.setText("6개월 ~ 1년");
                                break;
                            case R.id.option_moreThanYear:
                                periodBtn.setText("1년 이상");
                                break;
                        }
                        return false;
                    }
                });
                p.show(); // 메뉴를 띄우기
            }
        });

        findViewById(R.id.createButton).setOnClickListener(onClickListener);
        findViewById(R.id.cancelButton).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.createButton:
                    myStartActivity(ApplyPostListAfterActivity.class);
                    finish();
                    break;
                case R.id.cancelButton:
                    myStartActivity(ApplyPostListActivity.class);
                    break;
            }
        }
    };

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}

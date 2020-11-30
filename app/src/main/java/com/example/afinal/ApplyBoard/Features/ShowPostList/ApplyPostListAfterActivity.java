// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.ShowPostList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.afinal.ApplyBoard.Database.DatabaseQueryClass;
import com.example.afinal.ApplyBoard.Features.CreatePost.ApplyPostCreateActivity;
import com.example.afinal.ApplyBoard.Features.CreatePost.Post;
import com.example.afinal.R;
import com.example.afinal.hamburger;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ApplyPostListAfterActivity extends AppCompatActivity {

    private DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(this);

    private List<Post> postList = new ArrayList<>();

    private RecyclerView recyclerView;
    private PostListRecyclerViewAdapter postListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_post_list_after);
        // recyclerView = (RecyclerView) findViewById(R.id.postRecyclerView);

        //  postList.addAll(databaseQueryClass.getAllPost());
        //postList.addAll((Collection<? extends Post>) databaseQueryClass.getAllPost());


        // postListRecyclerViewAdapter = new PostListRecyclerViewAdapter(this, postList);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // recyclerView.setAdapter(postListRecyclerViewAdapter);
        ImageButton imagebutton2=(ImageButton)findViewById(R.id.imageButton2);//햄버거메뉴
        imagebutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent0=new Intent(ApplyPostListAfterActivity.this, hamburger.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent0);
            }
        });
        findViewById(R.id.fab).setOnClickListener(onClickListener);
        findViewById(R.id.cham).setOnClickListener(onClickListener);
        findViewById(R.id.bim).setOnClickListener(onClickListener);
        findViewById(R.id.moon).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fab:
                    myStartActivity(ApplyPostCreateActivity.class);
                    break;
                case R.id.moon:
                    myStartActivity(ApplyMoonActivity.class);
                    break;
                case R.id.cham:
                  //  myStartActivity(ApplyChamActivity.class);
                    Toast.makeText(ApplyPostListAfterActivity.this, "개인 회원은 열람할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.bim:
                  //  myStartActivity(ApplyBimActivity.class);
                    Toast.makeText(ApplyPostListAfterActivity.this, "개인 회원은 열람할 수 없습니다.", Toast.LENGTH_SHORT).show();

                    break;

            }
        }
    };

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}

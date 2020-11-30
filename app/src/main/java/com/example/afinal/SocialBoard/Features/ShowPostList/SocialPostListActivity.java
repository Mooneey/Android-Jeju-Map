// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.SocialBoard.Features.ShowPostList;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.afinal.R;
import com.example.afinal.SocialBoard.Database.DatabaseQueryClass;
import com.example.afinal.SocialBoard.Features.CreatePost.Post;
import com.example.afinal.SocialBoard.Features.CreatePost.PostCreateDialogFragment;
import com.example.afinal.SocialBoard.Features.CreatePost.PostCreateListener;
import com.example.afinal.SocialBoard.Util.Config;
import com.example.afinal.hamburger;
import com.example.afinal.menuActivity2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SocialPostListActivity extends AppCompatActivity implements PostCreateListener {

    private DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(this);

    private List<Post> postList = new ArrayList<>();

    private RecyclerView recyclerView;
    private PostListRecyclerViewAdapter postListRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_post_list);
        Logger.addLogAdapter(new AndroidLogAdapter());

        recyclerView = (RecyclerView) findViewById(R.id.postRecyclerView);

        postList.addAll(databaseQueryClass.getAllPost());
        //postList.addAll((Collection<? extends Post>) databaseQueryClass.getAllPost());


        postListRecyclerViewAdapter = new PostListRecyclerViewAdapter(this, postList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(postListRecyclerViewAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPostCreateDialog();
            }
        });


        ImageButton imagebutton2=(ImageButton)findViewById(R.id.imageButton2);//햄버거메뉴
        imagebutton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myintent0=new Intent(SocialPostListActivity.this, hamburger.class);
                //페이지를 이동시켜주는 Intent 이동할페이지명.this 도착할페이지명.class형식으로 작성
                startActivity(myintent0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void openPostCreateDialog() {
        PostCreateDialogFragment postCreateDialogFragment = PostCreateDialogFragment.newInstance("Create Post", this);
        postCreateDialogFragment.show(getSupportFragmentManager(), Config.CREATE_POST);
    }

    @Override
    public void onPostCreated(Post post) {
        postList.add(post);
        postListRecyclerViewAdapter.notifyDataSetChanged();
        Logger.d(post.getUserName());
    }
}

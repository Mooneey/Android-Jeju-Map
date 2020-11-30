// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.SocialBoard.Features.CreatePost;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.afinal.R;
import com.example.afinal.SocialBoard.Database.DatabaseQueryClass;
import com.example.afinal.SocialBoard.Util.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.fragment.app.DialogFragment;


public class PostCreateDialogFragment extends DialogFragment {

    private static PostCreateListener postCreateListener;

    private EditText titleEditText;
    private EditText contentEditText;
    private ImageButton createButton;
    private ImageButton cancelButton;

    private String titleString = "";
    private String contentString = "";

    private String formatDate = "";

    public PostCreateDialogFragment() {
        // Required empty public constructor
    }

    public static PostCreateDialogFragment newInstance(String text, PostCreateListener listener){
        postCreateListener = listener;
        PostCreateDialogFragment postCreateDialogFragment = new PostCreateDialogFragment();
        Bundle args = new Bundle();
        args.putString("text", text);
        postCreateDialogFragment.setArguments(args);

        postCreateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return postCreateDialogFragment;
    }

    private void dateNow() {
        //현재시간을 msec으로 구함.
        long now = System.currentTimeMillis();
        // 현재시간을 date 변수에 저장
        Date date = new Date(now);
        // 시간을 나타낼 포맷을 정함 (yyyy/MM/dd)
        SimpleDateFormat sdfNow = new SimpleDateFormat();
        // String 변수에 값을 저장
        formatDate = sdfNow.format(date);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_social_post_create_dialog, container, false);

        titleEditText = view.findViewById(R.id.titleEditText);
        contentEditText = view.findViewById(R.id.contentEditText);
        createButton = view.findViewById(R.id.createButton);
        cancelButton = view.findViewById(R.id.cancelButton);

        String text = getArguments().getString(Config.TEXT);

        getDialog().setTitle(text);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleString = titleEditText.getText().toString();
                contentString = contentEditText.getText().toString();

                Post post = new Post(-1, "bBbBiiinn", titleString, contentString);

                DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(getContext());

                long id = databaseQueryClass.insertPost(post);

                if(id>0){
                    post.setId(id);
                    postCreateListener.onPostCreated(post);
                    getDialog().dismiss();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            //noinspection ConstantConditions
            dialog.getWindow().setLayout(width, height);
        }
    }

}

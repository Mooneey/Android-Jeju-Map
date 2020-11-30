// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.SocialBoard.Features.UpdatePostInfo;

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
import com.example.afinal.SocialBoard.Features.CreatePost.Post;
import com.example.afinal.SocialBoard.Util.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.fragment.app.DialogFragment;


public class PostUpdateDialogFragment extends DialogFragment {

    private static long postRegNo;
    private static int postItemPosition;
    private static PostUpdateListener postUpdateListener;

    private Post mPost;

    private EditText titleEditText;
    private EditText contentEditText;
    private ImageButton updateButton;
    private ImageButton cancelButton;

    private String titleString = "";
    private String contentString = "";

    private String formatDate;

    private DatabaseQueryClass databaseQueryClass;

    public PostUpdateDialogFragment() {
        // Required empty public constructor
    }

    public static PostUpdateDialogFragment newInstance(long registrationNumber, int position, PostUpdateListener listener){
        postRegNo = registrationNumber;
        postItemPosition = position;
        postUpdateListener = listener;
        PostUpdateDialogFragment postUpdateDialogFragment = new PostUpdateDialogFragment();
        Bundle args = new Bundle();
        args.putString("text", "Update student information");
        postUpdateDialogFragment.setArguments(args);

        postUpdateDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return postUpdateDialogFragment;
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

        View view = inflater.inflate(R.layout.fragment_social_post_update_dialog, container, false);

        databaseQueryClass = new DatabaseQueryClass(getContext());

        titleEditText = view.findViewById(R.id.titleEditText);
        contentEditText = view.findViewById(R.id.contentEditText);
        updateButton = view.findViewById(R.id.updateStudentInfoButton);
        cancelButton = view.findViewById(R.id.cancelButton);

        String text = getArguments().getString(Config.TEXT);
        getDialog().setTitle(text);

        mPost = databaseQueryClass.getPostByRegNum(postRegNo);

        if(mPost !=null){
            titleEditText.setText(mPost.getTitle());
            contentEditText.setText(String.valueOf(mPost.getContent()));

            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    titleString = titleEditText.getText().toString();
                    contentString = contentEditText.getText().toString();

                    mPost.setUserName("bBbBiiinn");
                    mPost.setTitle(titleString);
                    mPost.setContent(contentString);

                    long id = databaseQueryClass.updatePostInfo(mPost);

                    if(id>0){
                        postUpdateListener.onPostInfoUpdated(mPost, postItemPosition);
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

        }
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

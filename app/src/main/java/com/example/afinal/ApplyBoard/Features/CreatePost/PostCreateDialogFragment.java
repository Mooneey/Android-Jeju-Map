// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.CreatePost;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.afinal.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.fragment.app.DialogFragment;


public class PostCreateDialogFragment extends DialogFragment {

    private EditText titleEditText;
    private EditText contentEditText;
    private Button createButton;
    private Button cancelButton;
    private TextView periodTextView;
    private TextView atmTextView;
    private String formatDate;

    public PostCreateDialogFragment() {
        // Required empty public constructor
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_apply_post_create, container, false);

        titleEditText = view.findViewById(R.id.titleEditText);
        contentEditText = view.findViewById(R.id.contentEditText);
        createButton = view.findViewById(R.id.createButton);
        cancelButton = view.findViewById(R.id.cancelButton);
        periodTextView = view.findViewById(R.id.periodTextView);
        atmTextView = view.findViewById(R.id.atmTextView);


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

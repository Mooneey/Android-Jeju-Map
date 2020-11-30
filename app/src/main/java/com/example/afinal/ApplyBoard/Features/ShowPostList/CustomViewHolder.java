// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.ShowPostList;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinal.R;

import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView titleTextView;
    TextView contentTextView;
    TextView userNameTextView;
    ImageView crossButtonImageView;
    ImageView editButtonImageView;

    public CustomViewHolder(View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.titleTextView);
        contentTextView = itemView.findViewById(R.id.contentTextView);
        userNameTextView = itemView.findViewById(R.id.userNameTextView);
        crossButtonImageView = itemView.findViewById(R.id.crossImageView);
        editButtonImageView = itemView.findViewById(R.id.editImageView);
    }
}

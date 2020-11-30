// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.ShowPostList;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.afinal.ApplyBoard.Database.DatabaseQueryClass;
import com.example.afinal.ApplyBoard.Features.CreatePost.Post;
import com.example.afinal.ApplyBoard.Features.UpdatePostInfo.PostUpdateDialogFragment;
import com.example.afinal.ApplyBoard.Features.UpdatePostInfo.PostUpdateListener;
import com.example.afinal.ApplyBoard.Util.Config;
import com.example.afinal.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class PostListRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<Post> postList;
    private DatabaseQueryClass databaseQueryClass;

    public PostListRecyclerViewAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
        databaseQueryClass = new DatabaseQueryClass(context);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.apply_post_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final int itemPosition = position;
        final Post post = postList.get(position);

   //     holder.titleTextView.setText(post.getTitle());
//        holder.contentTextView.setText(post.getContent());
  //      holder.userNameTextView.setText((post.getUserName()));

        holder.crossButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Are you sure, You wanted to delete this post?");
                        alertDialogBuilder.setPositiveButton("Yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        deletePost(itemPosition);
                                    }
                                });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        holder.editButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostUpdateDialogFragment postUpdateDialogFragment = PostUpdateDialogFragment.newInstance(post.getId(), itemPosition, new PostUpdateListener(){
                    @Override
                    public void onPostInfoUpdated(Post post, int position) {
                        postList.set(position, post);
                        notifyDataSetChanged();
                    }
                });
                postUpdateDialogFragment.show(((ApplyPostListActivity) context).getSupportFragmentManager(), Config.UPDATE_POST);
            }
        });
    }

    private void deletePost(int position) {
        Post post = postList.get(position);
        long count = databaseQueryClass.deletePostByRegNum(post.getId());

        if(count>0){
            postList.remove(position);
            notifyDataSetChanged();
            Toast.makeText(context, "Post deleted successfully", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(context, "Post not deleted. Something wrong!", Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}

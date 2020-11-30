// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.SocialBoard.Features.UpdatePostInfo;
import com.example.afinal.SocialBoard.Features.CreatePost.Post;

public interface PostUpdateListener {
    void onPostInfoUpdated(Post post, int position);
}

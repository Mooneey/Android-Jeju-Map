// Copyright 2020. 문재식 All rights reserved //


package com.example.afinal.ApplyBoard.Features.UpdatePostInfo;

import com.example.afinal.ApplyBoard.Features.CreatePost.Post;

public interface PostUpdateListener {
    void onPostInfoUpdated(Post post, int position);
}

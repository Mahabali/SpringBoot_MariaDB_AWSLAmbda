package com.serverless.rest.restapi.service;

import java.util.Collection;

import com.serverless.rest.restapi.dao.PostDao;
import com.serverless.rest.restapi.model.*;
public interface PostService{
    public abstract Collection<PostDao> getAllPosts();
    public abstract void createPost(Post post);
    public abstract void updatePost(Integer id, Post Post);
    public abstract void deletePost(Integer id);
}
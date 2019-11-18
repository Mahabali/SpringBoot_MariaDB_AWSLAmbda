package com.serverless.rest.restapi.service;

import com.serverless.rest.restapi.service.PostService;
import com.serverless.rest.restapi.dao.PostRepository;
import com.serverless.rest.restapi.dao.PostDao;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.serverless.rest.restapi.model.Post;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    private static Map<Integer, Post> postMap = new HashMap<>();
    // private final AtomicLong counter = new AtomicLong();

    public void createPost(Post post) {
        PostDao newPost = new PostDao(post.getContent());
        System.out.println(" ** " + newPost.getId() + "  - " + newPost.getPost());
        this.postRepository.save(newPost);
        // post.setId(counter.incrementAndGet());
        // postMap.put(post.getId(), post);
    }

    public void updatePost(Integer id, Post post) {
        
        post.setId(id);
        Optional<PostDao> optionalPost = this.postRepository.findById(id);
        if(optionalPost.isPresent()){
            PostDao updatePostDao = optionalPost.get();
            updatePostDao.setPost(post.getContent());
            this.postRepository.save(updatePostDao);
            System.out.println("Updated successfully");
        }
        
    }

    public void deletePost(Integer id) {
        this.postRepository.deleteById(id);
        System.out.println("deleting " + id + " values count " + this.postRepository.count());
    }

    public Collection<PostDao> getAllPosts() {

        Iterable<PostDao> posts = this.postRepository.findAll();
        Collection<PostDao> postCollection = new ArrayList<PostDao>();
        for(PostDao d : posts){
            postCollection.add(d);
        }
        return postCollection;
    }
}
package com.serverless.rest.restapi.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Post {
    private  Integer id;
    @NotNull(message = "Please provide a content")
    @NotEmpty(message = "Please provide a content")
    private  String content;

    // public Post(Integer id, String content) {
    //     this.id = id;
    //     this.content = content;
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
     }
}
package com.serverless.rest.restapi.dao;
import javax.persistence.*;
@Entity
@Table(name = "post_tbl")
public class PostDao{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String post;

    public PostDao() {
    }
    public PostDao(String post) {
        this.post = post;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
}
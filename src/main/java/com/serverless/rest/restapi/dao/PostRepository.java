package com.serverless.rest.restapi.dao;

import org.springframework.data.repository.CrudRepository;
public interface PostRepository extends CrudRepository<PostDao, Integer> {
   
}
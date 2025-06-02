package com.myblog11.services;

import com.myblog11.payloads.PostDto;
import com.myblog11.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
    //update
    PostDto updatePost(PostDto postDto, Integer postId);
    //get single post
    PostDto getPostById(Integer postId);
    //get all post
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
    //delete
    void deletePost(Integer postId);
    //get all post by category
    List<PostDto>getPostsByCategory(Integer categoryId);
    //get all post by user
    List<PostDto>getPostsByUser(Integer userId);
    //search posts
    List<PostDto>searchPosts(String keyword);

}

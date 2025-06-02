package com.myblog11.services;

import com.myblog11.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Integer commentId);
}

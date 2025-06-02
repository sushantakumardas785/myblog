package com.myblog11.controllers;

import com.myblog11.payloads.ApiResponse;
import com.myblog11.payloads.CommentDto;
import com.myblog11.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto>createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId){
        CommentDto createComment = this.commentService.createComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse>deleteComment(@PathVariable Integer commentId) {
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted Successfully", true), HttpStatus.CREATED);
    }
}

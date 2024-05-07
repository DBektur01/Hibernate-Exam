package Java13.service;

import Java13.entity.Comment;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface CommentService {
    String saveCommentByBlogPostId(Long id, Comment comment);
    Comment getCommentById(Long id);
    String updateCommentTextById(Long id , String newComment_text);
    String deleteComment(Long id);
    List<Comment> sortByPublisherDate(String ascOrDesc);
    String groupCommentsByPost(Long postId);
}

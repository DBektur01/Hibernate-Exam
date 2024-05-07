package Java13.service.serviceImpl;

import Java13.dao.CommentDao;
import Java13.dao.daoImpl.CommentDaoImpl;
import Java13.entity.Comment;
import Java13.service.CommentService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class CommentServiceImpl implements CommentService {
    private CommentDao dao;
    @Override
    public String saveCommentByBlogPostId(Long id, Comment comment ) {
        return dao.saveCommentByBlogPostId(id, comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return dao.getCommentById(id);
    }

    @Override
    public String updateCommentTextById(Long id, String newComment_text) {
        return dao.updateCommentTextById(id, newComment_text);
    }

    @Override
    public String deleteComment(Long id) {
        return dao.deleteComment(id);
    }

    @Override
    public List<Comment> sortByPublisherDate(String ascOrDesc) {
        return dao.sortByPublisherDate(ascOrDesc);
    }

    @Override
    public String groupCommentsByPost(Long postId) {
        return dao.groupCommentsByPost(postId);
    }
}

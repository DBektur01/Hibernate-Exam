package Java13.service.serviceImpl;

import Java13.dao.BlogPostDao;
import Java13.dao.daoImpl.BlogPostDaoImpl;
import Java13.entity.BlogPost;
import Java13.service.BlogPostService;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public class BlogPostServiceImpl implements BlogPostService {
    private BlogPostDao dao;
    @Override
    public String saveBlogPost(BlogPost blogPost) {
        return dao.saveBlogPost(blogPost);
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        return dao.getBlogPostById(id);
    }

    @Override
    public String updateBlogPostById(Long id, String content) {
        return dao.updateBlogPostById(id, content);
    }

    @Override
    public String deleteBlogPostById(Long id) {
        return dao.deleteBlogPostById(id);
    }

    @Override
    public List<BlogPost> getAllBlogPost() {
        return dao.getAllBlogPost();
    }

    @Override
    public List<BlogPost> searchBlogPostByKeyword(Long keyword) {
        return dao.searchBlogPostByKeyword(keyword);
    }
}

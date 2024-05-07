package Java13.service;

import Java13.entity.BlogPost;

import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
public interface BlogPostService {
    String saveBlogPost(BlogPost blogPost);
    BlogPost getBlogPostById(Long id);
    String updateBlogPostById(Long id , String content);
    String deleteBlogPostById(Long id);
    List<BlogPost> getAllBlogPost();
    List<BlogPost>  searchBlogPostByKeyword ( Long keyword);
}

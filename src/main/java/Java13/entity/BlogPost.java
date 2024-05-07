package Java13.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "blog_posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BlogPost extends GenerateID {
    @SequenceGenerator(name = "id_gen", sequenceName = "blog_seg", allocationSize = 1)
    private Long id;
    private String title;
    private String content;
    private LocalDate publisher_date;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.REMOVE})
    private Comment comments;

    public BlogPost(String title, String content, LocalDate publisher_date) {
        this.title = title;
        this.content = content;
        this.publisher_date = publisher_date;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publisher_date=" + publisher_date +
                '}';
    }
}
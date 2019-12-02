package by.pdu.library.repository;

import by.pdu.library.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleMapper {
    List<Article> getArticle();

    void insertArticle(@Param("id") Long id, @Param("name") String name, @Param("catalogId") String catalogId);

    void removeArticle(Long id);

    void updateArticle(@Param("id") Long id, @Param("name") String name, @Param("catalogId") String catalogId);

    void insertAuthor(@Param("authorId") Long authorId, @Param("articleId") Long articleID);

    void removeAllAuthor(Long id);

    Long nextId();
}

package by.pdu.library.repository;

import by.pdu.library.domain.Book;
import by.pdu.library.domain.Edition;
import by.pdu.library.domain.Periodic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BookMapper {
    List<Book> getBook();

    List<Periodic> getPeriodic();

    void insertBook(@Param("id") Long id,
                    @Param("year") Long year,
                    @Param("image") String image,
                    @Param("name") String name,
                    @Param("language") Long language,
                    @Param("price") Float price,
                    @Param("publishing") Long publishing,
                    @Param("description") String description,
                    @Param("catalog") String catalog);

    void insertPeriodic(@Param("id") Long id,
                        @Param("year") Long year,
                        @Param("image") String image,
                        @Param("name") String name,
                        @Param("language") Long language,
                        @Param("price") Float price,
                        @Param("publishing") Long publishing,
                        @Param("number") Long number,
                        @Param("month") Long month);

    void updateBook(@Param("id") Long id,
                    @Param("year") Long year,
                    @Param("image") String image,
                    @Param("name") String name,
                    @Param("language") Long language,
                    @Param("price") Float price,
                    @Param("publishing") Long publishing,
                    @Param("description") String description,
                    @Param("catalog") String catalog);

    void updatePeriodic(@Param("id") Long id,
                        @Param("year") Long year,
                        @Param("image") String image,
                        @Param("name") String name,
                        @Param("language") Long language,
                        @Param("price") Float price,
                        @Param("publishing") Long publishing,
                        @Param("number") Long number,
                        @Param("month") Long month);

    void removeAllArticle(Long id);

    void removeAllAuthors(Long id);

    void insertAuthor(@Param("bookId") Long bookId, @Param("authorId") Long authorId);

    void insertArticle(@Param("periodicId") Long periodicId, @Param("articleId") Long articleId);

    void removeEdition(Long id);

    Long nextId();

    List <Edition> getEdition();

    List <Edition> getEdition(@Param("name") String name);
}

package by.pdu.library.repository;

import by.pdu.library.domain.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AuthorMapper {
    List<Author> getAuthor();

    void insertAuthor(String name);

    void removeAuthor(Long id);

    void updateAuthor(@Param("id") Long id, @Param("name") String name);

    List<Author> getAuthorBook(Long id);
}

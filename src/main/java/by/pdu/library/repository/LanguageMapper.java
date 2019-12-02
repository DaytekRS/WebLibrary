package by.pdu.library.repository;

import by.pdu.library.domain.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface LanguageMapper {
    Language getLanguageById(Integer id);

    List getLanguage();

    void insertLanguage(String name);

    void removeLanguage(Long id);

    void updateLanguage(@Param("id") Long id, @Param("name") String name);
}

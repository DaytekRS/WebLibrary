package by.pdu.library.repository;

import by.pdu.library.domain.Catalog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CatalogMapper {
    List<Catalog> getRootCatalog();

    List<Catalog> getCatalogByRoot(String id);

    Catalog getCatalogById(String id);

    void removeCatalog(String id);

    void insertRoot(@Param("id") String id, @Param("catalog") String catalog);

    void insertCatalog(@Param("id") String id, @Param("catalog") String catalog, @Param("rootId") String rootId);

    void updateRoot(@Param("oldId") String oldId,@Param("id") String id, @Param("catalog") String catalog);

    void updateCatalog(@Param("oldId") String oldId,@Param("id") String id, @Param("catalog") String catalog, @Param("rootId") String rootId);
}

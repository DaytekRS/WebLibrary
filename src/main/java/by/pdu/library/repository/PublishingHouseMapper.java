package by.pdu.library.repository;

import by.pdu.library.domain.PublishingHouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PublishingHouseMapper {
    List<PublishingHouse> getPublishingHouse();

    void insertPublishingHouse(String name);

    void updatePublishingHouse(@Param("id") Long id, @Param("name") String name);

    void removePublishingHouse(Long id);
}

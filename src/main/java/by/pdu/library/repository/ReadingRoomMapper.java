package by.pdu.library.repository;

import by.pdu.library.domain.ReadingRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReadingRoomMapper {
    List<ReadingRoom> getReadingRoom();

    void insertReadingRoom(@Param("name") String name, @Param("address") String address);

    void removeReadingRoom(Long id);

    void updateReadingRoom(@Param("id") Long id, @Param("name") String name, @Param("address") String address);

    void updateReadingRoom(ReadingRoom room);
}

package by.pdu.library.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface OrderMapper {
    void insertOrder(Long card, Long edition, Long room);
}

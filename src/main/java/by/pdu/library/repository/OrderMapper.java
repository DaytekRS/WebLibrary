package by.pdu.library.repository;

import by.pdu.library.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderMapper {
    void insertOrder(Long card, Long edition, Long room);

    List<Order> getOrderByIdUser(Long id);
}

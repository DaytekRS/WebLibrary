package by.pdu.library.repository;

import by.pdu.library.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    void updateUser(String email,String password);

    User searchUser(String search);

    void updatePassword(String email, String password);
}

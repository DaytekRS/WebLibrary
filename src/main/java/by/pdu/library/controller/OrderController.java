package by.pdu.library.controller;

import by.pdu.library.domain.User;
import by.pdu.library.repository.OrderMapper;
import by.pdu.library.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/orders")
    public String orders(Map<String, Object> model) {
        User authUser = userMapper.searchUser(SecurityContextHolder.getContext().getAuthentication().getName());
        System.out.println(authUser.getCardId());
        model.put("orders", orderMapper.getOrderByIdUser(authUser.getCardId()));
        System.out.println(orderMapper.getOrderByIdUser(authUser.getCardId()).get(0).getEmploye());
        return "orders";
    }
}

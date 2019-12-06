package by.pdu.library.controller;

import by.pdu.library.domain.Book;
import by.pdu.library.domain.Periodic;
import by.pdu.library.domain.User;
import by.pdu.library.repository.BookMapper;
import by.pdu.library.repository.OrderMapper;
import by.pdu.library.repository.ReadingRoomMapper;
import by.pdu.library.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private ReadingRoomMapper readingRoom;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/")
    public String index() {
        return "redirect:/main";
    }

    @RequestMapping("/book")
    public String selectBook(Map<String, Object> model,
                             @RequestParam Long id, @RequestParam(required = false) boolean success
    ) {
        model.put("rooms", readingRoom.getReadingRoom());
        Book book = bookMapper.getBookById(id);
        if (book != null) {
            model.put("book", book);
            return "book";
        }
        Periodic edition = bookMapper.getPeriodicById(id);
        if (edition != null) {
            model.put("book", edition);
            model.put("periodic", edition);
            return "book";
        }
        return "404";
    }

    @PostMapping("/book")
    public String selectBook(@RequestParam Long id, @RequestParam("readingRooms") Long idReadingRoom) {
        User authUser = userMapper.searchUser(SecurityContextHolder.getContext().getAuthentication().getName());
        orderMapper.insertOrder(authUser.getCardId(), id, idReadingRoom);
        return "redirect:/book?id=" + id + "&success=true";
    }
}

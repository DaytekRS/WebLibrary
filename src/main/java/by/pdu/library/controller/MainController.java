package by.pdu.library.controller;

import by.pdu.library.domain.Book;
import by.pdu.library.domain.Periodic;
import by.pdu.library.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/")
    public String index() {
        return "redirect:/main";
    }

    @RequestMapping("/book")
    public String selectBook(Map<String, Object> model,
                             @RequestParam Long id
    ) {
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
}

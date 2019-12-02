package by.pdu.library.controller.api;


import by.pdu.library.domain.Edition;
import by.pdu.library.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/api/books")
    List<Edition> getEdition() {
        return bookMapper.getEdition();
    }

    @RequestMapping(value = "/api/books", params = {"name"}, method = RequestMethod.GET)
    @ResponseBody
    public List<Edition> getEditionLike(@RequestParam("name") String name) {
        return bookMapper.getEdition("%" + name + "%");
    }
}

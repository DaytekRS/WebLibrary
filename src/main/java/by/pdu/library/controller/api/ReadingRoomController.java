package by.pdu.library.controller.api;

import by.pdu.library.domain.Edition;
import by.pdu.library.domain.ReadingRoom;
import by.pdu.library.repository.BookMapper;
import by.pdu.library.repository.ReadingRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReadingRoomController {
    @Autowired
    private ReadingRoomMapper readingRoom;

    @GetMapping("/api/readingrooms")
    List<ReadingRoom> getEdition() {
        return readingRoom.getReadingRoom();
    }
}

package by.pdu.library.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
    private Long id;
    private String employe;
    private Date dueDate;
    private String edition;
    private String readingRoom;
}

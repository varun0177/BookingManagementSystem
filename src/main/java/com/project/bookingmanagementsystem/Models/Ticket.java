package Models;

import enums.TicketStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private double amount;
    private List<Seat> seats=new ArrayList<>();
    private Show show;
    private TicketStatus ticketStatus;
    private Payment payment;

}

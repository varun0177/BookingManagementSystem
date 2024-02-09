package Models;

import enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Booking  extends BaseModel{
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> seats=new ArrayList<>();
    private double amount;
    private Date bookedAt;
    @Enumerated
    private PaymentStatus paymentStatus;
    @OneToMany
    private List<Payment> payments=new ArrayList<>();
}

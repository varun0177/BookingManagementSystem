package Models;

import enums.PaymentMode;
import enums.PaymentStatus;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private double amount;
    @Enumerated
    private PaymentMode paymentMode;
    @Enumerated
    private PaymentStatus paymentStatus;

}

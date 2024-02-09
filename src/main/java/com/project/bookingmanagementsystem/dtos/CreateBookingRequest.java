package dtos;

import Models.ShowSeat;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CreateBookingRequest {
    private Long customer_id;
    private Long show_id;
    private List<Long> showSeatsId;
}

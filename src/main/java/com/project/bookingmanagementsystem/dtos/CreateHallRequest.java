package dtos;

import enums.Features;
import enums.SeatType;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CreateHallRequest {
    private String name;
    private List<Features> features=new ArrayList<>();
    private Map<SeatType,List<SeatPosition>> seatRanges=new HashMap<>();
}

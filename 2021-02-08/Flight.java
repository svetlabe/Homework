package student.inheritance;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@ToString
public abstract class Flight {
    private String flightCode;
    private String from;
    private String to;
    private LocalTime departureTime;
    private double flightDuration;
    protected String type;
    protected int checkIn;


    public Flight(String code, String from, String to, LocalTime departueTime, Double flightDuration) {
        flightCode =  code;
        this.from = from;
        this.to = to;
        this.departureTime = departueTime;
        this.flightDuration = flightDuration;
    }
}

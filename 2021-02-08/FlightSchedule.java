package student.inhertance;

import java.time.LocalTime;
import java.util.Collection;
import java.util.HashMap;


public class FlightSchedule {
    private final HashMap<String,Flight> flightMap;
    private final ConsoleLogger logger;

    public FlightSchedule (ConsoleLogger logger) {
        flightMap = new HashMap<>();
        this.logger = logger;


    }

    public void addFlight(){
        Flight flightToAdd = createFlight();
        flightMap.put(flightToAdd.getFlightCode(), flightToAdd);
        logger.logMessage("This flight has been added: " + flightToAdd);
        logger.logMessage("------------------------------------------");

    }

    public Flight createFlight(){
        Flight flight = null;
        logger.logMessage("Enter flight code for SK (3 digits): ");
        String pattern = "[0-9][0-9][0-9]";
        String flightCode = logger.getCode(pattern);
        logger.logMessage("Enter from: ");
        String from = logger.getString();
        logger.logMessage("Enter to : ");
        String to = logger.getString();
        logger.logMessage("Enter time for departure: ");
        LocalTime departureTime = logger.getTime();
        logger.logMessage("Enter duration for this flight: ");
        Double duration = logger.getDouble();
        logger.logMessage("What type of flight is this: LH ot SH? ");
        String type = logger.getString();
        while (!type.equalsIgnoreCase("sh")  &&  !type.equalsIgnoreCase("lh") ){
            logger.logMessage("Enter type: sh or lh");
            type = logger.getString();
        }
        if (type.equalsIgnoreCase("lh")) {
            flight = new LongHaulFlight(flightCode, from, to, departureTime, duration);

        } else  {
            flight = new ShortHaulFlight(flightCode, from, to, departureTime, duration);

        }
        return flight;
    }

    public boolean isValidFlight(String flightCode){
        return flightMap.containsKey(flightCode);
    }

    public void findFlight(){

        if (!checkCollection()){
            logger.logMessage("Nothing to show. Add flights to the system.");
            return;
        }
        logger.logMessage("Enter a flight code: ");
        String flightCode = logger.getString().toUpperCase();
        if (isValidFlight(flightCode)){
            Flight flightToFind = flightMap.get(flightCode);
            if (flightToFind != null){
                logger.logMessage(flightToFind.toString());
            }

        } else {
            logger.logMessage("Not found.");
        }

    }

    public void displayAllFlights(){
        if(!checkCollection()){
            System.out.println("Nothing to show. Add flights to the system.");
        } else {
            Collection<Flight> flights = flightMap.values();
            for (Flight f : flights) {
                System.out.println(f.toString());
            }
        }
        

    }

    public void countShortHaul(){
        int count = 0;

        if(checkCollection()){
            Collection<Flight> flights = flightMap.values();
            for(Flight f: flights) {
                if (f.getType().equals("Short Haul")) {
                    count++;
                }
            }
            System.out.println("There are " + count + " short haul flights");
        } else {
            System.out.println("Nothing to show. Add a flight to the system.");
        }


    }

    public void countLongHaul(){
        int count = 0;

        if(checkCollection()){
            Collection<Flight> flights = flightMap.values();
            for(Flight f: flights) {
                if (f.getType().equals("Long Haul")) {
                    count++;
                }
            }
            System.out.println("There are " + count + " long haul flights");
        } else {
            System.out.println("Nothing to show. Add a flight to the system.");
        }


    }

    private boolean checkCollection(){
        return flightMap.size() > 0;
    }


}

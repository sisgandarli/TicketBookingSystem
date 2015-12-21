package factories;

import tickets.Ticket;
import tickets.events.entities.CinemaTicket;
import tickets.events.entities.ConcertTicket;
import tickets.events.entities.GameTicket;
import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.transportation.entities.BusTicket;
import tickets.transportation.entities.PlaneTicket;
import tickets.transportation.entities.ShipTicket;
import tickets.transportation.entities.TrainTicket;

/***********************************************************************************************************************
 * TicketOffice class. It is generalized factory. They are need for instantiation of the objects.
 * This factory creates only transportation tickets.
 **********************************************************************************************************************/

public class TicketOffice {
    // Factory method.
    public Ticket orderTicket(String ticketName) {
        Ticket ticket = null;
        if (ticketName.equals("Cinema Ticket")) {
            ticket = new CinemaTicket();
        } else if (ticketName.equals("Concert Ticket")) {
            ticket = new ConcertTicket();
        } else if (ticketName.equals("Game Ticket")) {
            ticket = new GameTicket();
        } else if (ticketName.equals("Bus Ticket")) {
            ticket = new BusTicket();
        } else if (ticketName.equals("Train Ticket")) {
            ticket = new TrainTicket();
        } else if (ticketName.equals("Ship Ticket")) {
            ticket = new ShipTicket();
        } else if (ticketName.equals("Plane Ticket")) {
            ticket = new PlaneTicket();
        }
        return ticket;
    }

    // Factory method. It has not been supported yet.
    public Ticket orderTicket(String ticketName, String type, String age, String location, String time, String date) {
        throw new UnsupportedOperationException("Not Supported Yet");
    }

    // Factory method. It has not been supported yet.
    public Ticket orderTicket(String ticketName, String type, String age, String startPoint, String destination, String time, String date) {
        throw new UnsupportedOperationException("Not Supported Yet");
    }

    // Factory method. It has not been supported yet.
    public Ticket orderTicket(String ticketName, TicketType ticketType, AgeType ageType, String location, String startTime) {
        throw new UnsupportedOperationException("Not Supported Yet");
    }

    // Factory method. It has not been supported yet.
    public Ticket orderTicket(String ticketName, TicketType ticketType, AgeType ageType, String startPoint, String destination, String departureTime, String arrivalTime) {
        throw new UnsupportedOperationException("Not Supported Yet");
    }
}

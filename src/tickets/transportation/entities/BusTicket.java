package tickets.transportation.entities;

import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.transportation.TransportationTicket;

/***********************************************************************************************************************
 * BusTicket class.
 **********************************************************************************************************************/

public class BusTicket extends TransportationTicket {
    // Default constructor.
    public BusTicket() {
        this.price = 1;
        this.kidPrice = this.price / 2;
        this.description = "Bus Ticket";
    }

    // Overloaded constructor.
    public BusTicket(TicketType ticketType, AgeType ageType, String startPoint, String destination, String departureTime) {
        this.ticketType = ticketType;
        this.ageType = ageType;
        this.price = 1;
        this.description = "Bus Ticket";
        this.kidPrice = this.price / 2;
        this.startPoint = startPoint;
        this.destination = destination;
        this.departureTime = departureTime;
        this.setTicketPrice(ticketType, ageType);
    }
}

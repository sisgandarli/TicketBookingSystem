package tickets.transportation.entities;

import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.transportation.TransportationTicket;

/***********************************************************************************************************************
 * PlaneTicket class.
 **********************************************************************************************************************/

public class PlaneTicket extends TransportationTicket {
    // Default constructor.
    public PlaneTicket() {
        this.price = 150;
        this.kidPrice = this.price / 2;
        this.description = "Plane Ticket";
    }

    // Overloaded constructor.
    public PlaneTicket(TicketType ticketType, AgeType ageType, String startPoint, String destination, String departureTime) {
        this.ticketType = ticketType;
        this.ageType = ageType;
        this.price = 150;
        this.description = "Plane Ticket";
        this.kidPrice = this.price / 2;
        this.startPoint = startPoint;
        this.destination = destination;
        this.departureTime = departureTime;
        this.setTicketPrice(ticketType, ageType);
    }
}

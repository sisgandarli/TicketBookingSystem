package tickets.transportation.entities;

import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.transportation.TransportationTicket;

/***********************************************************************************************************************
 * ShipTicket class.
 **********************************************************************************************************************/

public class ShipTicket extends TransportationTicket {
    // Default constructor.
    public ShipTicket() {
        this.price = 40;
        this.kidPrice = this.price / 2;
        this.description = "Ship Ticket";
    }

    // Overloaded constructor.
    public ShipTicket(TicketType ticketType, AgeType ageType, String startPoint, String destination, String departureTime) {
        this.ticketType = ticketType;
        this.ageType = ageType;
        this.price = 40;
        this.description = "Ship Ticket";
        this.kidPrice = this.price / 2;
        this.startPoint = startPoint;
        this.destination = destination;
        this.departureTime = departureTime;
        this.setTicketPrice(ticketType, ageType);
    }
}

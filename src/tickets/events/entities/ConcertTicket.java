package tickets.events.entities;

import tickets.events.EventTicket;
import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;

/***********************************************************************************************************************
 * ConcertTicket class.
 **********************************************************************************************************************/

public class ConcertTicket extends EventTicket {
    // Default constructor.
    public ConcertTicket() {
        this.price = 50;
        this.kidPrice = this.price / 2;
        this.description = "Concert Ticket";
    }

    // Overloaded constructor.
    public ConcertTicket(TicketType ticketType, AgeType ageType, String location, String startTime) {
        this.ticketType = ticketType;
        this.ageType = ageType;
        this.price = 50;
        this.description = "Concert Ticket";
        this.kidPrice = this.price / 2;
        this.location = location;
        this.startTime = startTime;
        this.setTicketPrice(ticketType, ageType);
    }
}

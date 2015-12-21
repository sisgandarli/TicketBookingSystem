package tickets.events.entities;

import tickets.events.EventTicket;
import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;

/***********************************************************************************************************************
 * CinemaTicket class.
 **********************************************************************************************************************/

public class CinemaTicket extends EventTicket {
    // Default constructor.
    public CinemaTicket() {
        this.price = 5;
        this.kidPrice = this.price / 2;
        this.description = "Cinema Ticket";
    }

    // Overloaded constructor.
    public CinemaTicket(TicketType ticketType, AgeType ageType, String location, String startTime) {
        this.ticketType = ticketType;
        this.ageType = ageType;
        this.price = 5;
        this.description = "Cinema Ticket";
        this.kidPrice = this.price / 2;
        this.location = location;
        this.startTime = startTime;
        this.setTicketPrice(ticketType, ageType);
    }
}

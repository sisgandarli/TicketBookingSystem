package tickets.events.entities;

import tickets.events.EventTicket;
import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;

/***********************************************************************************************************************
 * GameTicket class.
 **********************************************************************************************************************/

public class GameTicket extends EventTicket {
    // Default constructor.
    public GameTicket() {
        this.price = 10;
        this.kidPrice = this.price / 2;
        this.description = "Game Ticket";
    }

    // Overloaded constructor.
    public GameTicket(TicketType ticketType, AgeType ageType, String location, String startTime) {
        this.ticketType = ticketType;
        this.ageType = ageType;
        this.price = 10;
        this.description = "Game Ticket";
        this.kidPrice = this.price / 2;
        this.location = location;
        this.startTime = startTime;
        this.setTicketPrice(ticketType, ageType);
    }
}

package tickets.transportation.entities;

import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.transportation.TransportationTicket;

/***********************************************************************************************************************
 * TrainTicket class.
 **********************************************************************************************************************/

public class TrainTicket extends TransportationTicket {
    // Default constructor.
    public TrainTicket() {
        this.price = 35;
        this.kidPrice = this.price / 2;
        this.description = "Train Ticket";
    }

    // Overloaded constructor.
    public TrainTicket(TicketType ticketType, AgeType ageType, String startPoint, String destination, String departureTime) {
        this.ticketType = ticketType;
        this.ageType = ageType;
        this.price = 35;
        this.description = "Train Ticket";
        this.kidPrice = this.price / 2;
        this.startPoint = startPoint;
        this.destination = destination;
        this.departureTime = departureTime;
        this.setTicketPrice(ticketType, ageType);
    }
}

package factories;

import tickets.Ticket;
import tickets.events.EventTicket;
import tickets.events.entities.CinemaTicket;
import tickets.events.entities.ConcertTicket;
import tickets.events.entities.GameTicket;
import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.interfaceses.agetypes.Adult;
import tickets.interfaceses.agetypes.Kid;
import tickets.interfaceses.tickettypes.Business;
import tickets.interfaceses.tickettypes.Standard;
import tickets.interfaceses.tickettypes.VIP;

/***********************************************************************************************************************
 * EventTicketFactory class. It is a one the factories. They are need for instantiation of the objects.
 * This factory creates only event tickets.
 **********************************************************************************************************************/

public class EventTicketFactory extends TicketOffice {
    // Factory method.
    @Override
    public Ticket orderTicket(String ticketName, TicketType ticketType, AgeType ageType, String location, String startTime) {
        EventTicket ticket = null;
        if (ticketName.equals("Cinema Ticket")) {
            ticket = new CinemaTicket(ticketType, ageType, location, startTime);
        } else if (ticketName.equals("Concert Ticket")) {
            ticket = new ConcertTicket(ticketType, ageType, location, startTime);
        } else if (ticketName.equals("Game Ticket")) {
            ticket = new GameTicket(ticketType, ageType, location, startTime);
        }
        return ticket;
    }

    // Factory method.
    @Override
    public Ticket orderTicket(String ticketName, String type, String age, String location, String time, String date) {
        EventTicket ticket = null;
        if (ticketName.equals("Cinema Ticket")) {
            ticket = new CinemaTicket();
        } else if (ticketName.equals("Concert Ticket")) {
            ticket = new ConcertTicket();
        } else if (ticketName.equals("Game Ticket")) {
            ticket = new GameTicket();
        }
        if (type.equals("Business")) {
            ticket.setTicketType(new Business());
        } else if (type.equals("Standard")) {
            ticket.setTicketType(new Standard());
        } else if (type.equals("VIP")) {
            ticket.setTicketType(new VIP());
        }
        if (age.equals("For Kids")) {
            ticket.setAgeType(new Kid());
        } else if (age.equals("For Adults")) {
            ticket.setAgeType(new Adult());
        }
        ticket.setLocation(location);
        ticket.setStartTime(time);
        ticket.setDate(date);
        ticket.setTicketPrice(ticket.getTicketType(), ticket.getAgeType());
        return ticket;
    }

    // Factory method.
    @Override
    public Ticket orderTicket(String ticketName, TicketType ticketType, AgeType ageType, String startPoint, String destination, String departureTime, String arrivalTime) {
        return null;
    }
}

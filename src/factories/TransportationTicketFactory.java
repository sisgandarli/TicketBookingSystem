package factories;

import tickets.Ticket;
import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.interfaceses.agetypes.Adult;
import tickets.interfaceses.agetypes.Kid;
import tickets.interfaceses.tickettypes.Business;
import tickets.interfaceses.tickettypes.Standard;
import tickets.interfaceses.tickettypes.VIP;
import tickets.transportation.TransportationTicket;
import tickets.transportation.entities.BusTicket;
import tickets.transportation.entities.PlaneTicket;
import tickets.transportation.entities.ShipTicket;
import tickets.transportation.entities.TrainTicket;

/***********************************************************************************************************************
 * TransportationTicketFactory class. It is a one the factories. They are need for instantiation of the objects.
 * This factory creates only transportation tickets.
 **********************************************************************************************************************/

public class TransportationTicketFactory extends TicketOffice {
    // Factory method.
    @Override
    public Ticket orderTicket(String ticketName, TicketType ticketType, AgeType ageType, String location, String startTime) {
        return null;
    }

    // Factory method.
    @Override
    public Ticket orderTicket(String ticketName, String type, String age, String startPoint, String destination, String time, String date) {
        TransportationTicket ticket = null;
        if (ticketName.equals("Bus Ticket")) {
            ticket = new BusTicket();
        } else if (ticketName.equals("Plane Ticket")) {
            ticket = new PlaneTicket();
        } else if (ticketName.equals("Ship Ticket")) {
            ticket = new ShipTicket();
        } else if (ticketName.equals("Train Ticket")) {
            ticket = new TrainTicket();
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
        ticket.setStartPoint(startPoint);
        ticket.setDestination(destination);
        ticket.setDepartureTime(time);
        ticket.setDate(date);
        ticket.setTicketPrice(ticket.getTicketType(), ticket.getAgeType());
        return ticket;
    }

    // Factory method.
    @Override
    public Ticket orderTicket(String ticketName, TicketType ticketType, AgeType ageType, String startPoint, String destination, String departureTime, String arrivalTime) {
        TransportationTicket ticket = null;
        if (ticketName.equals("Bus Ticket")) {
            ticket = new BusTicket(ticketType, ageType, startPoint, destination, departureTime);
        } else if (ticket.equals("Plane Ticket")) {
            ticket = new PlaneTicket(ticketType, ageType, startPoint, destination, departureTime);
        } else if (ticket.equals("Ship Ticket")) {
            ticket = new ShipTicket(ticketType, ageType, startPoint, destination, departureTime);
        } else if (ticket.equals("Train Ticket")) {
            ticket = new TrainTicket(ticketType, ageType, startPoint, destination, departureTime);
        }
        return ticket;
    }
}

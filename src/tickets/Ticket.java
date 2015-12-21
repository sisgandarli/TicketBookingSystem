package tickets;

import tickets.interfaceses.AgeType;
import tickets.interfaceses.TicketType;
import tickets.interfaceses.agetypes.Kid;
import tickets.interfaceses.tickettypes.Business;
import tickets.interfaceses.tickettypes.VIP;

import java.io.Serializable;

/***********************************************************************************************************************
 * Ticket class. Abstract class of all tickets.
 **********************************************************************************************************************/

public abstract class Ticket implements Serializable {
    // Properties of Ticket class. They are only related to this class and those which are subclassing Ticket class.
    public TicketType ticketType;
    public AgeType ageType;
    public double price;
    public double kidPrice;
    public String description;
    public int numberOfTickets = 50;
    public String date;

    // This method set the price of the ticket depending on the type of ticket and the age of person.
    public final void setTicketPrice(TicketType ticketType, AgeType ageType) {
        if (ageType instanceof Kid) {
            this.price /= 2;
        }
        if (ticketType instanceof Business) {
            this.price *= 1.5;
        } else if (ticketType instanceof VIP) {
            this.price *= 2;
        }
    }

    // Many getters and setters.
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public AgeType getAgeType() {
        return ageType;
    }

    public void setAgeType(AgeType ageType) {
        this.ageType = ageType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getKidPrice() {
        return kidPrice;
    }

    public void setKidPrice(double kidPrice) {
        this.kidPrice = kidPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    // toString() method.
    @Override
    public String toString() {
        return description + " " + ticketType.toString() + " " + ageType.toString() + " " + price;
    }
}

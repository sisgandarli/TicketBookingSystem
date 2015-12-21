package tickets.events;

import tickets.Ticket;

/***********************************************************************************************************************
 * EventTicket class. Abstract class of all event tickets.
 **********************************************************************************************************************/

public abstract class EventTicket extends Ticket {
    // Some additional properties. They are only related to this class and those which are subclassing EventTicket class.
    public String location;
    public String startTime;

    // Some getters and setters.
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    // toString() method
    public String toString() {
        return String.format("Ticket description: %s\nTicket Type: %s\nAge Group: %s\nLocation: %s\nTime: %s\nDate: %s\nPrice: %.2f AZN\nQuantity Bought: %d\nMoney Paid: %.2f AZN\n",
                this.getDescription(),
                this.getTicketType().toString(),
                this.getAgeType().toString(),
                this.getLocation(),
                this.getStartTime(),
                this.getDate(),
                this.getPrice(),
                this.getNumberOfTickets(),
                this.getPrice() * this.getNumberOfTickets()
        );
    }
}

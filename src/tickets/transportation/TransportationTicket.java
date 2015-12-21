package tickets.transportation;

import tickets.Ticket;

/***********************************************************************************************************************
 * TransportationTicket class. Abstract class of all transportation tickets.
 **********************************************************************************************************************/

public abstract class TransportationTicket extends Ticket {
    // Some additional properties. They are only related to this class and those which are subclassing TransportationTicket class.
    public String startPoint;
    public String destination;
    public String departureTime;

    // Some getters and setters.
    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    // toString() method
    public String toString() {
        return String.format("Ticket description: %s\nTicket Type: %s\nAge Group: %s\nStart Point: %s\nDestination: %s\nTime: %s\nDate: %s\nPrice: %.2f AZN\nQuantity Bought: %d\nMoney Paid: %.2f AZN\n",
                this.getDescription(),
                this.getTicketType().toString(),
                this.getAgeType().toString(),
                this.getStartPoint(),
                this.getDestination(),
                this.getDepartureTime(),
                this.getDate(),
                this.getPrice(),
                this.getNumberOfTickets(),
                this.getPrice() * this.getNumberOfTickets()
        );
    }
}

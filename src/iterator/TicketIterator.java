package iterator;

import tickets.Ticket;

import java.util.Iterator;

/***********************************************************************************************************************
 * This is array iterator of Ticket items. Actually, I did not need to use this class.
 **********************************************************************************************************************/

public class TicketIterator implements Iterator<Ticket> {
    private Ticket[] tickets;
    int pos = 0;

    public TicketIterator(Ticket[] tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean hasNext() {
        if (pos >= tickets.length || tickets[pos] == null) return false;
        return true;
    }

    @Override
    public Ticket next() {
        Ticket ticket = tickets[pos];
        pos++;
        return ticket;
    }
}

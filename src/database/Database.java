package database;

import factories.TicketOffice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tickets.Ticket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

/***********************************************************************************************************************
 * Database class. This is the database of tickets. This class enables us to write and read the number of available
 * tickets in the ticket office from database (obviously, it is file).
 **********************************************************************************************************************/

public class Database {
    // Reads from database.
    public static ObservableList<Ticket> readFromDatabase() throws FileNotFoundException {
        Scanner in = new Scanner(new File("db.txt"));
        ObservableList<Ticket> tickets = FXCollections.observableArrayList();
        TicketOffice office = new TicketOffice();
        while (in.hasNext()) {
            Ticket ticket = null;
            String fname = in.next();
            String sname = in.next();
            String name = fname + " " + sname;
            ticket = office.orderTicket(name);
            int q = in.nextInt();
            ticket.setNumberOfTickets(q);
            tickets.add(ticket);
        }
        if (tickets.size() == 0) {
            tickets.add(office.orderTicket("Cinema Ticket"));
            tickets.add(office.orderTicket("Concert Ticket"));
            tickets.add(office.orderTicket("Game Ticket"));
            tickets.add(office.orderTicket("Bus Ticket"));
            tickets.add(office.orderTicket("Plane Ticket"));
            tickets.add(office.orderTicket("Train Ticket"));
            tickets.add(office.orderTicket("Ship Ticket"));
        }
        in.close();
        return tickets;
    }

    // Writes to database.
    public static void writeToDatabase(ObservableList<Ticket> list) throws IOException {
        PrintWriter out = new PrintWriter(new File("db.txt"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Ticket t = (Ticket) it.next();
            out.print(t.getDescription());
            out.print(" ");
            out.print(t.getNumberOfTickets());
            out.println();
        }
        out.flush();
        out.close();
    }
}

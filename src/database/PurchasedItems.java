package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tickets.Ticket;

import java.io.*;

/***********************************************************************************************************************
 * PurchasedItems class. This class logs the purchases into separate database (obviously, it is file).
 **********************************************************************************************************************/

public class PurchasedItems {
    // The static container of purchased tickets.
    public static ObservableList<Ticket> purchasedTickets = FXCollections.observableArrayList();

    // Adding to the list of purchases.
    public static void add(Ticket ticket) {
        purchasedTickets.add(ticket);
    }

    // Serializing the purchases.
    public static void write() throws IOException {
        FileOutputStream fos = new FileOutputStream("items.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Ticket t : purchasedTickets) {
            oos.writeObject(t);
        }
        oos.flush();
        oos.close();
    }

    // Reading the serialized the purchases.
    public static void read() throws IOException, EOFException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("items.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (true) {
            try {
                Ticket t = (Ticket) ois.readObject();
                purchasedTickets.add(t);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        ois.close();
    }
}

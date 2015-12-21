package gui;

import database.Database;
import database.PurchasedItems;
import factories.EventTicketFactory;
import factories.TicketOffice;
import factories.TransportationTicketFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import tickets.Ticket;
import tickets.events.EventTicket;
import tickets.transportation.TransportationTicket;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/***********************************************************************************************************************
 * Many UI stuff. They are needed for creating the UI of application.
 **********************************************************************************************************************/

public class Main extends Application {
    // UI components.
    private final String pattern = "dd/MM/yyyy";
    private TableView table;
    private ListView detailedInfo;
    private ListView<Ticket> list;
    private DatePicker date;
    private ObservableList<Ticket> tickets;
    private ComboBox typeOfTicket;
    private ComboBox ageType;
    private ComboBox quantity;
    private ComboBox startTime;
    private ComboBox departureTime;
    private ComboBox location;
    private ComboBox startingPoint;
    private ComboBox destination;
    private HBox composition;
    private HBox layout;
    private VBox upperPart;
    private HBox lowerPart;
    private VBox labelPart;
    private VBox comboBoxPart;
    private VBox transportation;
    private VBox events;
    private VBox log;
    private VBox subLayout;
    private final Label noTicketsLeft = new Label("There is no ticket left");
    private final Label logLabel = new Label("The Log of Purchases");
    private final Label tableOfTickets = new Label("Table of Tickets");
    private final Label orderATicket = new Label("Order a ticket");
    private Label ticketTime;
    private Label ticketType;
    private Label ticketAge;
    private Label ticketQuantity;
    private Label ticketStartTime;
    private Label ticketDepartureTime;
    private Label ticketLocation;
    private Label ticketStartingPoint;
    private Label ticketDestination;
    private Label ticketDate;
    private Button buyButton;

    // Main method.
    public static void main(String[] args) {
        launch(args);
    }

    // Start method of JavaFX application.
    @Override
    public void start(Stage window) throws Exception {
        window.setTitle("Ticket Booking System");

        //Setting layouts.
        layout = new HBox();
        layout.setPadding(new Insets(5, 5, 5, 5));
        upperPart = new VBox();
        upperPart.setPadding(new Insets(5, 5, 5, 5));
        lowerPart = new HBox();
        lowerPart.setPadding(new Insets(5, 5, 5, 5));
        log = new VBox();
        log.getChildren().add(logLabel);
        labelPart = new VBox();
        labelPart.setPadding(new Insets(5, 5, 5, 5));
        comboBoxPart = new VBox();
        comboBoxPart.setPadding(new Insets(5, 5, 5, 5));
        transportation = new VBox();
        transportation.setPadding(new Insets(5, 5, 5, 5));
        events = new VBox();
        events.setPadding(new Insets(5, 5, 5, 5));
        composition = new HBox();
        composition.getChildren().addAll(labelPart, comboBoxPart);
        lowerPart.getChildren().addAll(composition);
        subLayout = new VBox();
        subLayout.getChildren().addAll(upperPart, lowerPart);
        //Adding everything to the main layout
        layout.getChildren().addAll(subLayout);

        //Creating log.
        PurchasedItems.read();
        list = new ListView<>();
        list.setItems(PurchasedItems.purchasedTickets);
        list.setMinHeight(500);
        list.setMinWidth(450);
        list.setMaxWidth(450);
        list.setPadding(new Insets(5, 5, 5, 5));
        log.getChildren().add(list);

        //Setting the content of the table.
        table = new TableView();
        TableColumn<Ticket, String> typeColumn = new TableColumn<>("Type of Ticket");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeColumn.setMinWidth(150);
        TableColumn<Ticket, Double> adultPriceColumn = new TableColumn<>("Price for Adults");
        adultPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        adultPriceColumn.setMinWidth(150);
        TableColumn<Ticket, Double> kidPriceColumn = new TableColumn<>("Price for Kids");
        kidPriceColumn.setCellValueFactory(new PropertyValueFactory<>("kidPrice"));
        kidPriceColumn.setMinWidth(150);
        TableColumn<Ticket, Integer> numberOfTicketsColumn = new TableColumn<>("Quantity");
        numberOfTicketsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfTickets"));
        numberOfTicketsColumn.setMinWidth(100);
        table.getColumns().addAll(typeColumn, adultPriceColumn, kidPriceColumn, numberOfTicketsColumn);
        tickets = getTickets();
        table.setItems(tickets);
        table.setMaxHeight(220);
        table.setMaxWidth(552);
        table.setMinHeight(220);
        table.setMinWidth(552);

        //Adding mouse clicked event to the table of tickets.
        table.setOnMouseClicked(e -> {
            typeOfTicket.setValue(typeOfTicket.getPromptText());
            ageType.setValue(ageType.getPromptText());
            quantity.setValue(quantity.getPromptText());
            startTime.setValue(startTime.getPromptText());
            departureTime.setValue(departureTime.getPromptText());
            location.setValue(location.getPromptText());
            startingPoint.setValue(startingPoint.getPromptText());
            destination.setValue(destination.getPromptText());
            labelPart.setSpacing(14);
            labelPart.setPadding(new Insets(10, 0, 0, 0));
            int index = table.getSelectionModel().getSelectedIndex();
            if (index == -1) return;
            if (tickets.get(index) instanceof TransportationTicket) {
                comboBoxPart.getChildren().clear();
                transportation.getChildren().clear();
                labelPart.getChildren().clear();
                composition.getChildren().clear();
                labelPart.getChildren().addAll(ticketType, ticketAge, ticketStartingPoint, ticketDestination, ticketDepartureTime, ticketDate, ticketQuantity);
                transportation.getChildren().addAll(typeOfTicket, ageType, startingPoint, destination, departureTime, date, quantity, buyButton);
                transportation.setSpacing(5);
                comboBoxPart.getChildren().addAll(transportation);
                composition.getChildren().addAll(labelPart, comboBoxPart);
            } else if (tickets.get(index) instanceof EventTicket) {
                comboBoxPart.getChildren().clear();
                events.getChildren().clear();
                labelPart.getChildren().clear();
                composition.getChildren().clear();
                labelPart.getChildren().addAll(ticketType, ticketAge, ticketLocation, ticketTime, ticketDate, ticketQuantity);
                events.getChildren().addAll(typeOfTicket, ageType, location, startTime, date, quantity, buyButton);
                events.setSpacing(5);
                comboBoxPart.getChildren().addAll(events);
                composition.getChildren().addAll(labelPart, comboBoxPart);
            }
        });

        //Adding table and listview (log).
        upperPart.getChildren().addAll(tableOfTickets, table);
        layout.getChildren().add(log);

        // Adding labels.
        ticketType = new Label("Ticket Type");
        ticketType.setMinWidth(100);
        ticketAge = new Label("Age Type");
        ticketAge.setMinWidth(100);
        ticketQuantity = new Label("Quantity");
        ticketQuantity.setMinWidth(100);
        ticketStartTime = new Label("Start Time");
        ticketStartTime.setMinWidth(100);
        ticketDepartureTime = new Label("Departure Time");
        ticketDepartureTime.setMinWidth(100);
        ticketLocation = new Label("Location");
        ticketLocation.setMinWidth(100);
        ticketStartingPoint = new Label("Strating Point");
        ticketStartingPoint.setMinWidth(100);
        ticketDestination = new Label("Destination");
        ticketDestination.setMinWidth(100);
        ticketDate = new Label("Date");
        ticketDate.setMinWidth(100);
        ticketTime = new Label("Start Time");
        ticketTime.setMinWidth(100);
        ticketQuantity = new Label("Quantity");
        ticketQuantity.setMinWidth(100);
        logLabel.setPadding(new Insets(5, 5, 5, 5));
        tableOfTickets.setPadding(new Insets(1, 5, 5, 5));
        orderATicket.setPadding(new Insets(5, 5, 0, 5));
        logLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        tableOfTickets.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        orderATicket.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

        // Adding ComboBox-es.
        typeOfTicket = new ComboBox();
        ObservableList<String> categories = FXCollections.observableArrayList();
        categories.add("Standard");
        categories.add("Business");
        categories.add("VIP");
        typeOfTicket.setItems(categories);
        typeOfTicket.setPromptText("Choose the Type");
        typeOfTicket.setMinWidth(250);
        ageType = new ComboBox();
        ObservableList<String> ageTypes = FXCollections.observableArrayList();
        ageTypes.add("For Adults");
        ageTypes.add("For Kids");
        ageType.setItems(ageTypes);
        ageType.setPromptText("Choose the Age Type");
        ageType.setMinWidth(250);
        quantity = new ComboBox();
        ObservableList<Integer> quantities = FXCollections.observableArrayList();
        for (int i = 0; i < 10; i++) quantities.add(i + 1);
        quantity.setItems(quantities);
        quantity.setPromptText("Choose the Quantity");
        quantity.setMinWidth(250);
        startTime = new ComboBox();
        departureTime = new ComboBox();
        startTime.setMinWidth(250);
        departureTime.setMinWidth(250);
        ObservableList<String> startTimes = FXCollections.observableArrayList();
        ObservableList<String> departureTimes = FXCollections.observableArrayList();
        for (int i = 0; i < 24; i++) {
            String t = String.format("%02d:%02d", i, 0);
            String k = String.format("%02d:%02d", i, 30);
            startTimes.addAll(t, k);
            departureTimes.addAll(t, k);
        }
        startTime.setItems(startTimes);
        startTime.setPromptText("Choose the Start Time");
        departureTime.setItems(departureTimes);
        departureTime.setPromptText("Choose the Departure Time");
        location = new ComboBox();
        startingPoint = new ComboBox();
        destination = new ComboBox();
        location.setMinWidth(250);
        startingPoint.setMinWidth(250);
        destination.setMinWidth(250);
        location.setPromptText("Choose the Location");
        startingPoint.setPromptText("Choose the Starting Point");
        destination.setPromptText("Choose the Destination");
        date = new DatePicker();
        date.setMinWidth(250);
        date.setPromptText("Choose the Date");
        date.setEditable(false);
        date.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) return dateFormatter.format(date);
                else return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) return LocalDate.parse(string, dateFormatter);
                else return null;
            }
        });
        ObservableList<String> locations = FXCollections.observableArrayList();
        ObservableList<String> startingPoints = FXCollections.observableArrayList();
        ObservableList<String> destinations = FXCollections.observableArrayList();
        locations.addAll("Baku", "Sumgait");
        startingPoints.addAll("Baku", "Sumgait", "Baladjary", "Khirdalan");
        destinations.addAll("Baku", "Sumgait", "Baladjary", "Khirdalan");
        location.setItems(locations);
        startingPoint.setItems(startingPoints);
        destination.setItems(destinations);

        //Setting button and eventhandler of the button.
        buyButton = new Button("Order Now!");
        buyButton.setOnAction(e -> {
            int index = table.getSelectionModel().getSelectedIndex();
            int q = quantity.getSelectionModel().getSelectedIndex();
            Ticket ticket = tickets.get(index);
            if (ticket.getNumberOfTickets() - (q + 1) >= 0) {
                ticket.numberOfTickets -= q + 1;
                if (ticket.numberOfTickets == 0) tickets.remove(ticket);
                else tickets.set(index, ticket);
                Ticket order = null;
                TicketOffice office = null;
                if (ticket instanceof TransportationTicket) {
                    office = new TransportationTicketFactory();
                    String name = ticket.getDescription();
                    String type = (String) typeOfTicket.getSelectionModel().getSelectedItem();
                    String age = (String) ageType.getSelectionModel().getSelectedItem();
                    String start = (String) startingPoint.getSelectionModel().getSelectedItem();
                    String dest = (String) destination.getSelectionModel().getSelectedItem();
                    String time = (String) departureTime.getSelectionModel().getSelectedItem();
                    String da = (date.getValue()).toString();
                    order = office.orderTicket(name, type, age, start, dest, time, da);
                } else if (ticket instanceof EventTicket) {
                    office = new EventTicketFactory();
                    String name = ticket.getDescription();
                    String type = (String) typeOfTicket.getSelectionModel().getSelectedItem();
                    String age = (String) ageType.getSelectionModel().getSelectedItem();
                    String loc = (String) location.getSelectionModel().getSelectedItem();
                    String time = (String) startTime.getSelectionModel().getSelectedItem();
                    String da = (date.getValue()).toString();
                    order = office.orderTicket(name, type, age, loc, time, da);
                }
                order.setNumberOfTickets(q + 1);
                PurchasedItems.add(order);
                comboBoxPart.getChildren().remove(noTicketsLeft);
            } else {
                comboBoxPart.getChildren().remove(noTicketsLeft);
                comboBoxPart.getChildren().addAll(noTicketsLeft);
            }
        });
        // Setting the scene in JavaFX.
        Scene scene = new Scene(layout, 1035, 550);
        setUserAgentStylesheet(STYLESHEET_MODENA);

        //Setting the window in JavaFX.
        window.setScene(scene);
        window.getIcons().add(new Image("http://i.imgur.com/buZJv00.png"));
        window.show();
    }

    // Stop method of JavaFX application.
    @Override
    public void stop() throws Exception {
        Database.writeToDatabase(tickets);
        PurchasedItems.write();
    }

    //return the list of tickets in the database.
    public ObservableList<Ticket> getTickets() throws IOException, ClassNotFoundException {
        ObservableList<Ticket> list = Database.readFromDatabase();
        return list;
    }
}
package main.entities;

public class Customer {

    // customer's phone number
    private final String phoneNumber;

    // customer's name
    private final String name;

    // customer's service level (either regular or VIP, VIP takes priority over regular)
    // TODO perhaps make into an enum?
    private final Integer serviceLevel;

    // ID of ticket customer will be served by
    // perhaps use Linux epoch?
    private long ticketNumber;

    public Customer(String phoneNumber, String name, Integer serviceLevel) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.serviceLevel = serviceLevel;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    // should I just make this return a bool instead and rename to something like isVIP()?
    public Integer getServiceLevel() {
        return this.serviceLevel;
    }

    public void setTicketNumber() {
        this.ticketNumber = System.nanoTime();
    }

    public long getTicketNumber() {
        return this.ticketNumber;
    }
}
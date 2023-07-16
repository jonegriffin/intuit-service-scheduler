package main.entities;

import main.enums.ServiceLevelEnum;

public class Customer {

    // customer's phone number
    private final String phoneNumber;

    // customer's name
    private final String name;

    // customer's service level (either regular or VIP, VIP takes priority over regular)
    private final ServiceLevelEnum serviceLevel;

    // ID of ticket customer will be served by
    // perhaps use Linux epoch?
    private long ticketNumber;

    public Customer(String phoneNumber, String name, ServiceLevelEnum serviceLevel) {
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

    public Integer getServiceLevel() {
        return this.serviceLevel.serviceLevel;
    }

    // assign ticket number from system clock
    // will be valid for ~300 years
    public void setTicketNumber() {
        this.ticketNumber = System.nanoTime();
    }

    public long getTicketNumber() {
        return this.ticketNumber;
    }
}
package trspo.factoryproject.entities.dto;

import trspo.factoryproject.entities.model.Status;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.UUID;

public class createOrderDTO {
    private String type;
    private double amount;
    private int price;
    private String provider;
    @Id
    private UUID id;
    private Calendar date;
    private Status status;

    public createOrderDTO(String type, double amount, int price, String provider) {
        this.type = type;
        this.amount = amount;
        this.price = price;
        this.provider = provider;
        this.date = Calendar.getInstance();
        this.status = Status.ORDERED;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

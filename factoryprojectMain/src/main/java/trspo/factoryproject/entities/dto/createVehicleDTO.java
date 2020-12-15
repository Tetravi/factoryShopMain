package trspo.factoryproject.entities.dto;

import trspo.factoryproject.entities.model.Status;
import trspo.factoryproject.entities.model.Worker;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class createVehicleDTO {
    private UUID driver;
    private String number;
    private double maxWeight;
    @Id
    @GeneratedValue
    private UUID id;
    private Status status;

    public createVehicleDTO(UUID driver, String number, double maxWeight) {
        this.driver = driver;
        this.number = number;
        this.maxWeight = maxWeight;
        this.status = Status.FREE;
    }

    public UUID getDriver() {
        return driver;
    }

    public void setDriver(UUID driver) {
        this.driver = driver;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}


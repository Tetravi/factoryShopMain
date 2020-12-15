package trspo.factoryproject.entities.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vehicle_list")
final public class Vehicle {
    @Id
    @GeneratedValue
    private UUID id;
    //@OneToOne
    //@JoinColumn(name = "id")
    private UUID driver;
    @Column
    private String number;
    @Column
    private double maxWeight;
    // @OneToOne
    // @JoinColumn(name = "order_id")
    private UUID my_order;
    // @OneToOne
    //@JoinColumn(name = "weight_id")
    private UUID weight;
    @Column
    private Status status;

    public Vehicle(UUID driver, String number, double maxWeight) {
        id = UUID.randomUUID();
        this.driver = driver;
        this.number = number;
        this.maxWeight = maxWeight;
        this.status = Status.FREE;
    }

    public Vehicle() {
    }

    public void setStatusBusy() { this.status = Status.BUSY; }

    public void setStatusFree(){
        this.status = Status.FREE;
    }

    public void setOrder(UUID order ){
        this.my_order = order;
    }

    public void setWeight(UUID weight ){
        this.weight = weight;
    }

    public void setId(){this.id = UUID.randomUUID();}

    public UUID getOrder(){
        return my_order;
    }

    public UUID getWeight(){
        return weight;
    }

    public UUID getDriver() { return driver; }

    public String getNumber() { return number; }

    public double getMaxWeight() { return maxWeight; }

    public Status getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "Номер транспорта: " + number + '\''
                + "Максимальная грузоподъемность: " + maxWeight + '\''
                + "Водитель: " + driver;
    }

    public UUID getId() {
        return id;
    }
}
package trspo.factoryproject.entities.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "my_order")
final public class Order {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String type;
    @Column
    private double amount;
    @Column
    private int price;
    @Column
    private String provider;
    @Column
    private Calendar date;
    @Column
    private Status status;

    public Order(){

    }

    public Order(String type, double amount, int price, String provider) {
        id = UUID.randomUUID();
        this.type = type;
        this.amount = amount;
        this.price = price;
        this.provider = provider;
        this.date = Calendar.getInstance();
        this.status = Status.ORDERED;
    }

    public Status getStatus(){
        return status;
    }

    public String getType() { return type; }

    public double getAmount() { return amount; }

    public int getPrice() { return price; }

    public String getProvider() { return provider; }

    public void setId(){this.id = UUID.randomUUID();}

    @Override
    public String toString(){
        return "{Заказ материалов типа " + type + " в количестве " + amount
                + " Поставщик: " + provider
                + " Дата заказа: " + date.getTime() + " Цена: " + price + "}";
    }

    public UUID getId() {
        return id;
    }
}

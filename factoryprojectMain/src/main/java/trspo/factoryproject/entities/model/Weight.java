package trspo.factoryproject.entities.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "weight")
final public class Weight {
    @Id
    @GeneratedValue
    private UUID id;
    // @OneToOne
    //@JoinColumn(name = "worker_id")
    private UUID worker;
    @Column
    private Status status;

    public Weight(UUID worker) {
        id = UUID.randomUUID();
        this.worker = worker;
        this.status = Status.DELIVERING;
    }

    public Weight() { }

    public Status getStatus(){
        return status;
    }

    public UUID getWorker() { return worker; }

    public void setStatusReceived(){
        this.status = Status.RECEIVED;
    }

    public void setId(){this.id = UUID.randomUUID();}

    @Override
    public String toString(){
        return worker + "принимает заказ";
    }

    public UUID getId() {
        return id;
    }
}

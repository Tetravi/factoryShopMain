package trspo.factoryproject.entities.dto;

import trspo.factoryproject.entities.model.Status;
import trspo.factoryproject.entities.model.Worker;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class createWeightDTO {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID worker;
    private Status status;

    public createWeightDTO(UUID worker) {
        this.worker = worker;
        this.status = Status.DELIVERING;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getWorker() {
        return worker;
    }

    public void setWorker(UUID worker) {
        this.worker = worker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}


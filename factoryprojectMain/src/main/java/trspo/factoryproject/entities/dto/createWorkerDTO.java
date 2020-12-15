package trspo.factoryproject.entities.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class createWorkerDTO {
    private String name;
    private String job;
    private int salary;
    @Id
    @GeneratedValue
    private UUID id;

    public createWorkerDTO(String name, String job, int salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

package trspo.factoryproject.entities.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "worker")
final public class Worker {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String name;
    @Column
    private String job;
    @Column
    private int salary;

    public Worker() {
    }

    public Worker(String name, String job, int salary) {
        id = UUID.randomUUID();
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public void giveSalary(double _salary){
        salary += _salary;
    }

    public int getSalary() { return salary; }

    public String getJob() { return job; }

    public String getName() { return name; }

    public void setId(){this.id = UUID.randomUUID();}

    @Override
    public String toString(){
        return job +"  " + name;
    }

    public UUID getId() {
        return id;
    }
}

package trspo.factoryproject.entities.dto;

import trspo.factoryproject.entities.model.Vehicle;

public class unpackDTO {
    private Vehicle vehicle;

    public unpackDTO(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

package trspo.factoryproject.entities.dto;

import trspo.factoryproject.entities.model.Order;
import trspo.factoryproject.entities.model.Vehicle;

public class setVehicleDTO {
    private Vehicle vehicle;
    private Order order;

    public setVehicleDTO(Vehicle vehicle, Order order) {
        this.vehicle = vehicle;
        this.order = order;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

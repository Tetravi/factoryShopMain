package trspo.factoryproject.entities.dto;


import trspo.factoryproject.entities.model.Order;
import trspo.factoryproject.entities.model.Weight;

public class setWeightDTO {
    private Weight weight;
    private Order order;

    public setWeightDTO(Weight weight, Order order) {
        this.weight = weight;
        this.order = order;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}


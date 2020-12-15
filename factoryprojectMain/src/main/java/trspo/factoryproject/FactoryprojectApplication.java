package trspo.factoryproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import trspo.factoryproject.entities.dto.*;
import trspo.factoryproject.entities.model.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FactoryprojectApplication {

    private static final String URL = "http://localhost:8081";
    private static final HttpHeaders headers = new HttpHeaders();
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);

    public static void main(String[] args) {

        headers.setContentType(MediaType.APPLICATION_JSON);

        Worker driver = new Worker("Иван Иванов", " водитель",0);
        Worker worker = new Worker(" Василий", " работник", 0);

        addEntity("/firm", driver);
        addEntity("/firm", worker);
        //saveWorker(driver);
        //saveWorker(worker);

        Order order1 = new Order("Ткань", 15.0, 100 ,"ClothFactory");

        addEntity("/my_order", order1);
        //saveOrder(order1);

        Weight weight1 = new Weight(worker.getId());
        addEntity("/weight", weight1);
        //saveWeight(weight1);

        Vehicle truck = new Vehicle(driver.getId(), "01234", 1000.0);
        addEntity("/delivery", truck);

        //saveVehicle(truck);

        setVehicle(truck, order1);

        setWeight(weight1, order1);

        //unpack(truck);

        //cash(truck);
    }

    private static void addEntity(String path, Object entity) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String entityJson = objectMapper.writeValueAsString(entity);
            HttpEntity<String> entityJsonHttp = new HttpEntity<>(entityJson, headers);
            ResponseEntity<Void> response = restTemplate.postForEntity(URL +
                    path, entityJsonHttp, Void.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void saveWorker(Worker worker){
        createWorkerDTO workerDto = new createWorkerDTO(worker.getName(), worker.getJob(), worker.getSalary());
        HttpEntity<createWorkerDTO> saveWorker = new HttpEntity<>(workerDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/firm/crWorker",
                HttpMethod.POST, saveWorker, Void.class);
    }

    public static void saveVehicle(Vehicle vehicle){
        createVehicleDTO vehicleDto = new createVehicleDTO(vehicle.getDriver(), vehicle.getNumber(),
        vehicle.getMaxWeight());
        HttpEntity<createVehicleDTO> saveVehicle = new HttpEntity<>(vehicleDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/delivery/crVehicle",
                HttpMethod.POST, saveVehicle, Void.class);
    }

    public static void saveOrder(Order order){
        createOrderDTO orderDto = new createOrderDTO(order.getType(), order.getAmount(),
                order.getPrice(), order.getProvider());
        HttpEntity<createOrderDTO> saveOrder = new HttpEntity<>(orderDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/my_order/crOrder",
                HttpMethod.POST, saveOrder, Void.class);
    }

    public static void saveWeight(Weight weight){
        createWeightDTO weightDto = new createWeightDTO(weight.getWorker());
        HttpEntity<createWeightDTO> saveWeight = new HttpEntity<>(weightDto);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/weight/crWeight",
                HttpMethod.POST, saveWeight, Void.class);
    }

    public static void setVehicle(Vehicle vehicle, Order order){
        /*createOrderDTO orderDto = new createOrderDTO(order.getType(), order.getAmount(),
                order.getPrice(), order.getProvider());
        orderDto.setId(order.getId());*/
        setVehicleDTO setVehicleDTO = new setVehicleDTO(vehicle, order);

        HttpEntity<setVehicleDTO> setDtoHttpEntity = new HttpEntity<>(setVehicleDTO,headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/delivery/setVehicle",
                HttpMethod.POST, setDtoHttpEntity, Void.class);
    }

    public static void setWeight(Weight weight, Order order){
        setWeightDTO setWeightDto = new setWeightDTO(weight, order);

        HttpEntity<setWeightDTO> setWeightDTOHttpEntity = new HttpEntity<>(setWeightDto, headers);
        ResponseEntity<Void> response1 = restTemplate.exchange(URL + "/delivery/setWeight",
                HttpMethod.POST, setWeightDTOHttpEntity, Void.class);
    }

    public static void unpack(Vehicle vehicle){
        /*createVehicleDTO vehicleDto = new createVehicleDTO(vehicle.getDriver(), vehicle.getNumber(),
                vehicle.getMaxWeight());
        vehicleDto.setId(vehicle.getId());*/
        unpackDTO unpackDto = new unpackDTO(vehicle);
        HttpEntity<unpackDTO> unpackHttpEntity = new HttpEntity<>(unpackDto,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/weight/unpack",
                HttpMethod.POST, unpackHttpEntity, Void.class);
    }

    public static void cash(Vehicle vehicle){
        createVehicleDTO vehicleDto = new createVehicleDTO(vehicle.getDriver(), vehicle.getNumber(),
                vehicle.getMaxWeight());
        vehicleDto.setId(vehicle.getId());
        HttpEntity<createVehicleDTO> cashHttpEntity = new HttpEntity<>(vehicleDto,headers);
        ResponseEntity<Void> response0 = restTemplate.exchange(URL + "/firm/giveCash",
                HttpMethod.POST, cashHttpEntity, Void.class);
    }
}

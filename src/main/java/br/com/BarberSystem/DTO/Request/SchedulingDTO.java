package br.com.BarberSystem.DTO.Request;

import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Domain.Entity.Employee;
import br.com.BarberSystem.Domain.Entity.Service;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class SchedulingDTO {


    private long id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private Client client;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private Employee employee;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private Service service;

    private LocalDateTime localDateTime;

    private Double price;

    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String Status;

    /*
                        GETTER'S AND SETTER'S
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

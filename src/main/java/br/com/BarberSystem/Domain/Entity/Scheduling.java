package br.com.BarberSystem.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
                        ATTRIBUTES
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Client client;

    @OneToOne
    private Employee employee;

    @OneToOne
    private Service service;

    private LocalDateTime data;

    private LocalTime timesStart;

    private LocalTime timesEnd;

    private Double price;

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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public LocalTime getTimeStart() {
        return timesStart;
    }

    public void setTimeStart(LocalTime timesStart) {
        this.timesStart = timesStart;
    }

    public LocalTime getTimesEnd() {
        return timesEnd;
    }

    public void setTimesEnd(LocalTime timesEnd) {
        this.timesEnd = timesEnd;
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

    /*
                        METHODS
     */

}

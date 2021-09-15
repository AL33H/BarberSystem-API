package br.com.BarberSystem.Domain.Entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Builder
@NoArgsConstructor
public class Scheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
                        ATTRIBUTES
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne()
    private Client client;

    @OneToOne
    private Employee employee;

    @OneToOne
    private Service service;


    @Column(nullable = false)
    private LocalDateTime localDateTime;


    @Column(nullable = false)
    private Double price;


    @Column(nullable = false)
    @Size(max = 45)
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

     /*
                        METHODS
     */

    @Override
    public String toString() {
        return "Scheduling{" +
                "id=" + id +
                ", client=" + client +
                ", functionary=" + employee +
                ", service=" + service +
                ", localDateTime=" + localDateTime +
                ", price=" + price +
                ", Status='" + Status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheduling that = (Scheduling) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

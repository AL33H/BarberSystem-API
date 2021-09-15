package br.com.BarberSystem.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingDTO {


    private long id;

    @NotNull
    private long client_id;

    @NotNull
    private long employee_id;

    @NotNull
    private long service_id;

    @NotNull
    private LocalDate data;

    @NotNull
    private LocalTime timesStart;

    @NotNull
    private LocalTime timesEnd;

    @NotNull
    private Double price;

    @NotNull
    private String status;

    /*
                        GETTER'S AND SETTER'S
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(long employee_id) {
        this.employee_id = employee_id;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getTimesStart() {
        return timesStart;
    }

    public void setTimesStart(LocalTime timesStart) {
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package br.com.BarberSystem.DTO.Request;


import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
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

}

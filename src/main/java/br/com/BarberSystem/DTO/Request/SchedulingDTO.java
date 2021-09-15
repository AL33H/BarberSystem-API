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
}

package br.com.BarberSystem.Controller.DTO.Request;

import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Domain.Entity.Functionary;
import br.com.BarberSystem.Domain.Entity.Service;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class SchedulingDTO {


    private long id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private Client client;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private Functionary functionary;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private Service service;

    private LocalDateTime localDateTime;

    private Double price;

    @Size(min = 2, max = 45, message = "Tamanho entre 2 e 45 caracteres!")
    @NotEmpty(message = "Preenchimento obrigatório!")
    private String Status;
}

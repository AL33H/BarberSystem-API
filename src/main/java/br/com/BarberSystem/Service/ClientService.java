package br.com.BarberSystem.Service;

import br.com.BarberSystem.DTO.Request.ClientDTO;
import br.com.BarberSystem.Domain.Entity.Client;

import java.util.List;

public interface ClientService {

    Client verifyIfExist(Long id);

    Client save(ClientDTO clientDTO);

    Client findById(Long id);

    List<Client> listAll();

    void deleteById(Long id);

    Client update(ClientDTO clientDTO);
}

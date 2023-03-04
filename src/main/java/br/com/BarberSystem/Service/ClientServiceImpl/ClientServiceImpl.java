package br.com.BarberSystem.Service.ClientServiceImpl;


import br.com.BarberSystem.DTO.Request.ClientDTO;
import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Repository.ClientRepository;
import br.com.BarberSystem.Service.ClientService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.ClientMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    @Autowired
    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client verifyIfExist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: " + id));
    }

    @Override
    public Client save(ClientDTO clientDTO) {
        return repository.save(ClientMapper.INSTANCE.toClient(clientDTO));
    }

    @Override
    public Client findById(Long id) {
        return verifyIfExist(id);
    }

    @Override
    public List<Client> listAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    @Override
    public Client update(ClientDTO clientDTO) {
        verifyIfExist(clientDTO.getId());
        return repository.save(ClientMapper.INSTANCE.toClient(clientDTO));
    }
}

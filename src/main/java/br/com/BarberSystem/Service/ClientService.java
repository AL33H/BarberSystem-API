package br.com.BarberSystem.Service;


import br.com.BarberSystem.DTO.Request.ClientDTO;
import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Repository.ClientRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private ClientRepository repository;


    /*
                        METHODS
     */

    public Client verifyIfExist(Long id) {
        return  repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: "+id));
    }

    public Client save(ClientDTO clientDTO){
        return repository.save(ClientMapper.INSTANCE.toClient(clientDTO));
    }

    public Client findById(Long id) {
        return verifyIfExist(id);
    }

    public List<Client> listAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    public Client update(ClientDTO clientDTO){
        verifyIfExist(clientDTO.getId());
        return repository.save(ClientMapper.INSTANCE.toClient(clientDTO));
    }
}

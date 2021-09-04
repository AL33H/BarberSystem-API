package br.com.BarberSystem.Service;


import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Repository.ClientRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClientService {

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private ClientRepository clientRepository;


    /*
                        METHODS
     */

    public Client verifyIfExist(Long id) {
        return  clientRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado! ID: "+id));
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    public Client findById(Long id) {
        return verifyIfExist(id);
    }

    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    public void DeleteById(Long id) {
        verifyIfExist(id);
        clientRepository.deleteById(id);
    }

    public Client updateById(Client client){
        return clientRepository.saveAndFlush(client);
    }
}

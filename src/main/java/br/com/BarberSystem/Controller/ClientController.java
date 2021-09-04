package br.com.BarberSystem.Controller;




import br.com.BarberSystem.Controller.DTO.Request.ClientDTO;
import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Service.ClientService;

import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/clients")
public class ClientController extends RuntimeException{

    /*
                        CONSTRUCTOR
     */
    @Autowired
    private ClientService clientService;

    /*
                        METHODS
     */

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> SaveClient(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok().body(ClientMapper.INSTANCE.toClient(clientDTO));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Client>> findAllClient(){
        return ResponseEntity.ok().body(clientService.listAll());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Client> findbyIdClient(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> DeleteByIdClient(@PathVariable Long id) throws ObjectNotFoundException {
        clientService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Client> UpdateClient(@Valid @RequestBody ClientDTO clientDTO){
        return ResponseEntity.ok().body(clientService.updateById(ClientMapper.INSTANCE.toClient(clientDTO)));
    }
}

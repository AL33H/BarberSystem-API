package br.com.BarberSystem.Controller;


import br.com.BarberSystem.DTO.Request.ClientDTO;
import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/clients")
public class ClientController extends RuntimeException{

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private ClientService service;

    /*
                        ENDPOINTS HTTP
     */


    /*
                        GET
     */

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAllClient(){
        return ResponseEntity.ok().body(service.listAll());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Client> findbyId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    /*
                        POST
     */

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = service.save(clientDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    /*
                        PUT
     */

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Client> update(@Valid @RequestBody ClientDTO clientDTO){
        service.update(clientDTO);
        return ResponseEntity.noContent().build();
    }

    /*
                        DELETE
     */

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

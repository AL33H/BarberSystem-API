package br.com.BarberSystem.Controller;


import br.com.BarberSystem.DTO.Request.ServiceDTO;
import br.com.BarberSystem.Domain.Entity.Service;
import br.com.BarberSystem.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ServiceController {

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private ServiceService service;

    /*
                        ENDPOINTS HTTP
     */

     /*
                        GET
     */

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Service> findbyId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Service>> findAll(){
        return ResponseEntity.ok().body(service.listAll());
    }


     /*
                        POST
     */

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody ServiceDTO serviceDTO){
        Service service = this.service.save(serviceDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(serviceDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    /*
                        PUT
     */

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ServiceDTO serviceDTO){
        service.update(serviceDTO);
        return ResponseEntity.noContent().build();
    }

    /*
                        DELETE
     */

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

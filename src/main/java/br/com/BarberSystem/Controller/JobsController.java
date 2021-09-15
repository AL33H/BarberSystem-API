package br.com.BarberSystem.Controller;


import br.com.BarberSystem.DTO.Request.JobsDTO;
import br.com.BarberSystem.Domain.Entity.Jobs;
import br.com.BarberSystem.Service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class JobsController {

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private JobsService service;

    /*
                        ENDPOINTS HTTP
     */

     /*
                        GET
     */

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Jobs> findbyId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Jobs>> findAll(){
        return ResponseEntity.ok().body(service.listAll());
    }


     /*
                        POST
     */

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody JobsDTO jobsDTO){
        Jobs jobs = this.service.save(jobsDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(jobsDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    /*
                        PUT
     */

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody JobsDTO jobsDTO){
        service.update(jobsDTO);
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

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
@RequestMapping(value = "v1//jobs")
public class JobsController {

    private final JobsService service;

    @Autowired
    public JobsController(JobsService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Jobs> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Jobs>> findAll() {
        return ResponseEntity.ok().body(service.listAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody JobsDTO jobsDTO) {
        service.save(jobsDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(jobsDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody JobsDTO jobsDTO) {
        service.update(jobsDTO);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

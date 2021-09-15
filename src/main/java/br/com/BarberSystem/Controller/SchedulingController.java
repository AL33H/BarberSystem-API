package br.com.BarberSystem.Controller;

import br.com.BarberSystem.DTO.Request.SchedulingDTO;
import br.com.BarberSystem.Domain.Entity.Scheduling;
import br.com.BarberSystem.Service.SchedulingService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.SchedulingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingController {

    /*
                        CONSTRUCTOR
     */
    @Autowired
    private SchedulingService service;

    /*
                        ENDPOINTS HTTP
     */


    /*
                        GET
     */

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Scheduling>> findAll(){
        return ResponseEntity.ok().body(service.listAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Scheduling> findbyId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    /*
                        POST
     */

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody SchedulingDTO schedulingDTO) {
        Scheduling scheduling = service.save(SchedulingMapper.INSTANCE.toScheduling(schedulingDTO));

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(schedulingDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    /*
                        PUT
     */

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody SchedulingDTO schedulingDTO){
        service.update(schedulingDTO);
        return ResponseEntity.noContent().build();
    }

    /*
                        DELETE
     */

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.DeleteById(id);
        return ResponseEntity.noContent().build();
    }
}

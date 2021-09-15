package br.com.BarberSystem.Controller;

import br.com.BarberSystem.DTO.Request.SchedulingDTO;
import br.com.BarberSystem.Domain.Entity.Scheduling;

import br.com.BarberSystem.Service.SchedulingService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.SchedulingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/scheduling")
public class SchedulingController {

    /*
                        CONSTRUCTOR
     */
    @Autowired
    private SchedulingService schedulingService;

    /*
                        METHODS
     */

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Scheduling SaveScheduling(@Valid @RequestBody SchedulingDTO schedulingDTO) {
        return schedulingService.saveScheduling(SchedulingMapper.INSTANCE.toScheduling(schedulingDTO));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Scheduling>> findAllScheduling(){
        return ResponseEntity.ok().body(schedulingService.listAll());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Scheduling> findbyIdScheduling(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(schedulingService.findById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> DeleteByIdScheduling(@PathVariable Long id) throws ObjectNotFoundException {
        schedulingService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Scheduling> UpdateScheduling(@Valid @RequestBody SchedulingDTO schedulingDTO){
        return ResponseEntity.ok().body(schedulingService.updateById(SchedulingMapper.INSTANCE.toScheduling(schedulingDTO)));
    }
}

package br.com.BarberSystem.Controller;

import br.com.BarberSystem.DTO.Request.ServiceDTO;
import br.com.BarberSystem.Domain.Entity.Service;
import br.com.BarberSystem.Service.ServiceService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ServiceController {

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private ServiceService serviceService;

    /*
                        METHODS
     */

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Service SaveService(@Valid @RequestBody ServiceDTO serviceDTO){
        return serviceService.saveService(ServiceMapper.INSTANCE.toService(serviceDTO));
    }


    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Service>> findAllService(){
        return ResponseEntity.ok().body(serviceService.listAll());
    }



    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Service> findbyIdService(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(serviceService.findById(id));
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> DeleteByIdService(@PathVariable Long id) throws ObjectNotFoundException {
        serviceService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Service> UpdateService(@Valid @RequestBody ServiceDTO serviceDTO){
        return ResponseEntity.ok().body(serviceService.updateById(ServiceMapper.INSTANCE.toService(serviceDTO)));
    }


}

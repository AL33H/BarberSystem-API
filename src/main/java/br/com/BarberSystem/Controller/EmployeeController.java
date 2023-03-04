package br.com.BarberSystem.Controller;


import br.com.BarberSystem.DTO.Request.EmployeeDTO;
import br.com.BarberSystem.Domain.Entity.Employee;
import br.com.BarberSystem.Service.EmployeeService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "v1/employee")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok().body(service.listAll());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = service.save(employeeDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody EmployeeDTO employeeDTO) {
        service.update(employeeDTO);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws ObjectNotFoundException {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

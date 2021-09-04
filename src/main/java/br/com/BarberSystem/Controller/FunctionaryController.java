package br.com.BarberSystem.Controller;




import br.com.BarberSystem.Controller.DTO.Request.FunctionaryDTO;
import br.com.BarberSystem.Domain.Entity.Functionary;

import br.com.BarberSystem.Service.FunctionaryService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;

import br.com.BarberSystem.Util.Mapper.FunctionarieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/functionary")
public class FunctionaryController {

    @Autowired
    private FunctionaryService functionaryService;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Functionary SaveFunctionary(@Valid @RequestBody FunctionaryDTO functionaryDTO){
        return functionaryService.saveFunctionary(FunctionarieMapper.INSTANCE.toFunc(functionaryDTO));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Functionary>> findAllFunctionaries(){
        return ResponseEntity.ok().body(functionaryService.listAll());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Functionary> findbyIdFunctionary(@PathVariable Long id) throws ObjectNotFoundException {
        return ResponseEntity.ok().body(functionaryService.findById(id));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> DeleteByIdFunctionary(@PathVariable Long id) throws ObjectNotFoundException {
        functionaryService.DeleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Functionary> UpdateFunctionary(@Valid @RequestBody FunctionaryDTO functionaryDTO){
        return ResponseEntity.ok().body(functionaryService.updateById(FunctionarieMapper.INSTANCE.toFunc(functionaryDTO)));
    }
}

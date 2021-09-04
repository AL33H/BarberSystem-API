package br.com.BarberSystem.Service;


import br.com.BarberSystem.Domain.Entity.Functionary;
import br.com.BarberSystem.Repository.FunctionaryRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FunctionaryService {

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private FunctionaryRepository functionaryRepository;


    /*
                        METHODS
     */

    public Functionary verifyIfExist(Long id) {
        return functionaryRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Funcionario não encontrado! ID: " + id));
    }

    public Functionary saveFunctionary(Functionary functionary) {
        return functionaryRepository.save(functionary);
    }

    public Functionary findById(Long id) {
        return verifyIfExist(id);
    }

    public List<Functionary> listAll() {
        return functionaryRepository.findAll();
    }

    public void DeleteById(Long id) {
        verifyIfExist(id);
        functionaryRepository.deleteById(id);
    }

    public Functionary updateById(Functionary functionary) {
        return functionaryRepository.saveAndFlush(functionary);
    }

}

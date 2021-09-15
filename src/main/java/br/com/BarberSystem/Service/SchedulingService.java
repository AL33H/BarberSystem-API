package br.com.BarberSystem.Service;


import br.com.BarberSystem.DTO.Request.SchedulingDTO;
import br.com.BarberSystem.Domain.Entity.Scheduling;
import br.com.BarberSystem.Repository.SchedulingRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.SchedulingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SchedulingService {

    /*
                        CONSTRUCTOR
    */

    @Autowired
    private SchedulingRepository repository;


    /*
                        METHODS
     */

    public Scheduling verifyIfExist(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Agendamento não encontrado! ID: " + id));
    }

    public Scheduling save(Scheduling scheduling) {
        return repository.save(scheduling);
    }

    public Scheduling findById(Long id) {
        return verifyIfExist(id);
    }

    public List<Scheduling> listAll() {
        return repository.findAll();
    }

    public void DeleteById(Long id) {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    public Scheduling update(SchedulingDTO schedulingDTO) {
        return repository.save(SchedulingMapper.INSTANCE.toScheduling(schedulingDTO));
    }
}

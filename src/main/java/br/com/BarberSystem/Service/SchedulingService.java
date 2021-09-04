package br.com.BarberSystem.Service;


import br.com.BarberSystem.Domain.Entity.Scheduling;
import br.com.BarberSystem.Repository.SchedulingRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SchedulingService {

    /*
                        CONSTRUCTOR
    */

    @Autowired
    private SchedulingRepository schedulingRepository;


    /*
                        METHODS
     */



    public Scheduling verifyIfExist(Long id) throws ObjectNotFoundException {
        return schedulingRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Agendamento não encontrado! ID: " + id));
    }

    public Scheduling saveScheduling(Scheduling scheduling) {
        return schedulingRepository.save(scheduling);
    }

    public Scheduling findById(Long id) {
        return verifyIfExist(id);
    }

    public List<Scheduling> listAll() {
        return schedulingRepository.findAll();
    }

    public void DeleteById(Long id) {
        verifyIfExist(id);
        schedulingRepository.deleteById(id);
    }

    public Scheduling updateById(Scheduling scheduling) {
        return schedulingRepository.saveAndFlush(scheduling);
    }
}

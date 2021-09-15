package br.com.BarberSystem.Service;



import br.com.BarberSystem.DTO.Request.JobsDTO;
import br.com.BarberSystem.Domain.Entity.Jobs;
import br.com.BarberSystem.Repository.JobsRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.JobsMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@org.springframework.stereotype.Service
public class JobsService {
    
    /*
                        CONSTRUCTOR'S
     */
    
    @Autowired
    private JobsRepository repository;
    
    /*
                        METHODS
     */

    public Jobs verifyIfExist(Long id) {
        return  repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado! ID: "+id ));
    }

    public Jobs save(JobsDTO jobsDTO){
        return repository.save(JobsMapper.INSTANCE.toService(jobsDTO));
    }

    public Jobs findById(Long id){
        return verifyIfExist(id);
    }

    public List<Jobs> listAll() {
        return repository.findAll();
    }

    public void delete(Long id){
        verifyIfExist(id);
        repository.deleteById(id);
    }

    public Jobs update(JobsDTO jobsDTO){
        verifyIfExist(jobsDTO.getId());
        return repository.save(JobsMapper.INSTANCE.toService(jobsDTO));
    }
}

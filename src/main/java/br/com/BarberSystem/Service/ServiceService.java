package br.com.BarberSystem.Service;



import br.com.BarberSystem.DTO.Request.ServiceDTO;
import br.com.BarberSystem.Domain.Entity.Service;
import br.com.BarberSystem.Repository.ServiceRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@org.springframework.stereotype.Service
public class ServiceService {
    
    /*
                        CONSTRUCTOR'S
     */
    
    @Autowired
    private ServiceRepository repository;
    
    /*
                        METHODS
     */

    public Service verifyIfExist(Long id) {
        return  repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado! ID: "+id ));
    }

    public Service save(ServiceDTO serviceDTO){
        return repository.save(ServiceMapper.INSTANCE.toService(serviceDTO));
    }

    public Service findById(Long id){
        return verifyIfExist(id);
    }

    public List<Service> listAll() {
        return repository.findAll();
    }

    public void delete(Long id){
        verifyIfExist(id);
        repository.deleteById(id);
    }

    public Service update(ServiceDTO serviceDTO){
        verifyIfExist(serviceDTO.getId());
        return repository.save(ServiceMapper.INSTANCE.toService(serviceDTO));
    }
}

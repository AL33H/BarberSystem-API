package br.com.BarberSystem.Service;



import br.com.BarberSystem.Domain.Entity.Service;
import br.com.BarberSystem.Repository.ServiceRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@org.springframework.stereotype.Service
public class ServiceService {
    
    /*
                        CONSTRUCTOR'S
     */
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    /*
                        METHODS
     */

    public Service verifyIfExist(Long id) {
        return  serviceRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado! ID: "+id ));
    }

    public Service saveService(Service service){
        return serviceRepository.save(service);
    }

    public Service findById(Long id){
        return verifyIfExist(id);
    }

    public List<Service> listAll() {
        return serviceRepository.findAll();
    }

    public void DeleteById(Long id){
        verifyIfExist(id);
        serviceRepository.deleteById(id);
    }

    public Service updateById(Service service){
        return serviceRepository.saveAndFlush(service);
    }
}

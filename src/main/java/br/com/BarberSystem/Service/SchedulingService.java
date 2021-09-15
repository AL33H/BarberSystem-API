package br.com.BarberSystem.Service;


import br.com.BarberSystem.DTO.Request.SchedulingDTO;
import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Domain.Entity.Employee;
import br.com.BarberSystem.Domain.Entity.Jobs;
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

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobsService jobsService;


    /*
                        METHODS
     */

    public Scheduling verifyIfExist(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Agendamento não encontrado! ID: " + id));
    }

    public Scheduling save(SchedulingDTO schedulingDTO) {


        Client client = clientService.findById(schedulingDTO.getClient_id());
        Employee employee = employeeService.findById(schedulingDTO.getService_id());
        Jobs jobs = jobsService.findById(schedulingDTO.getService_id());


        Scheduling scheduling = new Scheduling();

        scheduling.setClient(client);
        scheduling.setEmployee(employee);
        scheduling.setJobs(jobs);
        scheduling.setData(schedulingDTO.getData());
        scheduling.setTimesStart(schedulingDTO.getTimesStart());
        scheduling.setTimesEnd(schedulingDTO.getTimesEnd());
        scheduling.setPrice(schedulingDTO.getPrice());
        scheduling.setStatus(schedulingDTO.getStatus());

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

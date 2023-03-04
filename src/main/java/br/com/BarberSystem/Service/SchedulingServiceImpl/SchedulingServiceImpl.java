package br.com.BarberSystem.Service.SchedulingServiceImpl;


import br.com.BarberSystem.DTO.Request.SchedulingDTO;
import br.com.BarberSystem.Domain.Entity.Client;
import br.com.BarberSystem.Domain.Entity.Employee;
import br.com.BarberSystem.Domain.Entity.Jobs;
import br.com.BarberSystem.Domain.Entity.Scheduling;
import br.com.BarberSystem.Repository.SchedulingRepository;
import br.com.BarberSystem.Service.ClientServiceImpl.ClientServiceImpl;
import br.com.BarberSystem.Service.EmployeeServiceImpl.EmployeeServiceImpl;
import br.com.BarberSystem.Service.JobsServiceImpl.JobsServiceImpl;
import br.com.BarberSystem.Service.SchedulingService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.SchedulingMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class SchedulingServiceImpl implements SchedulingService {

    private final SchedulingRepository repository;

    private final ClientServiceImpl clientService;

    private final EmployeeServiceImpl employeeService;

    private final JobsServiceImpl jobsService;

    @Autowired
    public SchedulingServiceImpl(SchedulingRepository repository,
                                 ClientServiceImpl clientService,
                                 EmployeeServiceImpl employeeService,
                                 JobsServiceImpl jobsService) {

        this.repository = repository;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.jobsService = jobsService;
    }

    @Override
    public Scheduling verifyIfExist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Agendamento não encontrado! ID: " + id));
    }

    @Override
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

    @Override
    public Scheduling findById(Long id) {
        return verifyIfExist(id);
    }

    @Override
    public List<Scheduling> listAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    @Override
    public Scheduling update(SchedulingDTO schedulingDTO) {
        return repository.save(SchedulingMapper.INSTANCE.toScheduling(schedulingDTO));
    }
}

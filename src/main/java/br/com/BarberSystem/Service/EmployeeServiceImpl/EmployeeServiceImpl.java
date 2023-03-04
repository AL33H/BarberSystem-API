package br.com.BarberSystem.Service.EmployeeServiceImpl;


import br.com.BarberSystem.DTO.Request.EmployeeDTO;
import br.com.BarberSystem.Domain.Entity.Employee;
import br.com.BarberSystem.Repository.EmployeeRepository;
import br.com.BarberSystem.Service.EmployeeService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.EmployeeMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee verifyIfExist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado! ID: " + id));
    }

    @Override
    public Employee save(EmployeeDTO employeeDTO) {
        return repository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDTO));
    }

    @Override
    public Employee findById(Long id) {
        return verifyIfExist(id);
    }

    @Override
    public List<Employee> listAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    @Override
    public Employee update(EmployeeDTO employeeDTO) {
        verifyIfExist(employeeDTO.getId());
        return repository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDTO));
    }

}

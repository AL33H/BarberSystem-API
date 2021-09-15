package br.com.BarberSystem.Service;


import br.com.BarberSystem.DTO.Request.EmployeeDTO;
import br.com.BarberSystem.Domain.Entity.Employee;
import br.com.BarberSystem.Repository.EmployeeRepository;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    /*
                        CONSTRUCTOR
     */

    @Autowired
    private EmployeeRepository repository;


    /*
                        METHODS
     */

    public Employee verifyIfExist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado! ID: " + id));
    }

    public Employee save(EmployeeDTO employeeDTO) {
        return repository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDTO));
    }

    public Employee findById(Long id) {
        return verifyIfExist(id);
    }

    public List<Employee> listAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    public Employee update(EmployeeDTO employeeDTO) {
        verifyIfExist(employeeDTO.getId());
        return repository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDTO));
    }

}

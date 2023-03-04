package br.com.BarberSystem.Service;

import br.com.BarberSystem.DTO.Request.ClientDTO;
import br.com.BarberSystem.DTO.Request.EmployeeDTO;
import br.com.BarberSystem.Domain.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee verifyIfExist(Long id);

    Employee save(EmployeeDTO clientDTO);

    Employee findById(Long id);

    List<Employee> listAll();

    void deleteById(Long id);

    Employee update(EmployeeDTO clientDTO);
}

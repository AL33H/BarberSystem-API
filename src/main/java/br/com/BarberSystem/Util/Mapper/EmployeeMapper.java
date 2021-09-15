package br.com.BarberSystem.Util.Mapper;

import br.com.BarberSystem.DTO.Request.EmployeeDTO;
import br.com.BarberSystem.Domain.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    public static final EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    public abstract Employee toEmployee(EmployeeDTO employeeDTO);

    public abstract EmployeeDTO toEmployeeDTO(Employee employee);

}

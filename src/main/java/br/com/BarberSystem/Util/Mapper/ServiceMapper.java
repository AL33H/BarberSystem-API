package br.com.BarberSystem.Util.Mapper;

import br.com.BarberSystem.Controller.DTO.Request.ServiceDTO;
import br.com.BarberSystem.Domain.Entity.Service;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ServiceMapper {

    public static final ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    public abstract Service toService(ServiceDTO serviceDTO);

    public abstract ServiceDTO serviceDTO(Service service);

}

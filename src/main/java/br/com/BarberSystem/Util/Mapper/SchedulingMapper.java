package br.com.BarberSystem.Util.Mapper;

import br.com.BarberSystem.DTO.Request.SchedulingDTO;
import br.com.BarberSystem.Domain.Entity.Scheduling;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class SchedulingMapper {

    public static SchedulingMapper INSTANCE = Mappers.getMapper(SchedulingMapper.class);

    public abstract Scheduling toScheduling(SchedulingDTO schedulingDTO);

    public abstract SchedulingDTO toSchedulingDTO(Scheduling scheduling);

}

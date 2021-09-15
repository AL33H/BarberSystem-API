package br.com.BarberSystem.Util.Mapper;

import br.com.BarberSystem.DTO.Request.JobsDTO;
import br.com.BarberSystem.Domain.Entity.Jobs;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class JobsMapper {

    public static final JobsMapper INSTANCE = Mappers.getMapper(JobsMapper.class);

    public abstract Jobs toService(JobsDTO jobsDTO);

    public abstract JobsDTO serviceDTO(Jobs jobs);

}

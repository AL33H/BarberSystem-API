package br.com.BarberSystem.Util.Mapper;

import br.com.BarberSystem.Controller.DTO.Request.FunctionaryDTO;
import br.com.BarberSystem.Domain.Entity.Functionary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FunctionarieMapper {

    public static final FunctionarieMapper INSTANCE = Mappers.getMapper(FunctionarieMapper.class);

    public abstract Functionary toFunc(FunctionaryDTO functionaryDTO);

    public abstract FunctionaryDTO toFuncDTO(Functionary functionary);

}

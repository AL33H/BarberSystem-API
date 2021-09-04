package br.com.BarberSystem.Util.Mapper;


import br.com.BarberSystem.Controller.DTO.Request.ClientDTO;
import br.com.BarberSystem.Domain.Entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ClientMapper {

    public static final ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);


    public abstract Client toClient(ClientDTO clientDTO);


    public abstract ClientDTO toClientDTO(Client client);


}

package br.com.BarberSystem.Service;

import br.com.BarberSystem.DTO.Request.ClientDTO;
import br.com.BarberSystem.DTO.Request.JobsDTO;
import br.com.BarberSystem.Domain.Entity.Jobs;

import java.util.List;

public interface JobsService {

    Jobs verifyIfExist(Long id);

    Jobs save(JobsDTO clientDTO);

    Jobs findById(Long id);

    List<Jobs> listAll();

    void deleteById(Long id);

    Jobs update(JobsDTO clientDTO);
}

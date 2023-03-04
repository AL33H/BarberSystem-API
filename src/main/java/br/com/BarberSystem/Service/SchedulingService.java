package br.com.BarberSystem.Service;

import br.com.BarberSystem.DTO.Request.SchedulingDTO;
import br.com.BarberSystem.Domain.Entity.Scheduling;

import java.util.List;

public interface SchedulingService {
    Scheduling verifyIfExist(Long id);

    Scheduling save(SchedulingDTO schedulingDTO);

    Scheduling findById(Long id);

    List<Scheduling> listAll();

    void deleteById(Long id);

    Scheduling update(SchedulingDTO schedulingDTO);
}

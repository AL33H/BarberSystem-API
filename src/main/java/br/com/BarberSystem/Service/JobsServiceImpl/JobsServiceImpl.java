package br.com.BarberSystem.Service.JobsServiceImpl;


import br.com.BarberSystem.DTO.Request.JobsDTO;
import br.com.BarberSystem.Domain.Entity.Jobs;
import br.com.BarberSystem.Repository.JobsRepository;
import br.com.BarberSystem.Service.JobsService;
import br.com.BarberSystem.Util.Exception.ObjectNotFoundException;
import br.com.BarberSystem.Util.Mapper.JobsMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
public class JobsServiceImpl implements JobsService {

    private final JobsRepository repository;

    @Autowired
    public JobsServiceImpl(JobsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Jobs verifyIfExist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Serviço não encontrado! ID: " + id));
    }

    @Override
    public Jobs save(JobsDTO jobsDTO) {
        return repository.save(JobsMapper.INSTANCE.toService(jobsDTO));
    }

    @Override
    public Jobs findById(Long id) {
        return verifyIfExist(id);
    }

    @Override
    public List<Jobs> listAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        verifyIfExist(id);
        repository.deleteById(id);
    }

    @Override
    public Jobs update(JobsDTO jobsDTO) {
        verifyIfExist(jobsDTO.getId());
        return repository.save(JobsMapper.INSTANCE.toService(jobsDTO));
    }
}

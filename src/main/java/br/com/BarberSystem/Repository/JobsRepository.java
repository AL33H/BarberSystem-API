package br.com.BarberSystem.Repository;

import br.com.BarberSystem.Domain.Entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,Long> {
}

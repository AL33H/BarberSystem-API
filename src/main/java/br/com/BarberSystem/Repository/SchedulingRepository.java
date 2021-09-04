package br.com.BarberSystem.Repository;

import br.com.BarberSystem.Domain.Entity.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling,Long> {
}

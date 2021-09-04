package br.com.BarberSystem.Repository;

import br.com.BarberSystem.Domain.Entity.Functionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionaryRepository extends JpaRepository<Functionary, Long> {
}

package br.com.BarberSystem.Repository;


import br.com.BarberSystem.Domain.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}

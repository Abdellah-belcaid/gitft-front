package ma.fsa.appwebcadeaux.repositories;

import ma.fsa.appwebcadeaux.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

}

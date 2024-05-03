package ma.fsa.appwebcadeaux.repositories;

import ma.fsa.appwebcadeaux.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}

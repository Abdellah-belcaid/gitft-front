package ma.fsa.appwebcadeaux.repositories;

import ma.fsa.appwebcadeaux.entities.Reduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReductionRepository extends JpaRepository<Reduction,Integer> {
    Reduction findByPourcentage(int pourcentage);

}

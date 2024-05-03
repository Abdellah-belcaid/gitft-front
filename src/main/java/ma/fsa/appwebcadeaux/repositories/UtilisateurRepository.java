package ma.fsa.appwebcadeaux.repositories;

import ma.fsa.appwebcadeaux.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
}

package ma.fsa.appwebcadeaux.repositories;


import ma.fsa.appwebcadeaux.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
   

    @Query("select c from Categorie c where c.nomCategorie like :kw")
    List<Categorie> searchCategorie(@Param("kw") String keyword);

    Optional<Categorie> findByNomCategorie(String nomCategorie);
}

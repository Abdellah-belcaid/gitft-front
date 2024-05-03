package ma.fsa.appwebcadeaux.repositories;

import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Categorie;
import ma.fsa.appwebcadeaux.entities.Reduction;
import ma.fsa.appwebcadeaux.entities.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("select c from Article c where c.nom like :kw")
    List<Article> searchArticle(@Param("kw") String keyword);

    List<Article> findByThemes(Theme theme);
    List<Article> findByNom(String nom);
    List<Article> findByReduction(Reduction reduction);
    List<Article> findByPrix(double prix);
    


    List<Article> findByReductionIdReduction(int idReduction);

    List<Article> findByCategorieIdCategorie(int idCategorie);
}


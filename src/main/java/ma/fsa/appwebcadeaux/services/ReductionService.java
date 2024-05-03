package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Reduction;
import ma.fsa.appwebcadeaux.exceptions.ReductionNotFoundException;

import java.util.List;

public interface ReductionService {
    List<Reduction> getAllReductions();
    Reduction getReductionById(int idReduction) throws ReductionNotFoundException;
    Reduction addReduction(Reduction reduction);
    Reduction updateReduction(Reduction reduction);

    void deleteReduction(int idReduction);

    List<ArticleDTO> getArticlesByReductionId(int idReduction) throws ReductionNotFoundException;

    Reduction getReductionByPourcentage(int pourcentage);
    boolean isReductionExist(int idReduction);
}

package ma.fsa.appwebcadeaux.services;


import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Reduction;
import ma.fsa.appwebcadeaux.exceptions.ReductionNotFoundException;
import ma.fsa.appwebcadeaux.mappers.MapperImpl;
import ma.fsa.appwebcadeaux.repositories.ArticleRepository;
import ma.fsa.appwebcadeaux.repositories.ReductionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class ReductionServiceImpl implements ReductionService{

    private ReductionRepository reductionRepository;
    private ArticleRepository articleRepository;
    private MapperImpl dtoMapper;
    @Override
    public List<Reduction> getAllReductions() {
        return reductionRepository.findAll();
    }


    @Override
    public Reduction getReductionById(int idReduction) throws ReductionNotFoundException {
        return reductionRepository.findById(idReduction)
                .orElseThrow(() -> new ReductionNotFoundException("Reduction not found"));

    }

    @Override
    public Reduction addReduction(Reduction reduction) {
        return reductionRepository.save(reduction);
    }

    @Override
    public Reduction updateReduction(Reduction reduction) {
        return reductionRepository.save(reduction);
    }

    @Override
    public void deleteReduction(int idReduction) {
        reductionRepository.deleteById(idReduction);
    }



    @Override
    public List<ArticleDTO> getArticlesByReductionId(int idReduction) throws ReductionNotFoundException {
        Reduction reduction = reductionRepository.findById(idReduction)
                .orElseThrow(() -> new ReductionNotFoundException("Reduction not found"));

        List<Article> articles = reduction.getArticles();
        List<ArticleDTO> articleDTOS = articles.stream()
                .map(article -> dtoMapper.fromArticle(article))
                .collect(Collectors.toList());

        return articleDTOS;
    }



    @Override
    public Reduction getReductionByPourcentage(int pourcentage) {
        return reductionRepository.findByPourcentage(pourcentage);
    }

    @Override
    public boolean isReductionExist(int idReduction) {
        return reductionRepository.existsById(idReduction);
    }
}

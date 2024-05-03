package ma.fsa.appwebcadeaux.services;

import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.dtos.CategorieDTO;
import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Categorie;
import ma.fsa.appwebcadeaux.exceptions.CategorieNotFoundException;
import ma.fsa.appwebcadeaux.mappers.MapperImpl;
import ma.fsa.appwebcadeaux.repositories.ArticleRepository;
import ma.fsa.appwebcadeaux.repositories.CategorieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;
     private ArticleRepository articleRepository;
    private MapperImpl dtoMapper;



    @Override
    public CategorieDTO saveCategorie(CategorieDTO categorieDTO) {
        Categorie categorie=dtoMapper.fromCategorieDTO(categorieDTO);
        Categorie savedCategorie = categorieRepository.save(categorie);
        return dtoMapper.fromCategorie(savedCategorie);
    }

    @Override
    public CategorieDTO getCategorie(int idCategorie) throws CategorieNotFoundException {
        Categorie categorie=categorieRepository.findById(idCategorie)
                .orElseThrow(() -> new CategorieNotFoundException("Categorie not found"));

        return dtoMapper.fromCategorie(categorie);
    }
    @Override
    public CategorieDTO updateCategorie(CategorieDTO categorieDTO) {
       Categorie categorie=dtoMapper.fromCategorieDTO(categorieDTO);
       Categorie savedCategorie = categorieRepository.save(categorie);
        return dtoMapper.fromCategorie(savedCategorie);
    }
    @Override
    public void deleteCategorie(int idCategorie) {
        categorieRepository.deleteById(idCategorie);
    }

    @Override
    public List<CategorieDTO> listCategories() {
        List<Categorie> categories = categorieRepository.findAll();
        List<CategorieDTO> categorieDTOS = categories.stream()
                .map(categorie -> dtoMapper.fromCategorie(categorie))
                .collect(Collectors.toList());

        return categorieDTOS;
    }
    @Override
    public List<ArticleDTO> article_in_categorie(int idCategorie){
        List<Article> articles = articleRepository.findByCategorieIdCategorie(idCategorie);
        return articles.stream().map(l->dtoMapper.fromArticle(l)).collect(Collectors.toList());
    }


    @Override
    public List<CategorieDTO> searchCategories(String keyword) {
        List<Categorie> categories=categorieRepository.searchCategorie(keyword);
        List<CategorieDTO> categorieDTOS = categories.stream().map(categorie -> dtoMapper.fromCategorie(categorie)).collect(Collectors.toList());
        return categorieDTOS;
    }

}

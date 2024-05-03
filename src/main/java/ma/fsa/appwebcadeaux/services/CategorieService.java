package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.dtos.CategorieDTO;
import ma.fsa.appwebcadeaux.entities.Categorie;
import ma.fsa.appwebcadeaux.exceptions.CategorieNotFoundException;

import java.util.List;

public interface CategorieService {


    CategorieDTO saveCategorie(CategorieDTO categorieDTO);

    CategorieDTO getCategorie(int idCategorie) throws CategorieNotFoundException;

    CategorieDTO updateCategorie(CategorieDTO categorieDTO);

    void deleteCategorie(int idCategorie);

    List<CategorieDTO> listCategories();

    List<ArticleDTO> article_in_categorie(int idCategorie);

    List<CategorieDTO> searchCategories(String keyword);


}

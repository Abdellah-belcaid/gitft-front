package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Theme;
import ma.fsa.appwebcadeaux.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {


        ArticleDTO saveArticle(String nom, double prix, String lien_image, int q, int idCategorie) throws CategorieNotFoundException;

        ArticleDTO getArticle(int idArticle) throws ArticleNotFoundException;

        ArticleDTO updateArticle(ArticleDTO articleDTO);

        void deleteArticle(int idArticle);

        List<ArticleDTO> listArticle();

      //  List<ArticleDTO> searchThemes(String keyword);

        /* @Override

         public List<ArticleDTO> searchThemes(String keyword) {
             List<Article> articles=articleRepository.searchArticle(keyword);
             List<ArticleDTO> articleDTOS = articles.stream().map(article -> dtoMapper.fromArticle(article)).collect(Collectors.toList());
             return articleDTOS;
         }*/
        List<ArticleDTO> getArticlesByTheme(Theme theme) throws ThemeNotFoundException;

        List<ArticleDTO> getArticlesByNomCategorie(String nomCategorie) throws CategorieNotFoundException;

        List<ArticleDTO> getArticlesByIdReduction(int idReduction);

        void redutionPrix(int idArticle, int idReduction) throws ArticleNotFoundException, ReductionNotFoundException, InvalidReductionException;
}

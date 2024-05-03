package ma.fsa.appwebcadeaux.mappers;


import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.dtos.CategorieDTO;
import ma.fsa.appwebcadeaux.dtos.ThemeDTO;
import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Categorie;
import ma.fsa.appwebcadeaux.entities.Theme;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service

public class MapperImpl {

 //mapper d'article
    public ArticleDTO fromArticle(Article article){
        ArticleDTO articleDTO=new ArticleDTO();
        BeanUtils.copyProperties(article,articleDTO);
        return  articleDTO;
    }
    public Article fromArticleDTO(ArticleDTO articleDTO){
        Article article=new Article();
        BeanUtils.copyProperties(articleDTO,article);
        return  article;
    }
// mapper de Categorie
    public CategorieDTO fromCategorie(Categorie categorie){
        CategorieDTO categorieDTO=new CategorieDTO();
        BeanUtils.copyProperties(categorie,categorieDTO);
        return  categorieDTO;
    }
    public Categorie fromCategorieDTO(CategorieDTO categorieDTO){
        Categorie categorie=new Categorie();
        BeanUtils.copyProperties(categorieDTO,categorie);
        return  categorie;
    }

    // mapper de Theme
    public ThemeDTO fromTheme(Theme theme){
        ThemeDTO themeDTO=new ThemeDTO();
        BeanUtils.copyProperties(theme,themeDTO);
        return  themeDTO;
    }
    public Theme fromThemeDTO(ThemeDTO themeDTO){
        Theme theme=new Theme();
        BeanUtils.copyProperties(themeDTO,theme);
        return  theme;
    }


}

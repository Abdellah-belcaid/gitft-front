package ma.fsa.appwebcadeaux.services;

import lombok.AllArgsConstructor;
import ma.fsa.appwebcadeaux.dtos.ArticleDTO;
import ma.fsa.appwebcadeaux.entities.Article;
import ma.fsa.appwebcadeaux.entities.Categorie;
import ma.fsa.appwebcadeaux.entities.Reduction;
import ma.fsa.appwebcadeaux.entities.Theme;
import ma.fsa.appwebcadeaux.exceptions.*;
import ma.fsa.appwebcadeaux.mappers.MapperImpl;
import ma.fsa.appwebcadeaux.repositories.ArticleRepository;
import ma.fsa.appwebcadeaux.repositories.CategorieRepository;
import ma.fsa.appwebcadeaux.repositories.ReductionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;
    private ReductionRepository reductionRepository;
    private CategorieRepository categorieRepository;
    private MapperImpl dtoMapper;



    @Override
    public ArticleDTO saveArticle(String nom, double prix, String lien_image, int q, int idCategorie) throws CategorieNotFoundException {
        Categorie categorie=categorieRepository.findById(idCategorie).orElse(null);
        if(categorie==null)
            throw new CategorieNotFoundException("Categorie not found");
        Article article=new Article();
        article.setIdArticle((int)(Math.random()*100));
        article.setNom(nom);
        article.setPrix(prix);
        article.setLien_image(lien_image);
        article.setQuantite(q);
        article.setCategorie(categorie);
        Article savedArticle = articleRepository.save(article);
        return dtoMapper.fromArticle(savedArticle);
    }

    @Override
    public ArticleDTO getArticle(int idArticle) throws ArticleNotFoundException {
        Article article=articleRepository.findById(idArticle)
                .orElseThrow(() -> new ArticleNotFoundException("Article not found"));

        return dtoMapper.fromArticle(article);
    }
    @Override
    public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        Article article=dtoMapper.fromArticleDTO(articleDTO);
        Article savedArticle = articleRepository.save(article);
        return dtoMapper.fromArticle(savedArticle);
    }
    @Override
    public void deleteArticle(int idArticle) {
        articleRepository.deleteById(idArticle);
    }

    @Override
    public List<ArticleDTO> listArticle() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleDTO> articleDTOS = articles.stream()
                .map(article -> dtoMapper.fromArticle(article))
                .collect(Collectors.toList());

        return articleDTOS;
    }

   /* @Override

    public List<ArticleDTO> searchThemes(String keyword) {
        List<Article> articles=articleRepository.searchArticle(keyword);
        List<ArticleDTO> articleDTOS = articles.stream().map(article -> dtoMapper.fromArticle(article)).collect(Collectors.toList());
        return articleDTOS;
    }*/
   @Override
   public List<ArticleDTO> getArticlesByTheme(Theme theme) throws ThemeNotFoundException {
       List<Article> articles = articleRepository.findByThemes(theme);

       if (articles.isEmpty()) {
           throw new ThemeNotFoundException("Aucun article trouvé pour ce thème");
       }

       return articles.stream()
               .map(article -> dtoMapper.fromArticle(article))
               .collect(Collectors.toList());
   }

    @Override
    public List<ArticleDTO> getArticlesByNomCategorie(String nomCategorie) throws CategorieNotFoundException{
        Categorie categorie = categorieRepository.findByNomCategorie(nomCategorie)
                .orElseThrow(() -> new CategorieNotFoundException("Categorie not found"));
        List<Article> articles = categorie.getArticles();


        List<ArticleDTO> articleDTOs = articles.stream()
                .map(article -> dtoMapper.fromArticle(article))
                .collect(Collectors.toList());

        return articleDTOs;
    }


    @Override
    public List<ArticleDTO> getArticlesByIdReduction(int idReduction) {
            List<Article> articles = articleRepository.findByReductionIdReduction(idReduction);
            List<ArticleDTO> articleDTOs = articles.stream()
                    .map(article -> dtoMapper.fromArticle(article))
                    .collect(Collectors.toList());
            return articleDTOs;
        }

@Override
public void redutionPrix(int idArticle, int idReduction) throws ArticleNotFoundException,ReductionNotFoundException, InvalidReductionException {
    Article article = articleRepository.findById(idArticle)
            .orElseThrow(() -> new ArticleNotFoundException("Article not found"));

    Reduction reduction = reductionRepository.findById(idReduction)
            .orElseThrow(() -> new ReductionNotFoundException("Reduction not found"));

    // Vérifier si la réduction est valide
    Date currentDate = new Date();
    if (currentDate.before(reduction.getDebutReduction()) || currentDate.after(reduction.getFinReduction())) {
        throw new InvalidReductionException("Cette réduction n'est pas valide actuellement");
    }

    // Appliquer la réduction de prix à l'article
    double prixInitial = article.getPrix();
    double pourcentageReduction = reduction.getPourcentage() / 100.0;
    double nouveauPrix = prixInitial * (1 - pourcentageReduction);
    article.setPrix(nouveauPrix);

    // Enregistrer les détails de l'opération de réduction
    article.setReduction(reduction);
    articleRepository.save(article);
}


    }


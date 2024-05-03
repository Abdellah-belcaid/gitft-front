package ma.fsa.appwebcadeaux.dtos;
import lombok.Data;
import ma.fsa.appwebcadeaux.entities.Categorie;


@Data
public class ArticleDTO {

    private int idArticle;
    private String nom;
    private String description;
    private String lien_image;
    private double prix;
    private int quantite ;
    private CategorieDTO categorieDTO;




}

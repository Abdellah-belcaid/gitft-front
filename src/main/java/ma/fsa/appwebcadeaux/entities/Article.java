package ma.fsa.appwebcadeaux.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idArticle;
    private String nom;
    private String description;
    private String lien_image;
    private double prix;
    private int quantite;

    @ManyToOne
    private Reduction reduction;

    @ManyToOne
    private Panier panier;

    @ManyToOne
    private Categorie categorie;

    @ManyToMany(mappedBy = "articles")
    private List<Theme> themes;


}

package ma.fsa.appwebcadeaux.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idCategorie;
    private String nomCategorie;

    @ManyToMany(mappedBy = "categories")
    private List<Theme> themes;

    @OneToMany(mappedBy = "categorie")
    private List<Article> articles;
}

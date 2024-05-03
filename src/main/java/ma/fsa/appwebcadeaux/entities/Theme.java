package ma.fsa.appwebcadeaux.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTheme;
    private String nomTheme;

    @ManyToMany
    @JoinTable(name = "Categorie_Theme",
            joinColumns = @JoinColumn(name = "idTheme"),
            inverseJoinColumns = @JoinColumn(name = "idCategorie"))
    private List<Categorie> categories;

    @ManyToMany
    @JoinTable(name = "Article_Theme",
            joinColumns = @JoinColumn(name = "idTheme"),
            inverseJoinColumns = @JoinColumn(name = "idAticle"))
    private List<Article> articles;
}

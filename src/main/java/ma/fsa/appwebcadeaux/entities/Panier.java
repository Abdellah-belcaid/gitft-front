package ma.fsa.appwebcadeaux.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPanier;

    @OneToMany(mappedBy = "panier",fetch = FetchType.LAZY)
    private List<Article> articles;

    @OneToOne
    private Utilisateur utilisateur;



}

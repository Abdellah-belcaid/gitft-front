package ma.fsa.appwebcadeaux.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idUtilisateur;
    private Date date_naissance;
    private String email;
    private String nom;
    private String prenom;
    private String mot_de_passe;


    @OneToOne(mappedBy = "utilisateur")
    private Panier panier;

}










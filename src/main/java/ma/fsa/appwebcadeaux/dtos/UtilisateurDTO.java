package ma.fsa.appwebcadeaux.dtos;
import lombok.Data;
import java.util.Date;


@Data
public class UtilisateurDTO {
     private int idUtilisateur;
     private Date date_naissance;
     private String email;
     private String nom;
     private String prenom;
     private String mot_de_passe;
     private String type;

}










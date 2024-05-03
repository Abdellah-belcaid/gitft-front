package ma.fsa.appwebcadeaux.dtos;
import lombok.Data;
import ma.fsa.appwebcadeaux.entities.Utilisateur;

import java.util.Date;


@Data
public class AdminDTO extends UtilisateurDTO {

    private int telephone;
}

package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.UtilisateurDTO;
import ma.fsa.appwebcadeaux.exceptions.UtilisateurNotFoundException;

import java.util.Date;
import java.util.List;

public interface UtilisateurService {


    UtilisateurDTO saveUtilisateur(String nom, String prenom, Date date_de_naissance, String email, String mot_de_passe);

    List<UtilisateurDTO> listUtilisateurs();

    UtilisateurDTO getUtilisateur(int idUtilisateur) throws UtilisateurNotFoundException;

    UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO);

    void deleteUtilisateur(int idUtilisateur);
}
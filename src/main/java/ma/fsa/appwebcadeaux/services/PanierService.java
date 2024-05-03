package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.PanierDTO;
import ma.fsa.appwebcadeaux.exceptions.PanierNotFoundException;

public interface PanierService {


    PanierDTO getPanier(int idPanier) throws PanierNotFoundException;

    PanierDTO createPanier(PanierDTO panierDTO);

    void deletePanier(int idPanier);
}

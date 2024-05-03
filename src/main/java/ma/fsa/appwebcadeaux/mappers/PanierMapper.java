package ma.fsa.appwebcadeaux.mappers;

import ma.fsa.appwebcadeaux.dtos.PanierDTO;
import ma.fsa.appwebcadeaux.entities.Panier;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PanierMapper {

    public PanierDTO toDto(Panier panier) {
        PanierDTO panierDTO = new PanierDTO();
        BeanUtils.copyProperties(panier, panierDTO);
        return panierDTO;
    }

    public Panier fromDto(PanierDTO panierDTO) {
        Panier panier = new Panier();
        BeanUtils.copyProperties(panierDTO, panier);
        return panier;
    }
}

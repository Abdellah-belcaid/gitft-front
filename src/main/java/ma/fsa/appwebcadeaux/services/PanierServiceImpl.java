package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.PanierDTO;
import ma.fsa.appwebcadeaux.entities.Panier;
import ma.fsa.appwebcadeaux.exceptions.PanierNotFoundException;
import ma.fsa.appwebcadeaux.mappers.PanierMapper;
import ma.fsa.appwebcadeaux.repositories.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PanierServiceImpl implements PanierService{


        private final PanierRepository panierRepository;
        private final PanierMapper panierMapper;

        @Autowired
        public PanierServiceImpl(PanierRepository panierRepository, PanierMapper panierMapper) {
            this.panierRepository = panierRepository;
            this.panierMapper = panierMapper;
        }

        @Override
        public PanierDTO getPanier(int idPanier) throws PanierNotFoundException {
            Panier panier = panierRepository.findById(idPanier)
                    .orElseThrow(() -> new PanierNotFoundException("Panier not found with id " + idPanier));
            return panierMapper.toDto(panier);
        }

        @Override
        public PanierDTO createPanier(PanierDTO panierDTO) {
            Panier panier = panierMapper.fromDto(panierDTO);
            Panier savedPanier = panierRepository.save(panier);
            return panierMapper.toDto(savedPanier);
        }

        @Override
        public void deletePanier(int idPanier) {
            panierRepository.deleteById(idPanier);
        }
    }



package ma.fsa.appwebcadeaux.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fsa.appwebcadeaux.exceptions.UtilisateurNotFoundException;
import ma.fsa.appwebcadeaux.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.fsa.appwebcadeaux.dtos.UtilisateurDTO;
import ma.fsa.appwebcadeaux.entities.Utilisateur;
import ma.fsa.appwebcadeaux.mappers.UtilisateurMapperImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService{
        @Autowired
        private UtilisateurRepository utilisateurRepository;

        @Autowired
        private UtilisateurMapperImpl utilisateurMapper;

        @Override
        public UtilisateurDTO saveUtilisateur(String nom, String prenom, Date date_de_naissance, String email, String mot_de_passe) {

            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setIdUtilisateur((int)(Math.random()*100));
            utilisateur.setDate_naissance(date_de_naissance);
            utilisateur.setEmail(email);
            utilisateur.setNom(nom);
            utilisateur.setPrenom(prenom);
            utilisateur.setMot_de_passe(mot_de_passe);
            utilisateur = utilisateurRepository.save(utilisateur);
            return utilisateurMapper.fromUtilisateur(utilisateur);
        }

        @Override
        public List<UtilisateurDTO> listUtilisateurs() {
            List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
            return utilisateurs.stream().map(utilisateur -> utilisateurMapper.fromUtilisateur(utilisateur)).collect(Collectors.toList());
        }

        @Override
        public UtilisateurDTO getUtilisateur(int idUtilisateur) throws UtilisateurNotFoundException{
            Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur)
                    .orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur not found with id " + idUtilisateur));
            return utilisateurMapper.fromUtilisateur(utilisateur);
        }

    @Override
    public UtilisateurDTO updateUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur=utilisateurMapper.fromUtilisateurDTO(utilisateurDTO);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.fromUtilisateur(savedUtilisateur);
    }

        @Override
        public void deleteUtilisateur(int idUtilisateur) {
            utilisateurRepository.deleteById(idUtilisateur);
        }
    }

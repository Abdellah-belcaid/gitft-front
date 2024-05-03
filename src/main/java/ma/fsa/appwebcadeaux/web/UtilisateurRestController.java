package ma.fsa.appwebcadeaux.web;
import ma.fsa.appwebcadeaux.dtos.UtilisateurDTO;

import ma.fsa.appwebcadeaux.exceptions.UtilisateurNotFoundException;
import ma.fsa.appwebcadeaux.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurRestController {


        @Autowired
        private UtilisateurService utilisateurService;

        @GetMapping
        public List<UtilisateurDTO> listUtilisateurs() {
            return utilisateurService.listUtilisateurs();
        }

        @GetMapping("/{idUtilisateur}")
        public UtilisateurDTO getUtilisateur(@PathVariable int idUtilisateur) throws UtilisateurNotFoundException {
            return utilisateurService.getUtilisateur(idUtilisateur);
        }
    @PostMapping("/utilisateurs")
    public UtilisateurDTO saveUtilisateur(@RequestParam String nom,
                                      @RequestParam String prenom,
                                      @RequestParam Date date_de_naissance,
                                      @RequestParam String email,
                                      @RequestParam String mot_de_passe) throws UtilisateurNotFoundException {

        return utilisateurService.saveUtilisateur(nom, prenom,date_de_naissance ,email ,mot_de_passe );
    }

        @PutMapping("/{idUtilisateur}")
        public void updateUtilisateur(@PathVariable int idUtilisateur, @RequestBody UtilisateurDTO utilisateurDTO) {
            utilisateurDTO.setIdUtilisateur(idUtilisateur);
            utilisateurService.updateUtilisateur(utilisateurDTO);
        }

        @DeleteMapping("/{idUtilisateur}")
        public void deleteUtilisateur(@PathVariable int idUtilisateur) {
            utilisateurService.deleteUtilisateur(idUtilisateur);
        }
    }



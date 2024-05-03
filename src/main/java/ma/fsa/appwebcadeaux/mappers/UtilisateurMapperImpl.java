package ma.fsa.appwebcadeaux.mappers;

import ma.fsa.appwebcadeaux.dtos.AdminDTO;
import ma.fsa.appwebcadeaux.dtos.ClientDTO;
import ma.fsa.appwebcadeaux.dtos.UtilisateurDTO;
import ma.fsa.appwebcadeaux.entities.Admin;
import ma.fsa.appwebcadeaux.entities.Client;
import ma.fsa.appwebcadeaux.entities.Utilisateur;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurMapperImpl {
    public UtilisateurDTO fromUtilisateur(Utilisateur utilisateur){
        UtilisateurDTO utilisateurDTO=new UtilisateurDTO();
        BeanUtils.copyProperties(utilisateur,utilisateurDTO);
        return  utilisateurDTO;
    }
    public Utilisateur fromUtilisateurDTO(UtilisateurDTO utilisateurDTO){
        Utilisateur utilisateur=new Utilisateur();
        BeanUtils.copyProperties(utilisateurDTO,utilisateur);
        return  utilisateur;
    }

    public ClientDTO fromClient(Client client){
        ClientDTO clientDTO=new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
      clientDTO.setType(client.getClass().getSimpleName());
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO){
        Client client=new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return client;
    }

    public AdminDTO fromAdmin(Admin admin ){
        AdminDTO adminDTO=new AdminDTO();
        BeanUtils.copyProperties(admin,adminDTO);
        adminDTO.setType(admin.getClass().getSimpleName());
        return adminDTO;
    }

    public Admin fromAdminDTO(AdminDTO adminDTO){
        Admin admin=new Admin();
        BeanUtils.copyProperties(adminDTO,admin);
        return admin;
    }

}

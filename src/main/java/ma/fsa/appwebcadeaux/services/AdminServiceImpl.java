package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.AdminDTO;
import ma.fsa.appwebcadeaux.entities.Admin;
import ma.fsa.appwebcadeaux.exceptions.AdminNotFoundException;
import ma.fsa.appwebcadeaux.mappers.UtilisateurMapperImpl;
import ma.fsa.appwebcadeaux.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UtilisateurMapperImpl utilisateurMapper;

    @Override
    public AdminDTO saveAdmin(AdminDTO adminDTO) {
        Admin admin = utilisateurMapper.fromAdminDTO(adminDTO);
        admin = adminRepository.save(admin);
        return utilisateurMapper.fromAdmin(admin);
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(utilisateurMapper::fromAdmin).collect(Collectors.toList());
    }

    @Override
    public AdminDTO getAdminById(int idAdmin) throws AdminNotFoundException{
        Admin admin = adminRepository.findById(idAdmin)
                .orElseThrow(() -> new AdminNotFoundException("Admin not found with id " + idAdmin));
        return utilisateurMapper.fromAdmin(admin);
    }

    @Override
    public void updateAdmin(AdminDTO adminDTO) {
        Admin admin = utilisateurMapper.fromAdminDTO(adminDTO);
        adminRepository.save(admin);
    }

    @Override
    public void deleteAdminById(int idAdmin) {
        adminRepository.deleteById(idAdmin);
    }
}

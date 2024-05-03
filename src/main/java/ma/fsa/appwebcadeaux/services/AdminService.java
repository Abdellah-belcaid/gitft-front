package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.AdminDTO;
import ma.fsa.appwebcadeaux.exceptions.AdminNotFoundException;

import java.util.List;

public interface AdminService {
    AdminDTO saveAdmin(AdminDTO adminDTO);
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminById(int adminId) throws AdminNotFoundException;
    void updateAdmin(AdminDTO adminDTO);
    void deleteAdminById(int adminId);
}
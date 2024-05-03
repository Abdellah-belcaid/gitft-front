package ma.fsa.appwebcadeaux.web;

import ma.fsa.appwebcadeaux.dtos.AdminDTO;
import ma.fsa.appwebcadeaux.exceptions.AdminNotFoundException;
import ma.fsa.appwebcadeaux.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminRestController {


        @Autowired
        private AdminService adminService;

        @GetMapping
        public List<AdminDTO> getAllAdmins() {
            return adminService.getAllAdmins();
        }

        @GetMapping("/{idAdmin}")
        public AdminDTO getAdminById(@PathVariable int idAdmin) throws AdminNotFoundException {
            return adminService.getAdminById(idAdmin);
        }

        @PostMapping
        public AdminDTO saveAdmin(@RequestBody AdminDTO adminDTO) {
            return adminService.saveAdmin(adminDTO);
        }

    }

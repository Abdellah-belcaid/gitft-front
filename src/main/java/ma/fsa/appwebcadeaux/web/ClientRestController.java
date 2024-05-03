package ma.fsa.appwebcadeaux.web;

import ma.fsa.appwebcadeaux.dtos.ClientDTO;
import ma.fsa.appwebcadeaux.exceptions.ClientNotFoundException;

import ma.fsa.appwebcadeaux.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/clients")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{idClient}")
    public ClientDTO getClientById(@PathVariable int idClient) throws ClientNotFoundException {
        return clientService.getClientById(idClient);
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return clientService.saveClient(clientDTO);
    }

    @PutMapping("/{idClient}")
    public void updateClient(@PathVariable int idClient, @RequestBody ClientDTO clientDTO) {
        clientDTO.setIdUtilisateur(idClient);
        clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/{idClient}")
    public void deleteClientById(@PathVariable int idClient) {
        clientService.deleteClientById(idClient);
    }

    }




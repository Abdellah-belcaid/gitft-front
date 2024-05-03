package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.ClientDTO;
import ma.fsa.appwebcadeaux.exceptions.ClientNotFoundException;

import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);

    List<ClientDTO> getAllClients();

    ClientDTO getClientById(int idClient) throws ClientNotFoundException;

    void updateClient(ClientDTO clientDTO);

    void deleteClientById(int idClient);
}
package ma.fsa.appwebcadeaux.services;

import ma.fsa.appwebcadeaux.dtos.ClientDTO;
import ma.fsa.appwebcadeaux.entities.Client;
import ma.fsa.appwebcadeaux.exceptions.ClientNotFoundException;
import ma.fsa.appwebcadeaux.mappers.UtilisateurMapperImpl;
import ma.fsa.appwebcadeaux.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UtilisateurMapperImpl utilisateurMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = utilisateurMapper.fromClientDTO(clientDTO);
        client = clientRepository.save(client);
        return utilisateurMapper.fromClient(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(utilisateurMapper::fromClient).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClientById(int idClient) throws ClientNotFoundException{
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new ClientNotFoundException("Client not found with id " + idClient));
        return utilisateurMapper.fromClient(client);
    }

    @Override
    public void updateClient(ClientDTO clientDTO) {
        Client client = utilisateurMapper.fromClientDTO(clientDTO);
        clientRepository.save(client);
    }

    @Override
    public void deleteClientById(int idClient) {
        clientRepository.deleteById(idClient);
    }
}

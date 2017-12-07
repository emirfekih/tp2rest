package tn.insat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.entities.Client;
import tn.insat.repositories.ClientRepository;

import java.util.List;

/**
 * Created by ASUS on 07/12/2017.
 */
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public Client getById(Integer id){
        return(clientRepository.findByIdClient(id));
    }
    public Client getByNom(String nom){

        return(clientRepository.findByNom(nom));
    }
    public List<Client> getAll(){return(clientRepository.findAll());}
}

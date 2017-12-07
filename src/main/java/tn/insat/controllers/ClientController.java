package tn.insat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.insat.entities.Client;
import tn.insat.repositories.ClientRepository;

import java.sql.Date;
import java.util.List;

/**
 * Created by ASUS on 06/12/2017.
 */
@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @RequestMapping("/client/getAll")
    @ResponseBody()
    public List<Client> getAll(){
        return(clientRepository.findAll());
    }

    @RequestMapping("/client/add")
    @ResponseBody()
    public Client add(String naissance,String email,String nom){
        Client c = new Client(nom,email,Date.valueOf(naissance));
        clientRepository.save(c);
        return(c);
    }

    @RequestMapping("/client/getByNom")
    @ResponseBody()
    public Client getById(String nom){

        return(clientRepository.findByNom(nom));
    }



}

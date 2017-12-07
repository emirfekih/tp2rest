package tn.insat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.insat.entities.Client;

import java.util.List;

/**
 * Created by ASUS on 06/12/2017.
 */
public interface ClientRepository extends JpaRepository<Client,Integer> {
    public Client findByNom(String nom);
    public Client findByIdClient(Integer id);
    public List<Client> findAll();
}

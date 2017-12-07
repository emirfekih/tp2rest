package tn.insat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.entities.Chambre;
import tn.insat.repositories.ChambreRepository;

import java.util.List;

/**
 * Created by ASUS on 07/12/2017.
 */
@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    public List<Chambre> getAll(){
        return(chambreRepository.findAll());
    }
    public Chambre getById(Integer id){

        return(chambreRepository.findChambreByIdChambre(id));

    }

    public Chambre add(Integer id){

        Chambre ch= new Chambre(id);
        chambreRepository.save(ch);

        return(ch);

    }
}

package tn.insat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.insat.entities.Chambre;

import java.util.Collection;
import java.util.List;

/**
 * Created by ASUS on 06/12/2017.
 */
public interface ChambreRepository extends JpaRepository<Chambre,Integer> {
      public List<Chambre> findChambreByIdChambreNotIn(Collection<Integer> idChambres);
      public List<Chambre> findAll();
      public Chambre findChambreByIdChambre(Integer id);




}

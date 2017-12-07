package tn.insat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.insat.entities.Reservation;

import java.sql.Date;
import java.util.List;

/**
 * Created by ASUS on 06/12/2017.
 */
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

public List<Reservation> findReservationByArriveeIsGreaterThanEqualAndDepartIsLessThanEqual(Date arrivee, Date depart);
public List<Reservation> findAllByClient_IdClient(Integer id);


}

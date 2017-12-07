package tn.insat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.insat.entities.Chambre;
import tn.insat.entities.Option;
import tn.insat.entities.Reservation;
import tn.insat.repositories.ChambreRepository;
import tn.insat.repositories.ClientRepository;
import tn.insat.repositories.ReservationRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 07/12/2017.
 */

@Service
public class ReservationService {

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ClientRepository clientRepository;



    public List <Reservation> getReservationsByClientId(Integer id){
        return(reservationRepository.findAllByClient_IdClient(id));

    }

    public Reservation addReservation(String arrivee, String depart, int idChambre,int idClient){


        Reservation r = new Reservation(Date.valueOf(arrivee),Date.valueOf(depart));
        r.setChambre(chambreRepository.findOne(idChambre));
        r.setClient(clientRepository.findOne(idClient));
        r.getOptions().add(new Option(new BigDecimal("72.00"),"PC"));
        r.getOptions().add(new Option(new BigDecimal("20.00"),"Triple"));
        reservationRepository.save(r);
        return(r);

    }

    public List<Chambre> getChambresDispo(String arrivee,String depart){
        List<Integer> chambres= new ArrayList<>(1);
        List<Reservation> reservations = reservationRepository.findReservationByArriveeIsGreaterThanEqualAndDepartIsLessThanEqual(Date.valueOf(arrivee),Date.valueOf(depart));
        for (int i=0;i<reservations.size();i++)
        {
            chambres.add(reservations.get(i).getChambre().getIdChambre());
        }
        return(chambreRepository.findChambreByIdChambreNotIn(chambres));

    }
    public List <Reservation> getReservationByDate(String arrivee,String depart){
        return(reservationRepository.findReservationByArriveeIsGreaterThanEqualAndDepartIsLessThanEqual(Date.valueOf(arrivee),Date.valueOf(depart)));
    }


}





package tn.insat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.insat.entities.Chambre;
import tn.insat.entities.Option;
import tn.insat.repositories.ChambreRepository;
import tn.insat.entities.Reservation;
import tn.insat.repositories.ClientRepository;
import tn.insat.repositories.ReservationRepository;
import tn.insat.services.ReservationService;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ASUS on 06/12/2017.
 */
@RestController
public class ReservationController {

    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ReservationService reservationService;



    @RequestMapping("/reservation/historique")
    @ResponseBody
    public List<Reservation> historique(Integer id){
        return(reservationService.getReservationsByClientId(id));
    }


    @RequestMapping("/reservation/add")
    @ResponseBody()
    public Reservation addReservation(String arrivee, String depart, int idChambre,int idClient){


       return(reservationService.addReservation(arrivee,depart,idChambre,idClient));

    }

    @RequestMapping("/reservation/getChambreDispo")
    @ResponseBody
    public Collection<Chambre> getChambreDispoByDate(String arrivee, String depart){

        return(reservationService.getChambresDispo(arrivee,depart));
    }

    @RequestMapping("/reservation/getByDate")
    @ResponseBody
    public List<Reservation> getReservationsByDate(String arrivee, String depart){

        return(reservationService.getReservationByDate(arrivee,depart));
    }




}

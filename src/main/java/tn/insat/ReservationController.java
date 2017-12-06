package tn.insat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

/**
 * Created by ASUS on 06/12/2017.
 */
@RestController
public class ReservationController {

    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservation/add")
    @ResponseBody()
    public void addReservation(String arrivee,String depart,int id){


        Reservation r = new Reservation(Date.valueOf(arrivee),Date.valueOf(depart));
        r.setChambre(chambreRepository.findOne(id));
        System.out.println( r.getChambre().getIdChambre());
        System.out.println( r.getArrivee());
        System.out.println(r.getDepart());
        reservationRepository.save(r);

    }


}

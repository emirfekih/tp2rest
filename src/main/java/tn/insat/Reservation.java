package tn.insat;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by ASUS on 06/12/2017.
 */
@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idReservation;


    private Date arrivee;

    private Date depart;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="chambre_id")
    private Chambre chambre;


    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Date getArrivee() {
        return arrivee;
    }

    public void setArrivee(Date arrivee) {
        this.arrivee = arrivee;
    }

    public Date getDepart() {
        return depart;
    }

    public void setDepart(Date depart) {
        this.depart = depart;
    }

    public Reservation(Date arrivee, Date depart) {
        this.arrivee = arrivee;
        this.depart = depart;

    }

    public Reservation() {
    }
}

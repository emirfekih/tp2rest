package tn.insat.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne()
    @JoinColumn(name="chambre_id")
    @JsonIgnoreProperties("reservations")
    private Chambre chambre;

    @ManyToOne()
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties("reservations")
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("reservations")
    @JoinTable(name = "reservations_options",
            joinColumns = @JoinColumn(name = "id_reservation"),
            inverseJoinColumns = @JoinColumn(name = "id_option")
    )
    private Set<Option> options;

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    public Reservation(Date arrivee, Date depart) {
        this.arrivee = arrivee;
        this.depart = depart;
        this.options=new HashSet<>(0);

    }

    public Reservation() {
    }



}

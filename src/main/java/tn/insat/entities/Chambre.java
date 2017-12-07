package tn.insat.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ASUS on 06/12/2017.
 */


@Entity
@Table(name="chambres")
public class Chambre {

    @Id
    private Integer idChambre;

    @OneToMany(mappedBy="chambre", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnoreProperties("chambre")
    private Set<Reservation> reservations ;

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Integer idChambre) {
        this.idChambre = idChambre;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Chambre(Integer id) {
        this.idChambre = id;
        this.reservations= new HashSet<>(0);
    }

    public Chambre() {
    }
}

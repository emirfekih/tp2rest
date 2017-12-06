package tn.insat;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ASUS on 06/12/2017.
 */


@Entity
@Table(name="chambres")
public class Chambre {

    @Id
    private int idChambre;

    @OneToMany(mappedBy="chambre", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Reservation> reservations ;

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Chambre(int id) {
        this.idChambre = id;
    }

    public Chambre() {
    }
}

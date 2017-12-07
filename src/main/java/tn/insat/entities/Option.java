package tn.insat.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ASUS on 07/12/2017.
 */
@Entity
@Table(name="options")
public class Option {

    @Id
    @GeneratedValue
    private int idOption;


    private BigDecimal prix;
    private String description;

    @ManyToMany(mappedBy="options")
    private Set<Reservation> reservations;

    public Option() {
    }

    public Option(BigDecimal prix, String description) {
        this.prix = prix;
        this.description = description;
        this.reservations = new HashSet<>(0);
    }

    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}

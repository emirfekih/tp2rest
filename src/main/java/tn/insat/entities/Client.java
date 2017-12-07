package tn.insat.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ASUS on 06/12/2017.
 */
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue()
    private int idClient;

    private String nom;

    private String email;

    private Date dateDeNaissance;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;


    public Client() {
    }

    public Client(String nom, String email, Date dateDeNaissance) {
        this.nom = nom;
        this.email = email;
        this.dateDeNaissance = dateDeNaissance;
        this.reservations=new HashSet<>(0);
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}

package tn.insat;

import javax.persistence.*;

/**
 * Created by ASUS on 06/12/2017.
 */
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue()
    private int id;
    private String nom;


}

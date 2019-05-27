package com.itransition.webapp.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "compos_table")
public class Composition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private Long user_id; //DELETE??!!!
    private String compos_name;
    private String description;
    private Date creation_date;
    private Date edition_date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private User user;

    public Composition() {
    }

    public Composition(String compos_name, String description, Date creation_date, Date edition_date) {
        this.compos_name = compos_name;
        this.description = description;
        this.creation_date = creation_date;
        this.edition_date = edition_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompos_name() {
        return compos_name;
    }

    public void setCompos_name(String compos_name) {
        this.compos_name = compos_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getEdition_date() {
        return edition_date;
    }

    public void setEdition_date(Date edition_date) {
        this.edition_date = edition_date;
    }



}

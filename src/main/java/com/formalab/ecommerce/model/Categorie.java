package com.formalab.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nom",nullable = false)
    private String nom;

    @OneToMany(mappedBy = "categorie",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Produit> produits;

    public Categorie(){
        super();
    }

    public Categorie(Integer id,String nom) {
        this.id=id;
        this.nom=nom;
    }


    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}

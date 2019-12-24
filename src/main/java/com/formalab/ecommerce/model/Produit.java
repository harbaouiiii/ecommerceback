package com.formalab.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;

@Entity
@Table(name="produit")
public class Produit {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="nom", nullable = false)
    private String nom;
    @Column(name="prix_achat", nullable = false)
    private double prixAchat;
    @Column(name="prix_vente", nullable = false)
    private double prixVente;
    @ManyToOne
    @JoinColumn
    private Categorie categorie;

    public Produit() {
        super();
    }

    public Produit(Integer id,String nom, double prixAchat, double prixVente, Categorie categorie) {
        this.id=id;
        this.nom = nom;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.categorie = categorie;
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

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}

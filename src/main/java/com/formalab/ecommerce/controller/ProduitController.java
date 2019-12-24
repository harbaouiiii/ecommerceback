package com.formalab.ecommerce.controller;

import com.formalab.ecommerce.dao.ProduitRepository;
import com.formalab.ecommerce.model.Categorie;
import com.formalab.ecommerce.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/rest/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;

    @GetMapping(value="/allProduit")
    public List<Produit> allProduit(){
        return produitRepository.findAll();
    }

    @GetMapping(value="/produit/{id}")
    public ResponseEntity<Produit> produit(@PathVariable Integer id) throws Exception{
        final Produit produit = produitRepository.findById(id).orElseThrow(()->new Exception("Le produit n'existe pas"));
        return ResponseEntity.ok().body(produit);
    }

    @PostMapping(value="/addProduit")
    public Produit addProduit(@Valid @RequestBody Produit produit){
        return produitRepository.save(produit);
    }

    @PutMapping(value="/produit/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Integer id, @Valid @RequestBody Produit produitDetails) throws Exception{
        Produit produit = produitRepository.findById(id).orElseThrow(()->new Exception("Le produit n'existe pas"));
        produit.setNom(produitDetails.getNom());
        produit.setPrixAchat(produitDetails.getPrixAchat());
        produit.setPrixVente(produitDetails.getPrixVente());
        produit.setCategorie(produitDetails.getCategorie());
        final Produit updatedProduit = produitRepository.save(produit);
        return ResponseEntity.ok(updatedProduit);
    }

    @DeleteMapping(value="/produit/{id}")
    public Map<String,Boolean> deleteProduit(@PathVariable Integer id) throws Exception{
        Produit produit = produitRepository.findById(id).orElseThrow(()->new Exception("Le produit n'existe pas"));
        produitRepository.delete(produit);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Le produit est supprimé!",Boolean.TRUE);
        return response;
    }

}

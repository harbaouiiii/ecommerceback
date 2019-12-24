package com.formalab.ecommerce.dao;

import com.formalab.ecommerce.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories("com.formalab.ecommerce.dao")
public interface ProduitRepository extends JpaRepository<Produit,Integer> {

}

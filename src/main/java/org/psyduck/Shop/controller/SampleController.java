package org.psyduck.Shop.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.psyduck.Shop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    EntityManager em;

    @RequestMapping(value="/", produces= {"text/plain"})
    public String index() {

        final Query query = em.createQuery("SELECT p FROM org.psyduck.Shop.domain.Product p");
        final List<Product> prods=query.getResultList();


        return prods.isEmpty()?"pusto":"niepusto";
    }
}

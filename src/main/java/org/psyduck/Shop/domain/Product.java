package org.psyduck.Shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator="prodSeq")
    @SequenceGenerator(name="prodSeq",sequenceName="PROD_SEQ", allocationSize=1)
    private Integer productId;

    @Column(name="NAME")
    private String name;

    @Column(name="PRICE")
    private Double price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(final Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }


}

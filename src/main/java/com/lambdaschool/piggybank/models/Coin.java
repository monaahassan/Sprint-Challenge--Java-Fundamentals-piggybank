package com.lambdaschool.piggybank.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Coins")
public class Coin
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coinid;
    private int quantity;
    private double value;
    private String name;
    private String nameplural;

    public Coin()
    {
        // required JPA
    }
    public Coin(int quantity, double value, String name, String nameplural) {
        this.quantity = quantity;
        this.value = value;
        this.name = name;
        this.nameplural = nameplural;
    }
    public long getCoinId() {
        return coinid;
    }
    public void setCoinId(long coinid) {
        this.coinid = coinid;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNamePlural() {
        return nameplural;
    }
    public void setNamePlural(String nameplural) {
        this.nameplural = nameplural;
    }
    @Override
    public String toString() {
        return "Coin{" +
                "coinid=" + coinid +
                ", quantity=" + quantity +
                ", value=" + value +
                ", name='" + name + '\'' +
                ", nameplural='" + nameplural + '\'' +
                '}';
    }
}
package com.hibernate.example;

import javax.persistence.*;

@Entity
public class Sample {
    @Id
    @GeneratedValue
    private Integer id;

    @Basic(fetch = FetchType.EAGER, optional = true)
    private String  name;

    @Transient
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

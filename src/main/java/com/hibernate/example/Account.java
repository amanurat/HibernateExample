package com.hibernate.example;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Date: 10/29/2014
 * Time: 10:50 AM
 *
 * @author assanai.manurat
 */
@Entity
public class Account {
    private String description;

    @Id
    private AccountPk id;

    public Account(String description) {
        this.description = description;
    }

    protected Account() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountPk getId() {
        return id;
    }

    public void setId(AccountPk id) {
        this.id = id;
    }
}

package com.codeup.springblog.models;

import com.codeup.springblog.controllers.CoffeeController;
import com.codeup.springblog.repositories.CoffeeRepository;

import javax.persistence.*;

@Entity
@Table(name = "coffees")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, length = 50)
    private long id;
    @Column(nullable = false, length = 50)
    private String roast;
    @Column(nullable = false, length = 50)
    private String origin;

    public Coffee() {
    }

    public Coffee(String roast, String origin) {
        this.roast = roast;
        this.origin = origin;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getRoast() {
        return roast;
    }

    public void setRoast(String roast) {
        this.roast = roast;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}

package com.agfa.demo.persistence;

import com.agfa.demo.domain.PlantKingdom.Vegetable;

import javax.persistence.*;

@Entity
public class PlantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(name="TYPE_PARENT")
    private String parent;

    protected PlantEntity(){}

    public PlantEntity(Vegetable vegetable){
        type = vegetable.getType();
        parent = vegetable.parent();
    }
}

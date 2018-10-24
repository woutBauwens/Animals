package com.agfa.demo.persistence;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "LIVING_TYPE", discriminatorType = DiscriminatorType.STRING, length = 10)
public abstract class LivingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String type;

    @Column(name="PARENT")
    String parent;
}

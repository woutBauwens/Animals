package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class FoodService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(FoodEntity foodEntity){
        entityManager.persist(foodEntity);
    }
}

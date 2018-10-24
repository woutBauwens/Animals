package com.agfa.demo.persistence;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FoodService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(FoodEntity foodEntity) {
        entityManager.persist(foodEntity);
        personalQuery();
    }

    public void personalQuery() {
        TypedQuery<AnimalEntity> query = entityManager.createQuery("select animal from AnimalEntity animal where animal.name = :name", AnimalEntity.class).setParameter("name", "Wout");
        List<AnimalEntity> animal = query.getResultList();
        animal.forEach(System.out::println);
    }

    public FoodEntity getFood(String type) {
        return entityManager.find(FoodEntity.class, type);
    }
}
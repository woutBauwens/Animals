package com.agfa.demo.persistence;

import com.agfa.demo.domain.PlantKingdom.Plant;
import com.agfa.demo.domain.PlantKingdom.Vegetable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PlantService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Vegetable vegetable){
        insert(new PlantEntity(vegetable));
    }

    private void insert(PlantEntity plantEntity){
        entityManager.persist(plantEntity);
    }

    public void updateIfEmpty(Plant plant) {
        PlantEntity plantEntity = new PlantEntity(plant);
        if(!entityManager.contains(plantEntity)){
            entityManager.persist(plantEntity);
        } else {
            System.out.println("The Plant already exists");
        }
    }

    public List<PlantEntity> getAll() {
        return entityManager.createNamedQuery("getAllPlantEntities", PlantEntity.class).getResultList();
    }
}

package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.Animal;
import com.agfa.demo.domain.Kingdom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AnimalService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Animal animal){
        AnimalEntity animalEntity = new AnimalEntity(animal);
        insert(animalEntity);
    }

    public void insert(AnimalEntity animalEntity){
        entityManager.persist(animalEntity);
    }

    public List<AnimalEntity> getAllAnimals(){
        return entityManager.
                createQuery("SELECT animal FROM AnimalEntity animal JOIN animal.eats eats", AnimalEntity.class).getResultList();
    }
}
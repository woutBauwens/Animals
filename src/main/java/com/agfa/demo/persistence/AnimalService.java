package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class AnimalService {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(AnimalInterface animalInterface){
        AnimalEntity animalEntity = new AnimalEntity(animalInterface);
        insert(animalEntity);
    }

    public void insert(AnimalEntity animalEntity){
        entityManager.persist(animalEntity);
    }

    public AnimalInterface retrieve(Long animalId){
        return AnimalEntity.adapt(entityManager.find(AnimalEntity.class, animalId));
    }

    public List<AnimalEntity> getAllAnimals(){
        return entityManager.
                createQuery("SELECT animal FROM AnimalEntity animal JOIN animal.eats eats").getResultList();
    }
}
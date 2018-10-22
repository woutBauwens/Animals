package com.agfa.demo.persistence;

import com.agfa.demo.domain.AnimalKingdom.AnimalInterface;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        List<FoodEntity> foods = getFood(); //animalInterface.eats().stream().map(a -> entityManager.find(FoodEntity.class, a.getType())).collect(Collectors.toList());
        animalEntity.buildFoodKingdom(foods);
        insert(animalEntity);
    }

    public void insert(AnimalEntity animalEntity){
        entityManager.persist(animalEntity);
    }

    public AnimalInterface retrieve(Long animalId){
        return AnimalEntity.adapt(entityManager.find(AnimalEntity.class, animalId));
    }

    public List<AnimalInterface> getAll(){
        return  entityManager.createQuery("SELECT *").getResultList();
    }

    public List<FoodEntity> getFood(){return entityManager.createQuery("FROM FoodEntity").getResultList();}


}

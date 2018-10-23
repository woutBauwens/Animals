package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Food;
import com.agfa.demo.domain.KingdomFactory;
import com.agfa.demo.persistence.PlantEntity;
import com.agfa.demo.persistence.PlantService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class BananaTree extends Plant {

    @Resource
    private PlantService plantService;

    @Override
    public void grow() {
        plantService.updateIfEmpty(this);
        plantService.insert(new Banana());
    }

    @Override
    public Vegetable weedSeed() {
        return new BananaTree();
    }

    @Override
    public boolean is(String type) {
        return type.equals(type());
    }

    public List<Vegetable> getTree(){
        return plantService.getAll().stream().map(BananaTree::adapt).collect(Collectors.toList());
    }

    private static Vegetable adapt(PlantEntity plantEntity) {
        try {
            return KingdomFactory.createVegetable(plantEntity.getType());
        } catch (NullPointerException exception) {
            System.out.println("Plant not found. Creating new banana");
            return new Banana();
        }
    }
}

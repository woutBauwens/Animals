package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.KingdomManager;
import com.agfa.demo.domain.Kingdom;
import com.agfa.demo.persistence.PlantEntity;
import com.agfa.demo.persistence.PlantService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BananaTree extends Plant {

    @Resource
    private PlantService plantService;

    private boolean isGrown;

    @Override
    public void grow(int amount) {
        if(!isGrown) {
            plantService.updateIfEmpty(this);
            isGrown = true;
        }
        Stream.generate(() -> new Banana(name))
            .limit(amount).forEach(plantService::insert);
    }

    @Override
    public Vegetable weedSeed(String seed) {
        name = seed;
        plantService.updateIfEmpty(this);
        return this;
    }

    @Override
    public boolean is(String type) {
        return type.equals(type());
    }

    @Override
    public List<Kingdom> getTree(){
        return plantService.getAll().stream().map(BananaTree::mapToVegetable).collect(Collectors.toList());
    }

    private static Kingdom mapToVegetable(PlantEntity plantEntity) {
        Optional<Vegetable> plant = KingdomManager.asVegetable(plantEntity.getType());
        if(plant.isPresent())
            return plant.get().giveName(plantEntity.getName());
        else {
            return new BananaTree().giveName(plantEntity.getName());
        }
    }
}

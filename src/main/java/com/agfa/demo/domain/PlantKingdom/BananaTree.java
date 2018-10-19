package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.domain.Food;
import com.agfa.demo.persistence.AnimalService;
import com.agfa.demo.persistence.FoodEntity;
import com.agfa.demo.persistence.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BananaTree implements Plant {

    @Autowired
    private List<Banana> bananas;

    @Autowired
    private FoodService foodService;

    protected BananaTree(){
        bananas = new ArrayList<>();
        grow();
    }

    private List<FoodEntity> getFoodEntity(){
        return bananas.stream().map(FoodEntity::new).collect(Collectors.toList());
    }

    @Override
    public void grow() {
        bananas.add(new Banana());
    }

    @Override
    public Plant weedSeed() {
        return new BananaTree();
    }

    @Override
    public void persistFoodFromPlant() {
        getFoodEntity().stream().forEach(foodService::insert);
    }
}
